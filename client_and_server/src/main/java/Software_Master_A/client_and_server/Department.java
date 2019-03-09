package Software_Master_A.client_and_server;

import java.util.Hashtable;

public class Department
{

	String departmentName;
	Hashtable<Integer, PlanFile> plans;
	
	
	/**
	 * @param departmentName
	 */
	public Department(String departmentName)
	{
		
		this.departmentName = departmentName;
		plans = new Hashtable<Integer, PlanFile>();
	}

	PlanFile getPlan(int year)
	{
		return null;
	}
	
	void addPlan(int year, PlanFile plan)
	{
		
	}

	/**
	 * @return the plans
	 */
	public Hashtable<Integer, PlanFile> getPlans()
	{
		return plans;
	}

	/**
	 * @param plans the plans to set
	 */
	public void setPlans(Hashtable<Integer, PlanFile> plans)
	{
		this.plans = plans;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName()
	{
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
	
	
}
