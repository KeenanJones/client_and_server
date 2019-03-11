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
		PlanFile planFile = plans.get(year);
		//System.out.println(year+" "+planFile);
		//if the plan in year A doesn't exist, planFile will be null
		// so we are able to return the correct value
		return planFile;
	}
	
	//for admin
	void addPlan(int year, PlanFile plan)
	{
		plans.put(year, plan);
	}

	boolean writePlan(int year, PlanFile plan)
	{
		PlanFile planFile = plans.get(year);
		
		if (planFile.isEditable())
		{
			plans.put(year, plan);
			return true;
		}
		
		return false;
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
