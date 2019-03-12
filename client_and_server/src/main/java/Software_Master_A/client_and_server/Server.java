package Software_Master_A.client_and_server;


import java.beans.Transient;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;



// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server implements PlanInterface
{

	/** The login map. */
	Hashtable<String, Account> loginMap;
	
	/** The cookie map. */
	Hashtable<String, Account> cookieMap;
	
	/** The department map. */
	Hashtable<String, Department> departmentMap;
	
	

	
	/**
	 * Instantiates a new server. 
	 * This is for xmldecoder
	 */
	public Server()
	{
	
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Instantiates a new server.
	 *
	 * @param admin the admin
	 */
	public Server(Account admin)
	{
		
		loginMap = new Hashtable<String, Account>();
		cookieMap = new Hashtable<String, Account>();
		departmentMap = new Hashtable<String, Department>();
		loginMap.put(admin.getUsername(),admin);
		cookieMap.put(admin.getCookie(), admin);
	}
	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#login(java.lang.String, java.lang.String)
	 */
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
	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlan(int, java.lang.String)
	 */
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
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlanOutline(java.lang.String)
	 */
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
	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#pushPlan(Software_Master_A.client_and_server.PlanFile, java.lang.String)
	 */
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
		
//		if(result)
//		{
//			save();
//		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
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
		//save();
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addAdmin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
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
		//save();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addDepartment(java.lang.String, java.lang.String)
	 */
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
		//save();
		return true;
	}


	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#flagPlan(java.lang.String, int, java.lang.Boolean, java.lang.String)
	 */
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
		//save();
		return true;
	}


	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addPlan(java.lang.String, Software_Master_A.client_and_server.PlanFile, java.lang.String)
	 */
	public boolean addPlan(String department, PlanFile planFile, String cookie)
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
		//save();
		return true;
	}
	
	/**
	 * Generate cookie.
	 *
	 * @return the string
	 */
	private String generateCookie() 
	{
		byte[] bs = new byte[26];
		new Random().nextBytes(bs);
		String cookie = new String(bs);
		return cookie;
	}
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getDepartmentOutline()
	 */
	public String getDepartmentOutline() 
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
	
	public void save()
	{
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Server.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		encoder.writeObject(this);
		encoder.close();
		
	}
	
	public static Server loadServer()
	{
		XMLDecoder decoder = null;
		
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Server.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Server server = (Server)decoder.readObject();
		decoder.close();
		return server;
		
		
	}

	public Hashtable<String, Account> getLoginMap() {
		return loginMap;
	}

	public void setLoginMap(Hashtable<String, Account> loginMap) {
		this.loginMap = loginMap;
	}

	public Hashtable<String, Account> getCookieMap() {
		return cookieMap;
	}

	public void setCookieMap(Hashtable<String, Account> cookieMap) {
		this.cookieMap = cookieMap;
	}

	public Hashtable<String, Department> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Hashtable<String, Department> departmentMap) {
		this.departmentMap = departmentMap;
	}
	
	
	
}
