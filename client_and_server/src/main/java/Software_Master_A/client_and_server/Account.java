package Software_Master_A.client_and_server;

// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
public class Account
{

	/** The username. */
	String username;
	
	/** The password. */
	String password;
	
	/** The cookie. */
	String cookie;
	
	/** The department. */
	Department department;
	
	/** The is admin. */
	boolean isAdmin;
	
	/**
	 * Test credential.
	 *	Check if the password sent by the client matches that stored in the account object
	 * @param password the password
	 * @return the string
	 */
	String testCredential(String password)
	{
		if (this.password.equals(password))
		{
			return this.cookie;
		}
		
		return null;
	}

	public Account()
	{
		
	}
	/**
	 * Instantiates a new account.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public Account(String username, String password)
	{
		this(username, password, null, false);
	}

	/**
	 * Instantiates a new account.
	 *
	 * @param username the username
	 * @param password the password
	 * @param isAdmin the is admin
	 */
	public Account(String username, String password, boolean isAdmin)
	{
		this(username, password, null, isAdmin);
	}


	/**
	 * Instantiates a new account.
	 *
	 * @param username the username
	 * @param password the password
	 * @param department the department
	 * @param isAdmin the is admin
	 */
	public Account(String username, String password, Department department, boolean isAdmin)
	{
		super();
		this.username = username;
		this.password = password;
		this.department = department;
		this.isAdmin = isAdmin;
	}


	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Gets the cookie.
	 *
	 * @return the cookie
	 */
	public String getCookie()
	{
		return cookie;
	}

	/**
	 * Sets the cookie.
	 *
	 * @param cookie the new cookie
	 */
	public void setCookie(String cookie)
	{
		this.cookie = cookie;
	}

	/**
	 * Gets the department.
	 *
	 * @return the department
	 */
	public Department getDepartment()
	{
		return department;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the new department
	 */
	public void setDepartment(Department department)
	{
		this.department = department;
	}

	/**
	 * Checks if is admin.
	 *
	 * @return true, if is admin
	 */
	public boolean isAdmin()
	{
		return isAdmin;
	}

	/**
	 * Sets the admin.
	 *
	 * @param isAdmin the new admin
	 */
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	
	
	
}
