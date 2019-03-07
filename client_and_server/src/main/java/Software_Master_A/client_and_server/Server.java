package Software_Master_A.client_and_server;

import java.util.Hashtable;

public class Server implements PlanInterface
{

	Hashtable<String, Account> loginMap;
	Hashtable<String, Account> cookieMap;
	Hashtable<String, Department> departmentMap;
	
	
	
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
