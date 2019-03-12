package Software_Master_A.client_and_server;


import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlanInterface.
 */
public interface PlanInterface extends Remote,Serializable
{
	
	/**
	 * Login.
	 *
	 * Method for user to login. If login succeeds, return a string representation of cookie, otherwise null;
	 * @param username username of the client trying to login
	 * @param password password of the client trying to login
	 * @return the string cookie that is unique to a user, which is used when user performs operations on the server
	 * @throws RemoteException the remote exception
	 */
	String login(String username, String password)throws RemoteException;

	/**
	 * Gets the plan.
	 * Users can use this method to get plans from their department by year. Cookie is
	 * required to identify the user.
	 * @param year the year of a plan in the user's department
	 * @param cookie the cookie that is unique to a user
	 * @return the plan user requests. null if the plan doesn't exist
	 * @throws RemoteException the remote exception
	 */
	PlanFile getPlan(int year, String cookie) throws RemoteException;
	
	/**
	 * Gets the plan outline.
	 *
	 * @param cookie the cookie that is unique to a user
	 * @return the plan outline a list of plans (year + name)
	 * @throws RemoteException the remote exception
	 */
	//May not need
	String getPlanOutline(String cookie)throws RemoteException;
	
	/**
	 * Gets the department outline.
	 *
	 * @return the department outline a list of departments
	 * @throws RemoteException the remote exception
	 */
	String getDepartmentOutline() throws RemoteException;
	
	/**
	 * Push plan.
	 * Only PlanFile object is required. Since, within the object
	 * there is a year attribute, which will be used by the server to
	 * find a specific plan.
	 * 
	 * Situations when the push may fail
	 * 1.cookie is not correct(not a user)
	 * 2.The year doesn't exist
	 * 3.the plan is marked not editable
	 * 
	 * 
	 * @param plan the plan that has been edited by the user
	 * @param cookie the cookie that is unique to a user
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean pushPlan(PlanFile plan,String cookie)throws RemoteException; 

	/**
	 * Adds the user.
	 *	This method allows admins to add other users to the server. Cookie are used to 
	 *	test if the client sending the request is an admin.
	 *
	 *Situations when the adding may fail
	 *	1.The client is not an admin(no account in the server or a normal user)
	 *	2.Department user belongs to doesn't exist
	 *
	 * @param username the username of the client trying to login
	 * @param password the password of the client trying to login
	 * @param department the department, appears as departmentName attribute in Department object
	 * @param cookie the cookie that is unique to a admin
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean addUser(String username, String password, String department,String cookie)throws RemoteException;
	
	/**
	 * Adds the admin.
	 * 	This method allows admins to add other admins to the server. Cookie are used to 
	 *	test if the client sending the request is an admin.
	 *
	 *Situations when the adding may fail
	 *	1.The client is not an admin(no account in the server or a normal user)
	 *	2.Department user belongs to doesn't exist
	 *
	 * @param username the username of the client trying to login
	 * @param password the password of the client trying to login
	 * @param department the department, appears as departmentName attribute in Department object
	 * @param cookie the cookie that is unique to a admin
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean addAdmin(String username, String password, String department,String cookie)throws RemoteException;
	
	/**
	 * Flag plan.
	 * Used to change if a plan is editable or not
	 * 
	 * Situations flagging may fail
	 * 1. The cookie is not associated with an admin(null or to a user)
	 * 2. The department doesn't exist
	 * 3. The PlanFile  doesn't exist
	 * @param department the department
	 * @param year the year
	 * @param editable the editable
	 * @param cookie the cookie that is unique to a user
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean flagPlan(String department, int year,Boolean editable, String cookie)throws RemoteException;
	
	/**
	 * Adds the department.
	 *
	 *	Situations when things may go wrong:
	 *  1. The cookie is not associated with an admin(null or to a user)
	 *  2. The department already exists
	 * @param department the department
	 * @param cookie the cookie that is unique to a user
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean addDepartment(String department,String cookie)throws RemoteException;
	
	/**
	 * Adds the plan. Used by admins to add new plans to a department. New plans are plans with different years 
	 * than those store in department
	 * 
	 * Situations when things may go wrong:
	 * 1. The cookie is not associated with an admin(null or to a user)
	 * 
	 * @param department the department
	 * @param planFile the plan file
	 * @param cookie the cookie that is unique to a user
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	boolean addPlan(String department, PlanFile planFile, String cookie) throws RemoteException;
}
