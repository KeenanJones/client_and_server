package Software_Master_A.client_and_server;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class Department.
 */
public class Department
{

	/** The department name. */
	String departmentName;
	
	/** This hashTable maps the year of a PlanFile to a PlanFile object */
	Hashtable<Integer, PlanFile> plans;
	
	
	/**
	 * Instantiates a new department.
	 *
	 * @param departmentName the department name
	 */
	public Department(String departmentName)
	{
		
		this.departmentName = departmentName;
		plans = new Hashtable<Integer, PlanFile>();
	}

	public Department()
	{
		
	}
	/**
	 * Gets the plan.
	 *
	 * @param year the year
	 * @return the plan
	 */
	PlanFile getPlan(int year)
	{
		PlanFile planFile = plans.get(year);
		//System.out.println(year+" "+planFile);
		//if the plan in year A doesn't exist, planFile will be null
		// so we are able to return the correct value
		return planFile;
	}
	
	/**
	 * Adds the plan.
	 *
	 *	Used by admins to add new plans to a department
	 *	Verification is handled by server.
	 * @param year the year
	 * @param plan the plan
	 */
	//for admin
	void addPlan(int year, PlanFile plan)
	{
		plans.put(year, plan);
	}

	/**
	 * Write plan.
	 *
	 *	Used to make modification to a plan
	 * @param year the year
	 * @param plan the plan
	 * @return true, if successful
	 */
	boolean writePlan(int year, PlanFile plan)
	{
		PlanFile planFile = plans.get(year);
		
		if(planFile == null)
		{
			return false;
		}

		if (planFile.isEditable())
		{
			plans.put(year, plan);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets the plans.
	 *
	 * @return the plans
	 */
	public Hashtable<Integer, PlanFile> getPlans()
	{
		return plans;
	}

	/**
	 * Sets the plans.
	 *
	 * @param plans the plans
	 */
	public void setPlans(Hashtable<Integer, PlanFile> plans)
	{
		this.plans = plans;
	}

	/**
	 * Gets the department name.
	 *
	 * @return the department name
	 */
	public String getDepartmentName()
	{
		return departmentName;
	}

	/**
	 * Sets the department name.
	 *
	 * @param departmentName the new department name
	 */
	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
	
	
}
