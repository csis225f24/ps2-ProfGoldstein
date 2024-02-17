/**
   An iterator to computes and returns prefix products over an array
   of int values.

   @author Ira Goldstein
   @version Spring 2024
*/

public class prefixProductArrayIterator implements java.util.Iterator<Integer> {

    /** the array over which we are iterating */
    private int[] array;

    /** the index of the next value to include in the prefix product */
    private int current;

    /** the product of elements before array[current] */
    private int prefixProduct;

    /**
       Construct a new prefix product iterator over the given array.

       @param a the array containing the values
    */
    public prefixProductArrayIterator(int[] a) {

	array = a;
	current = 0;
	prefixProduct = 1;
    }

    /**
       Return whether there are more elements that have not yet been
       part of the prefix product sequence.

       @return whether there are more elements that have not yet been
       part of the prefix product sequence
    */
    @Override
    public boolean hasNext() {

	return current < array.length;
    }

    /**
       Return the next value in the prefix product sequence.

       @return the next value in the prefix product sequence
    */
    @Override
    public Integer next() {

	prefixProduct = prefixProduct * array[current];
	current++;
	return prefixProduct;
    }

    /**
       main method to test the prefixProductArrayIterator.

       @param args[0] size of array to generate
       @param args[1] range of random values
    */
    public static void main(String args[]) {

	if (args.length != 2) {
	    System.err.println("Usage: java prefixProductArrayIterator size range");
	    System.exit(1);
	}

	// convert the command-line parameters to the numbers needed
	int n = 0;
	int range = 0;
	try {
	    n = Integer.parseInt(args[0]);
	    range = Integer.parseInt(args[1]);
	}
	catch (NumberFormatException e) {
	    System.err.println(e);
	    System.exit(1);
	}

	// create and populate the array
	java.util.Random r = new java.util.Random();
	int a[] = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = r.nextInt(range) + 1;
	}

	// print the array
	System.out.println("Generated array: " + java.util.Arrays.toString(a));

	// print the prefix products
	System.out.println("Prefix productss:");
	java.util.Iterator<Integer> iter = new prefixProductArrayIterator(a);
	while (iter.hasNext()) {
	    System.out.println(iter.next());
	}
    }
}
