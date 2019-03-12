package Software_Master_A.client_and_server;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

class ContinuousSaveTest {

	@Test
	void test() throws RemoteException, InterruptedException {
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
		PlanInterface server = new Server(admin);

		
		Server myServer = (Server)server;
		myServer.departmentMap.put(chemistry.departmentName, chemistry);
		
		for(int i=0; i<5; i++)
		{
			//here we changed the content of department
			String deparString = "Hello"+i;
			Department department = new Department(deparString);
			String name= "cool"+i;
			String password1 = "reallycool"+i;
			myServer.departmentMap.put(deparString, department);
			boolean result= myServer.addUser(name, password1, deparString, "12sdfsdg");

			assertEquals(true, result);
			ServerSave save = new ServerSave(myServer);
			ServerProxy proxy = new ServerProxy(myServer, save);
			
			//waiting for proxy to save the file
			Thread.sleep(4000);
			myServer = Server.loadServer();
			//if the file is correctly saved, we should have access to new data
			assertEquals(password1, myServer.loginMap.get(name).password);
			assertNotEquals(null, myServer.departmentMap.get("Hello"+i));
		}
	}

}
