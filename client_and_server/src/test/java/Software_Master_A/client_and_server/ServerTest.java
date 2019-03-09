package Software_Master_A.client_and_server;

import static org.junit.jupiter.api.Assertions.*;


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
		String username = "Admin";
		String password = "helloworld";
		Account admin = new Account(username, password,true);
		admin.setCookie("12sdfsdg");
		Server server = new Server(admin);
		server.addDepartment(chemistry.departmentName, admin.cookie);
		Registry registry = LocateRegistry.createRegistry(100);
		Server stub = (Server)UnicastRemoteObject.exportObject(server, 0);
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
		client.addAdimin("admin2", "78910j", "Chemistry", cookie);
		
		Client client2 = new Client();
		String  cookie2 =client2.login("user", "123456");
		assertEquals(null, cookie2);
		
		cookie2 = client2.login("user1", "12345");
		assertEquals(null, cookie2);
		
		cookie2 = client2.login("user1", "123456");
		assertNotEquals(null, cookie2);
	}

}
