package Software_Master_A.client_and_server;

public interface PlanInterface
{
	
	String login(String username, String password);

	PlanFile getPlan(int year);
	
	//May not need
	PlanFile getPlanOutile();
	
	boolean pushPlan(PlanFile plan,String cookie);

	boolean addUser(String username, String password, String department,String cookie);
	
	boolean addAdimin(String username, String password, String department,String cookie);
	
	boolean flagPlan(String department, String year,String cookie);
	
	boolean addDepartment(String department,String cookie);
}
