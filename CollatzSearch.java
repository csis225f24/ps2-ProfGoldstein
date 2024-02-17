/**
 *   Application to generate and compare Collatz sequences to find the 
 *   largest number and to find the longest sequence.
 *
 *   @author Ira Goldstein
 *   @version Spring 2024
 *
 */

public class CollatzSearch {
	
	/**
	* main method to test the CollatzGenerator class.
	*
	* @param args[0] The number of Collatz sequences we want to examine
	*/	
	public static void main(String[] args) {
		long nmax = 0;	//The number of Collatz sequences
		
		// Initialze the five "max" variables we are looking for
		long maxLength = 0;
		long maxN = 0;
		long maxValue = 0;
		long maxValueN = 0;
		long maxValuePos = 0;
				
		// Convert the command-line parameter to the number of sequences
		// we want to examine
		try {
			nmax = Long.parseLong(args[0]);
		}
		catch (NumberFormatException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		// Itterate over each of the Collatz sequences
		for (long n = 1; n <= nmax; n++) {
			CollatzGenerator generator = new CollatzGenerator(n);
			long length = 0;
			long value = 0;
			long pos = 0;
			
			// Look for the largest value in this sequence
			while (generator.hasNext()) {
				long x = generator.next();
				length++;
				if (x > value) {
					value = x;
					pos = length;
				}
			}
			
			// Check to see if this sequence is the longest so far
			if (length > maxLength) {
				maxLength = length ;
				maxN = n;
			}
			
			// Check to see if this sequence's largest value is the biggest so far
			if (value > maxValue) {
				maxValue = value;
				maxValueN = n;
				maxValuePos = pos;
			}
		}

		// Print results
		System.out.println("Longest sequence started at " + maxN + " has length " + maxLength);
		System.out.println("Largest value " + maxValue + " at position " + maxValuePos + " in sequence beginning with " + maxValueN );
	}
}
