package Software_Master_A.client_and_server;

public class PlanFile
{

	int year;
	boolean editable;
	//need to figure out how to import sprint1 project
	//Plan plan;
	Plan plan;
	
	
	
	/**
	 * @param year
	 * @param editable
	 * @param plan
	 */
	public PlanFile(int year, boolean editable, Plan plan)
	{
		super();
		this.year = year;
		this.editable = editable;
		this.plan = plan;
	}
	
	
	//sprint1 design doesn't provide equals() for each class. Be cautious to generate equals()
	// for this class
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((plan == null) ? 0 : plan.hashCode());
		result = prime * result + year;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanFile other = (PlanFile) obj;
		if (editable != other.editable)
			return false;
		if (plan == null)
		{
			if (other.plan != null)
				return false;
		} else if (!plan.equals(other.plan))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	
	/**
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	

	/**
	 * @param year the year to set
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	/**
	 * @return the editable
	 */
	public boolean isEditable()
	{
		return editable;
	}
	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable)
	{
		this.editable = editable;
	}
	/**
	 * @return the plan
	 */
	public Plan getPlan()
	{
		return plan;
	}
	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plan plan)
	{
		this.plan = plan;
	}
}
