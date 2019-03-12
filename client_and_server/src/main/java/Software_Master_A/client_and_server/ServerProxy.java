/**
 * 
 */
package Software_Master_A.client_and_server;

import java.rmi.RemoteException;

/**
 * @author liujiang
 *
 */
public class ServerProxy implements PlanInterface
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** The server.
	 *  This is a reference to real server connected by RMI. 
	 *  It is used here for server method calls
	 *  */
	Server server;
	ServerSave save;
	

	public ServerProxy(Server server, ServerSave save) {
		super();
		this.server = server;
		this.save = save;
		save.setServer(server);
		save.start();
	}



	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#login(java.lang.String, java.lang.String)
	 */
	public String login(String username, String password)
	{
		
		return server.login(username, password);
		
	}

	
	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlan(int, java.lang.String)
	 */
	public PlanFile getPlan(int year, String cookie)
	{
		return server.getPlan(year, cookie);
		
	}

	
	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getPlanOutline(java.lang.String)
	 */
	public String getPlanOutline(String cookie)
	{
		return server.getPlanOutline(cookie);
		
	
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#pushPlan(Software_Master_A.client_and_server.PlanFile, java.lang.String)
	 */
	public boolean pushPlan(PlanFile plan, String cookie)
	{
		return server.pushPlan(plan, cookie);

	}


	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean addUser(String username, String password, String department, String cookie)
	{
		return server.addUser(username, password, department, cookie);
	
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addAdmin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean addAdmin(String username, String password, String department, String cookie)
	{
		return server.addAdmin(username, password, department, cookie);
	
	}



	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#addDepartment(java.lang.String, java.lang.String)
	 */
	public boolean addDepartment(String department, String cookie)
	{
		return server.addDepartment(department, cookie);
		
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
	
	public boolean addPlan(String department, PlanFile planFile, String cookie) 
	{
		return server.addPlan(department, planFile, cookie);
		
	}

	/* (non-Javadoc)
	 * @see Software_Master_A.client_and_server.PlanInterface#getDepartmentOutline()
	 */
	public String getDepartmentOutline() 
	{
		return server.getDepartmentOutline();
		
	}

	
}
