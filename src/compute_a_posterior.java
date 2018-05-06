
public class compute_a_posterior {
	
	private static int obsLength = 0;
	private static String observation = "";
	private static double[] obsProb,h1Prob,h2Prob,h3Prob,h4Prob,h5Prob;
	
	public static void main(String[] args) {
		observation = args[0];
		obsLength = observation.length();
		obsProb = new double[obsLength];
		h1Prob = new double[obsLength+1];
		h2Prob = new double[obsLength+1];
		h3Prob = new double[obsLength+1];
		h4Prob = new double[obsLength+1];
		h5Prob = new double[obsLength+1];
		h1Prob[0] = Hypothisis.h1.getPrior();
		h2Prob[0] = Hypothisis.h2.getPrior();
		h3Prob[0] = Hypothisis.h3.getPrior();
		h4Prob[0] = Hypothisis.h4.getPrior();
		h5Prob[0] = Hypothisis.h5.getPrior();
		setObservations(Hypothisis.h1);
		System.out.println(obsProb.toString());
		System.out.println(observation);
		observeCherry(0);
		observeLime(0);
		
		for(int i = 1; i < obsLength; i++)
		{
			if(observation.charAt(i) == 'C')
				observeCherry(i);
			else
				observeLime(i);
			System.out.println(obsLength);
			System.out.println(observation.charAt(i-1) + "at i = " + i );
			System.out.println(h1Prob[i]);
			System.out.println(h2Prob[i]);
			System.out.println(h3Prob[i]);
			System.out.println(h4Prob[i]);
			System.out.println(h5Prob[i] + "\n");
			System.out.println(next(true , i));
			System.out.println(next(false , i) + "\n\n");
			
		}
		
		
	
		
	}
	
	public static void setObservations(Hypothisis h)
	{
		for(int i = 0;i < obsLength; i++)
		{
			obsProb[i] = (observation.charAt(i) == 'C') ? h.getCherry() : h.getLime();
		}
	}
	
	public static double cherryProb(int i, double d)
	{
		double retVal = 0.0;
		switch(i)
		{
		case 1: retVal = Hypothisis.h1.getCherry() * d; break;
		case 2: retVal = Hypothisis.h2.getCherry() * d; break;
		case 3: retVal = Hypothisis.h3.getCherry() * d; break;
		case 4: retVal = Hypothisis.h4.getCherry() * d; break;
		case 5: retVal = Hypothisis.h5.getCherry() * d; break;
		}
		
		return retVal;
	}
	
	public static double limeProb(int i, double d)
	{
		double retVal = 0.0;
		switch(i)
		{
		case 1: retVal = Hypothisis.h1.getLime() * d; break;
		case 2: retVal = Hypothisis.h2.getLime() * d; break;
		case 3: retVal = Hypothisis.h3.getLime() * d; break;
		case 4: retVal = Hypothisis.h4.getLime() * d; break;
		case 5: retVal = Hypothisis.h5.getLime() * d; break;
		}
		
		return retVal;
	}

	public static void observeCherry(int i)
	{
		double total;
		
		total = (cherryProb(1,h1Prob[i]) + cherryProb(2,h2Prob[i]) + cherryProb(3,h3Prob[i]) + cherryProb(4,h4Prob[i]) + cherryProb(5,h5Prob[i]));
		h1Prob[i+1] = cherryProb(1,h1Prob[i])/total;
		h2Prob[i+1] = cherryProb(2,h2Prob[i])/total;
		h3Prob[i+1] = cherryProb(3,h3Prob[i])/total;
		h4Prob[i+1] = cherryProb(4,h4Prob[i])/total;
		h5Prob[i+1] = cherryProb(5,h5Prob[i])/total;	
	}
	
	public static void observeLime(int i)
	{
		double total;
		
		total = (limeProb(1,h1Prob[i]) + limeProb(2,h2Prob[i]) + limeProb(3,h3Prob[i]) + limeProb(4,h4Prob[i]) + limeProb(5,h5Prob[i]));
		h1Prob[i+1] = limeProb(1,h1Prob[i])/total;
		h2Prob[i+1] = limeProb(2,h2Prob[i])/total;
		h3Prob[i+1] = limeProb(3,h3Prob[i])/total;
		h4Prob[i+1] = limeProb(4,h4Prob[i])/total;
		h5Prob[i+1] = limeProb(5,h5Prob[i])/total;	
	}
	
	public static double next(boolean type, int i)
	{
		if(type)
			return (cherryProb(1,h1Prob[i]) + cherryProb(2,h2Prob[i]) + cherryProb(3,h3Prob[i]) + cherryProb(4,h4Prob[i]) + cherryProb(5,h5Prob[i]));
		else
			return (limeProb(1,h1Prob[i]) + limeProb(2,h2Prob[i]) + limeProb(3,h3Prob[i]) + limeProb(4,h4Prob[i]) + limeProb(5,h5Prob[i]));
				
	}
}
