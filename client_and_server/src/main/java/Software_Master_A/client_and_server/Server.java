package Software_Master_A.client_and_server;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Random;

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
		Account user = loginMap.get(username);
		if (user == null)
		{
			return null;
		}
		
		String cookie = user.testCredential(password);
	
		return cookie;
	}
	
	
	public PlanFile getPlan(int year, String cookie)
	{
		Account user = cookieMap.get(cookie);
		if(user == null)
		{
			return null;
		}
		
		PlanFile planFile = user.getDepartment().getPlan(year);
		return planFile;
	}
	
	public PlanFile getPlanOutile()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean pushPlan(PlanFile plan, String cookie)
	{
		Account user = cookieMap.get(cookie);
		if(user == null)
		{
			return false;
		}
		
		boolean result = user.getDepartment().writePlan(plan.getYear(), plan);
		return result;
	}
	public boolean addUser(String username, String password, String department, String cookie)
	{
		Account admin = cookieMap.get(cookie);
		if(admin == null)
		{
			return false;
		}
		
		if(!admin.isAdmin())
		{
			return false;
		}
		
		Department departObject = departmentMap.get(department);
		if(departObject == null)
		{
			return false;
		}
		
		Account user = new Account(username, password, departObject, false);
		String userCookie = generateCookie();
		user.setCookie(userCookie);
		cookieMap.put(userCookie, user);
		loginMap.put(user.getUsername(), user);
		
		return true;
	}
	
	
	public boolean addAdimin(String username, String password, String department, String cookie)
	{
		addUser(username, password, department, cookie);
		
		Account admin = loginMap.get(username);
		admin.setAdmin(true);
		return false;
	}
	
	public boolean addDepartment(String department, String cookie)
	{
		Department depart = departmentMap.get(department);
		if(depart != null)
		{
			return false;
		}
		departmentMap.put(department, new Department(department));
		return true;
	}


	public boolean flagPlan(String department, int year, Boolean editable, String cookie) throws RemoteException
	{
		Account admin = cookieMap.get(cookie);
		if(admin == null || !admin.isAdmin())
		{
			return false;
		}
		
		Department departmentObject = departmentMap.get(department);
		if(departmentObject == null)
		{
			return false;
		}
		
		PlanFile plan = departmentObject.getPlan(year);
		if(plan == null)
		{
			return false;
		}
		
		plan.setEditable(editable);
		return true;
	}


	public boolean addPlan(String department, PlanFile planFile, String cookie) throws RemoteException
	{
		Account admin = cookieMap.get(cookie);
		if(admin == null || !admin.isAdmin())
		{
			return false;
		}
		
		Department departmentObject = departmentMap.get(department);
		if(departmentObject == null)
		{
			return false;
		}
		
		departmentObject.addPlan(planFile.year, planFile);
		return true;
	}
	
	private String generateCookie() 
	{
		byte[] bs = new byte[26];
		new Random().nextBytes(bs);
		String cookie = new String(bs);
		return cookie;
	}
	
	
	
	
	
	
	
}
