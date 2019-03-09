package Software_Master_A.client_and_server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;

public class Server implements PlanInterface, Remote, Serializable
{

	Hashtable<String, Account> loginMap;
	Hashtable<String, Account> cookieMap;
	Hashtable<String, Department> departmentMap;
	
	
	
	
	/**
	 * An admin account is required to initialize the server
	 * since if note, no one can enter the server.
	 */
	public Server(Account admin)
	{
		loginMap = new Hashtable<String, Account>();
		cookieMap = new Hashtable<String, Account>();
		departmentMap = new Hashtable<String, Department>();
		loginMap.put(admin.getUsername(),admin);
	}
	
	
	public String login(String username, String password) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	public PlanFile getPlan(int year)
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
	public boolean flagPlan(String department, String year, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addDepartment(String department, String cookie)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
}
