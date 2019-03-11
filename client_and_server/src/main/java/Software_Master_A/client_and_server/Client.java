package Software_Master_A.client_and_server;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client implements PlanInterface
{

	String cookie;
	PlanInterface server;
	
	
	/**
	 * 
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

	public String getPlanOutline(String cookie)
	{
		try
		{
			return server.getPlanOutline(cookie);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

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
	 * @return the cookie
	 */
	public String getCookie()
	{
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie)
	{
		this.cookie = cookie;
	}

	/**
	 * @return the server
	 */
	public PlanInterface getServer()
	{
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(Server server)
	{
		this.server = server;
	}

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
	
