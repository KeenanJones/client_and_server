package Software_Master_A.client_and_server;

import java.util.Hashtable;

public class Department
{

	Hashtable<Integer, PlanFile> plans;
	
	
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
	
	
}
