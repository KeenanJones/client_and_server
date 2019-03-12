package Software_Master_A.client_and_server;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 * We make Client have the same set of methods as server does.
 * The implementation of all shared methods in Client simply is calling 
 * the server's methods and returning whatever the server's methods return.
 */
/**
 * @author liujiang
 *
 */
public class Client implements PlanInterface
{

	/** The cookie. Unique id that is passed to methods that operate on the server
	 * server will use it to identify the user
	 * */
	String cookie;
	
	/** The server.
	 *  This is a reference to real server connected by RMI. 
	 *  It is used here for server method calls
	 *  */
	PlanInterface server;
	
	
	/**
	 * Instantiates a new client.
	 */
	public Client()
	{
		Registry registry =null;
	
		
		try
		{
			registry = LocateRegistry.getRegistry(100);
			server = (PlanInterface)registry.lookup("Server");
		} catch (AccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates a new client.
	 *
	 * @param serverAddress the server address
	 */
	public Client(String serverAddress)
	{

		try
		{
			Registry registry = LocateRegistry.getRegistry(serverAddress);
			server = (PlanInterface)registry.lookup("Server");
		} catch (AccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#login(java.lang.String, java.lang.String)
	 */
	public String login(String username, String password)
	{
		
		try
		{
			return server.login(username, password);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlan(int, java.lang.String)
	 */
	public PlanFile getPlan(int year, String cookie)
	{
		// TODO Auto-generated method stub
		try
		{
			return server.getPlan(year, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlanOutline(java.lang.String)
	 */
	public String getPlanOutline(String cookie)
	{
		try
		{
			return server.getPlanOutline(cookie);
		} catch (RemoteException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#pushPlan(Software_Master_A.client_and_server.PlanFile, java.lang.String)
	 */
	public boolean pushPlan(PlanFile plan, String cookie)
	{
		// TODO Auto-generated method stub
		try
		{
			return server.pushPlan(plan, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean addUser(String username, String password, String department, String cookie)
	{
		// TODO Auto-generated method stub
		try
		{
			return server.addUser(username, password, department, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addAdmin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean addAdmin(String username, String password, String department, String cookie)
	{
		// TODO Auto-generated method stub
		try
		{
			return server.addAdmin(username, password, department, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addDepartment(java.lang.String, java.lang.String)
	 */
	public boolean addDepartment(String department, String cookie)
	{
		// TODO Auto-generated method stub
		try
		{
			return server.addDepartment(department, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#flagPlan(java.lang.String, int, java.lang.Boolean, java.lang.String)
	 */
	public boolean flagPlan(String department, int year, Boolean editable, String cookie) 
	{
		// TODO Auto-generated method stub
		try
		{
			return server.flagPlan(department, year, editable, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Gets the cookie.
	 *
	 * @return the cookie
	 */
	public String getCookie()
	{
		return cookie;
	}

	/**
	 * Sets the cookie.
	 *
	 * @param cookie the new cookie
	 */
	public void setCookie(String cookie)
	{
		this.cookie = cookie;
	}

	/**
	 * Gets the server.
	 *
	 * @return the server
	 */
	public PlanInterface getServer()
	{
		return server;
	}

	/**
	 * Sets the server.
	 *
	 * @param server the new server
	 */
	public void setServer(Server server)
	{
		this.server = server;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addPlan(java.lang.String, Software_Master_A.client_and_server.PlanFile, java.lang.String)
	 */
	public boolean addPlan(String department, PlanFile planFile, String cookie) 
	{
		try
		{
			return server.addPlan(department, planFile, cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getDepartmentOutline()
	 */
	public String getDepartmentOutline() 
	{
		try
		{
			return server.getDepartmentOutline();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
}
	
