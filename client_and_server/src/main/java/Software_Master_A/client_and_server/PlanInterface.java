package Software_Master_A.client_and_server;


import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlanInterface extends Remote,Serializable
{
	
	String login(String username, String password)throws RemoteException;

	PlanFile getPlan(int year, String cookie) throws RemoteException;
	
	//May not need
	PlanFile getPlanOutline()throws RemoteException;
	
	boolean pushPlan(PlanFile plan,String cookie)throws RemoteException; 

	boolean addUser(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean addAdmin(String username, String password, String department,String cookie)throws RemoteException;
	
	boolean flagPlan(String department, int year,Boolean editable, String cookie)throws RemoteException;
	
	boolean addDepartment(String department,String cookie)throws RemoteException;
	
	boolean addPlan(String department, PlanFile planFile, String cookie) throws RemoteException;
}
