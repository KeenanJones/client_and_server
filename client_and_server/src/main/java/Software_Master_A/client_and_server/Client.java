package Software_Master_A.client_and_server;

import java.rmi.RemoteException;

public class Client implements PlanInterface
{

	String cookie;
	Server server;
	public String login(String username, String password)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public PlanFile getPlan(int year, String cookie)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public PlanFile getPlanOutile()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean pushPlan(PlanFile plan, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addUser(String username, String password, String department, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAdimin(String username, String password, String department, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}



	public boolean addDepartment(String department, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean flagPlan(String department, int year, Boolean editable, String cookie) throws RemoteException
	{
		// TODO Auto-generated method stub
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
	public Server getServer()
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


	
}
	
