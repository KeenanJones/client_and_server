/**
 * 
 */
package Software_Master_A.client_and_server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.function.ToDoubleBiFunction;

/**
 * @author liujiang
 *
 * This class is what developer should use for
 * server communication across RMI. The server class 
 * to actually do the work, but only using this class
 * server can save the data every 2 minutes.
 */
public class ServerProxy 
{
	
	
	
	/** The server.
	 *  This is a reference to real server that do works. 
	 *  It is used here for server method calls
	 *  */
	Server server;
	ServerSave save;
	

	/**
	 * @param server real server
	 * @param save save object that helps to save the server every 2 minute
	 */
	public ServerProxy(Server server, ServerSave save) {
		super();
		this.server = server;
		this.save = save;
		save.setServer(server);
		save.start();
		startRMI();
	}

	void startRMI()
	{
		try {
			Registry registry = LocateRegistry.getRegistry();
			PlanInterface stub = (PlanInterface)server;
			registry.rebind("Server", stub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	


	
	
}
