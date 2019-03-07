package Software_Master_A.client_and_server;

public class Client implements PlanInterface
{

	String cookie;

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
	
	
}
	
