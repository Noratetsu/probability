
public class compute_a_posterior {
	
	private static int obsLength = 0;
	private static String observation = "";
	private static double[] obsProb;
	
	public static void main(String[] args) {
		observation = args[0];
		obsLength = observationLength(observation);
		obsProb = new double[obsLength];
		setObservations(Hypothisis.h1);
		System.out.println(obsProb.toString());
		System.out.println(observation);
		
	}
	
	public static int observationLength(String obs)
	{
		return obs.length();
	}
	
	public static void setObservations(Hypothisis h)
	{
		for(int i = 0;i < obsLength; i++)
		{
			obsProb[i] = (observation.charAt(i) == 'C') ? h.getCherry() : h.getLime();
		}
	}

}
