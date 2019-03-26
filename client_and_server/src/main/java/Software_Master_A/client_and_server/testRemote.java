package Software_Master_A.client_and_server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class testRemote
{

	public static void main(String[] args) throws RemoteException, NotBoundException
	{
		// TODO Auto-generated method stub

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
		
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(100);
		} catch (ExportException e) {
			// TODO Auto-generated catch block
			registry = LocateRegistry.getRegistry(100);
			registry.unbind("Server");
		}
		PlanInterface stub = (PlanInterface)UnicastRemoteObject.exportObject(server, 0);
		registry.rebind("Server", stub);
	}

}
