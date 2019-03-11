package Software_Master_A.client_and_server;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.VarHandle;
import java.net.CookieHandler;
import java.nio.charset.MalformedInputException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class Server implements PlanInterface
{

	Hashtable<String, Account> loginMap;
	Hashtable<String, Account> cookieMap;
	Hashtable<String, Department> departmentMap;
	
	
	
	public Server()
	{
		// TODO Auto-generated constructor stub
	}
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
		cookieMap.put(admin.getCookie(), admin);
	}
	
	
	public String login(String username, String password) 
	{
		if(username == null)
		{
			return null;
		}
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
		if (cookie == null)
		{
			return null;
		}
		Account user = cookieMap.get(cookie);
		if(user == null)
		{
			return null;
		}
		
		PlanFile planFile = user.getDepartment().getPlan(year);
		return planFile;
	}
	
	public String getPlanOutline(String cookie)
	{
		if (cookie == null)
		{
			return null;
		}
		
		Account account = cookieMap.get(cookie);
		if (account == null)
		{
			return null;
		}
		
		Department department = account.getDepartment();
		Set<Integer> map = department.plans.keySet();
		Iterator<Integer> plans = map.iterator();
		String outline="";
		while(plans.hasNext())
		{
			PlanFile file = department.getPlans().get(plans.next());
			outline += file.year+" "+file.plan.getName()+"\n";
		}
		return outline;
	}
	
	
	public boolean pushPlan(PlanFile plan, String cookie)
	{
		if (cookie == null)
		{
			return false;
		}
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
		if (cookie == null)
		{
			return false;
		}
		
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
	
	
	public boolean addAdmin(String username, String password, String department, String cookie)
	{
		if (cookie == null)
		{
			return false;
		}
		
		boolean result = addUser(username, password, department, cookie);
		
		if(!result)
		{
			return false;
		}
		Account newAdmin = loginMap.get(username);
		newAdmin.setAdmin(true);
		return true;
	}
	
	public boolean addDepartment(String department, String cookie)
	{
		if (cookie == null)
		{
			return false;
		}
		
		Account admin = cookieMap.get(cookie);
		if(!admin.isAdmin())
		{
			return false;
		}
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
		
		if (cookie == null)
		{
			return false;
		}
		
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
		if (cookie == null)
		{
			return false;
		}
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
	public String getDepartmentOutline() throws RemoteException
	{
		
		Set<String> departmentNames = departmentMap.keySet();
		Iterator<String> iterator = departmentNames.iterator();
		String outline= "";
		while(iterator.hasNext())
		{
			outline += iterator.next()+"\n";
		}
		return outline;
	}
	
	
	
	
	
	
	
}
