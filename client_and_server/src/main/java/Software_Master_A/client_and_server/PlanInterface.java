package Software_Master_A.client_and_server;

import java.rmi.RemoteException;

public interface PlanInterface
{
	
	String login(String username, String password);

	PlanFile getPlan(int year, String cookie) throws RemoteException;
	
	//May not need
	PlanFile getPlanOutile();
	
	boolean pushPlan(PlanFile plan,String cookie)throws RemoteException; 

	boolean addUser(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean addAdimin(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean flagPlan(String department, int year,Boolean editable, String cookie)throws RemoteException;
	
	boolean addDepartment(String department,String cookie)throws RemoteException;
}
