

/**
 * enum to store hypothesis information
 * @author Brandon Keen
 *
 */
public enum Hypothisis {
	
	
	
	h1,h2,h3,h4,h5;//there are 5 bags, so 5 hypothesis
	
	/**
	 * @return prior value for hypothesis given self
	 */
	public double getPrior()
	{
		double retVal;
		switch(this)
		{
		case h1: retVal = .10;break;
		case h2: retVal = .20;break;
		case h3: retVal = .40;break;
		case h4: retVal = .20;break;
		case h5: retVal = .10;break;
		default: retVal = 0;break;
		}
		
		return retVal;
	}
	
	/**
	 * @return value of cherry given self
	 */
	public double getCherry()
	{
		double retVal;
		switch(this)
		{
		case h1: retVal = 1;break;
		case h2: retVal = .75;break;
		case h3: retVal = .50;break;
		case h4: retVal = .25;break;
		case h5: retVal = 0;break;
		default: retVal = 0;break;
		}
		
		return retVal;
	}
	
	/**
	 * @return value of lime given self
	 */
	public double getLime()
	{
		double retVal;
		switch(this)
		{
		case h1: retVal = 0;break;
		case h2: retVal = .25;break;
		case h3: retVal = .50;break;
		case h4: retVal = .75;break;
		case h5: retVal = 1;break;
		default: retVal = 0;break;
		}
		
		return retVal;
	}
	
	
	

}
