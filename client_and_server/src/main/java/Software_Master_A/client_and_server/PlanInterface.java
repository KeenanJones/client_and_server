package Software_Master_A.client_and_server;

import java.rmi.RemoteException;

public interface PlanInterface
{
	
	String login(String username, String password);

	PlanFile getPlan(int year);
	
	//May not need
	PlanFile getPlanOutile();
	
	boolean pushPlan(PlanFile plan,String cookie)throws RemoteException; 

	boolean addUser(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean addAdimin(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean flagPlan(String department, String year,String cookie)throws RemoteException;
	
	boolean addDepartment(String department,String cookie)throws RemoteException;
}
