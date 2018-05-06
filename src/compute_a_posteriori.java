import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * this program will compute the probabilities of 5 bags of candies given observation q.
 * it puts results into results.txt
 * @author Brandon Keen
 *
 */
public class compute_a_posteriori {
	
	private static int obsLength = 0;
	private static String observation = "";
	private static double[] h1Prob,h2Prob,h3Prob,h4Prob,h5Prob;
	
	public static void main(String[] args) {
		//variable initializations
		observation = args[0];
		obsLength = observation.length();
		h1Prob = new double[obsLength+1];
		h2Prob = new double[obsLength+1];
		h3Prob = new double[obsLength+1];
		h4Prob = new double[obsLength+1];
		h5Prob = new double[obsLength+1];
		//setup each hypothesis with their respective priors
		h1Prob[0] = Hypothisis.h1.getPrior();
		h2Prob[0] = Hypothisis.h2.getPrior();
		h3Prob[0] = Hypothisis.h3.getPrior();
		h4Prob[0] = Hypothisis.h4.getPrior();
		h5Prob[0] = Hypothisis.h5.getPrior();
		
		
		for(int i = 0; i < obsLength; i++)
		{
			//if we observe a cherry
			if(observation.charAt(i) == 'C')
				observeCherry(i); //we compute for each hypothesis given cherry
			else //other it is a lime
				observeLime(i); //we compute for each hypothesis given lime
			
		}
		System.out.println("Results writtin to results.txt");
		writeResults();//write results
	
		
	}
	
	/**
	 * calculate probability for next hypothesis given prior
	 * @param i which hypotheses we want to select
	 * @param d probability to multiply
	 * @return returns new probability or -1 if error
	 */
	public static double cherryProb(int i, double d)
	{
		
		switch(i)
		{
		case 1: return Hypothisis.h1.getCherry() * d; 
		case 2: return Hypothisis.h2.getCherry() * d; 
		case 3: return Hypothisis.h3.getCherry() * d; 
		case 4: return Hypothisis.h4.getCherry() * d; 
		case 5: return Hypothisis.h5.getCherry() * d;
		default: return -1;
		}
		
	
		
	}
	/**
	 * calculate probability for next hypothesis given prior
	 * @param i which hypotheses we want to select
	 * @param d probability to multiply
	 * @return returns new probability or -1 if error
	 */
	public static double limeProb(int i, double d)
	{
		switch(i)
		{
		case 1: return Hypothisis.h1.getLime() * d;
		case 2: return Hypothisis.h2.getLime() * d;
		case 3: return Hypothisis.h3.getLime() * d;
		case 4: return Hypothisis.h4.getLime() * d;
		case 5: return Hypothisis.h5.getLime() * d;
		default: return -1;
		}
		
	}

	/**
	 * calculate each hypothesis given observation is cherry
	 * @param i index parameter
	 */
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
	/**
	 * calculate each hypothesis given observation is lime
	 * @param i index parameter
	 */
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
	
	/**
	 * get the next probability of either cherry or lime
	 * @param type if true, cherry, lime if false.
	 * @param i index parameter
	 * @return next probability for cherry or lime.
	 */
	public static double next(boolean type, int i)
	{
		if(type)
			return (cherryProb(1,h1Prob[i]) + cherryProb(2,h2Prob[i]) + cherryProb(3,h3Prob[i]) + cherryProb(4,h4Prob[i]) + cherryProb(5,h5Prob[i]));
		else
			return (limeProb(1,h1Prob[i]) + limeProb(2,h2Prob[i]) + limeProb(3,h3Prob[i]) + limeProb(4,h4Prob[i]) + limeProb(5,h5Prob[i]));
				
	}
	
	/**
	 * write results into given format to a text file. Text file will be called results.txt
	 */
	public static void writeResults()
	{
		FileWriter fw = null;
		BufferedWriter buffer = null;
		DecimalFormat f = new DecimalFormat("#.#####"); //as per assignment, limit to 5 decimals points
		try {
			fw = new FileWriter("results.txt");
			buffer = new BufferedWriter(fw);
			//start the file out with basic info
			buffer.write("Observation Sequence Q: " + observation);
			buffer.newLine();
			buffer.write("Length of Q: " + obsLength);
			buffer.newLine();
			buffer.newLine();	
			for(int i = 1; i < obsLength+1; i++)
			{
				//iterate for each observation
				buffer.write("After Observation " + i + " : " + observation.charAt(i-1));
				buffer.newLine();
				buffer.newLine();
				buffer.write("P(h1 | Q) = " + f.format(h1Prob[i]));
				buffer.newLine();
				buffer.write("P(h2 | Q) = " + f.format(h2Prob[i]));
				buffer.newLine();
				buffer.write("P(h3 | Q) = " + f.format(h3Prob[i]));
				buffer.newLine();
				buffer.write("P(h4 | Q) = " + f.format(h4Prob[i]));
				buffer.newLine();
				buffer.write("P(h5 | Q) = " + f.format(h5Prob[i]));
				buffer.newLine();
				buffer.newLine();
				buffer.write("Probability that the next candy we pick will be C, given Q: " + f.format(next(true,i)));
				buffer.newLine();
				buffer.write("Probability that the next candy we pick will be L, given Q: " + f.format(next(false,i)));
				buffer.newLine();
				buffer.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				buffer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
