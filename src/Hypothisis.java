
public enum Hypothisis {
	
	
	
	h1,h2,h3,h4,h5;
	
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
