package Software_Master_A.client_and_server;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ref.Cleaner.Cleanable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class ServerTest 
{

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		Department chemistry = new Department("Chemistry");
		for(int i=0; i<3; i++)
		{
			PlanFile p = new PlanFile(2000+i, true, new Centre());
			p.plan.setName("Chemistry"+i);
			chemistry.addPlan(2000+i,p);
		}
//		assertEquals("Chemistry1", chemistry.plans.get(2001).plan.getName());
		String username = "Admin";
		String password = "helloworld";
		Account admin = new Account(username, password,true);
		admin.setCookie("12sdfsdg");
		PlanInterface server = new Server(admin);
		//server.addDepartment(chemistry.departmentName, admin.cookie);
		
		Server myServer = (Server)server;
		myServer.departmentMap.put(chemistry.departmentName, chemistry);
		
		Registry registry = LocateRegistry.createRegistry(100);
		PlanInterface stub = (PlanInterface)UnicastRemoteObject.exportObject(server, 0);
		registry.rebind("Server", stub);
	}

	@Test
	void loginTest() throws RemoteException, NotBoundException
	{
		//We think the client will handle the RMI stuff.
		//So, once the Client object is created, it should
		//have fetched its server already.
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		assertEquals("12sdfsdg", cookie);
		
		//We will go ahead and add some users
		
		client.addUser("user1", "123456", "Chemistry", cookie);
		client.addAdmin("admin2", "78910j", "Chemistry", cookie);
		
		Client client2 = new Client();
		
		//wrong username
		String  cookie2 =client2.login("user", "123456");
		assertEquals(null, cookie2);
		
		//wrong password
		cookie2 = client2.login("user1", "12345");
		assertEquals(null, cookie2);
		
		//correct, so should not be null
		cookie2 = client2.login("user1", "123456");
		assertNotEquals(null, cookie2);
		
		
	}
	
	@Test
	void getPlanTest() throws RemoteException
	{
		
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		
		client.addUser("chemist1", "123456", "Chemistry", cookie);
		//switch to user
		cookie = client.login("chemist1", "123456");
		PlanFile planFile = client.getPlan(2001,cookie);
		
		
		assertEquals(2001, planFile.year);
		assertEquals("Chemistry1", planFile.plan.getName());
		
		//nonexistent file above range
		planFile = client.getPlan(2005, cookie);
		assertEquals(null, planFile);
		
		//nonexistent file below range
		planFile = client.getPlan(1923, cookie);
		assertEquals(null, planFile);
	}

	@Test
	void editPlanTest() throws RemoteException
	{
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		
		client.addUser("chemist2", "123456", "Chemistry", cookie);
		//Make a file not editable
		client.flagPlan("Chemistry", 2002, false, cookie);
		cookie = client.login("chemist2", "123456");
		
		//get the non-editable file
		PlanFile planFile = client.getPlan(2002, cookie);
		planFile.plan.setName("Non-editable file");
		
		//push the non editable file should fail
		boolean result = client.pushPlan(planFile, cookie);
		assertEquals(false, result);
		
		//try an editable file
		planFile = client.getPlan(2001, cookie);
		planFile.plan.setName("Should work");
		result = client.pushPlan(planFile, cookie);
		assertEquals(true, result);
		
		//verify if the change is successful
		PlanFile planFile2 = client.getPlan(2001, cookie);
		assertEquals(planFile.year, planFile2.year);
		assertEquals(planFile.plan.getName(), planFile2.plan.getName());
		
	}
	
	@Test
	void addUserTest() throws RemoteException
	{
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		client.addUser("chemist3", "123456", "Chemistry", cookie);
		
		cookie = client.login("chemist3", "123456");
		assertNotEquals(null, cookie);
		
		//Client should get the planfile from its department correctly
		PlanFile planFile = client.getPlan(2000, cookie);
		assertEquals(2000, planFile.year);
		assertEquals(true,planFile.editable);
		assertEquals("Chemistry0", planFile.plan.getName());
		
		//it should not be able to access admin methods
		boolean result = client.addAdmin("hh", "sd", "Chemistry", cookie);
		assertEquals(false, result);
		
		result= client.addDepartment("Cool", cookie);
		assertEquals(false, result);
		
		result = client.addUser("haha", "123", "Chemistry", cookie);
		assertEquals(false, result);
		
		//add a same user again with different password
		// should rewrite the password
		cookie = client.login("Admin", "helloworld");
		client.addUser("chemist3", "87871234", "Chemistry", cookie);
		
		cookie = client.login("chemist3", "87871234");
		planFile = client.getPlan(2000, cookie);
		assertEquals(2000, planFile.year);
		assertEquals(true,planFile.editable);
		assertEquals("Chemistry0", planFile.plan.getName());
		
		//it should not be able to access admin methods
		result = client.addAdmin("hh", "sd", "Chemistry", cookie);
		assertEquals(false, result);
		
		result= client.addDepartment("Cool", cookie);
		assertEquals(false, result);
		
		result = client.addUser("haha", "123", "Chemistry", cookie);
		assertEquals(false, result);
		
		//try to add user to a nonexistent department
		cookie = client.login("Admin", "helloworld");
		result = client.addUser("chemist4", "567890", "People", cookie);
		assertEquals(false, result);
		
	}
	
	@Test
	void testAddAdmin()
	{
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		
		boolean result = client.addAdmin("bigChemist", "234456", "Chemistry", cookie);
		
		cookie =client.login("bigChemist", "234456");
		assertNotEquals(null, cookie);
		//a valid admin can do many things
		result = client.addUser("aChemist", "0000000", "Chemistry", cookie);
		assertEquals(true, result);
		
		result = client.addAdmin("Hello", "00dsfgdfg", "Chemistry", cookie);
		assertEquals(true, result);
		
		result = client.addDepartment("Biology", cookie);
		assertEquals(true, result);
		
		//switch to user
		cookie = client.login("aChemist", "0000000");
		result = client.addAdmin("coolddssdd", "sgsfgds", "Chemistry", cookie);
		assertEquals(false, result);
		cookie = client.login("coolddssdd", "sgsfgds");
		assertEquals(null, cookie);
	}
	
	@Test
	void addDepartmentTest()
	{
		Client client = new Client();
		String cookie = client.login("Admin", "helloworld");
		
		//the department is not there so adding user will faile
		boolean result = client.addUser("998", "334", "Fly", cookie);
		assertEquals(false, result);
		
		result = client.addDepartment("Fly", cookie);
		assertEquals(true, result);
		//after adding the department, now user should be added correctly
		result = client.addUser("998", "334", "Fly", cookie);
		assertEquals(true, result);
		
		//Chemistry is already there, should not succeed
		result = client.addDepartment("Chemistry", cookie);
		assertEquals(false, result);
	}
}
