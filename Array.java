import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
* The program will read and also outputs to text files.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-03-21
*/

public final class Array {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Array() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare the list
        final ArrayList<String> numList = new ArrayList<String>();

        try {
            // The code will choose a file to get input from.
            // The code will write the desired name of the file
            final File input = new File("Unit1-07-set3.txt");
            final Scanner scanInput = new Scanner(input);
            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output.txt");
            while (scanInput.hasNextLine()) {
                // Add the next line
                numList.add(scanInput.nextLine());
            }

            // Creates the array with same elements in the list.
            final int[] numArr = new int[numList.size()];
            for (int location = 0; location < numArr.length; location++) {
                numArr[location] = Integer.parseInt(numList.get(location));
            }
            // SOrt functions

            Arrays.sort(numArr);
            // Call the functions
            final double mean = mean(numArr);
            final double median = median(numArr);
            // Print the results
            System.out.println("mean: " + mean);
            System.out.println("median: " + median);
            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }
    /**
    * The function calculates the mean.
    *
    * @param numbers In array
    * @return mean
    */

    public static double mean(int[]numbers) {
        // Declares variables for function
        double sum = 0;
        double mean = 0;
        final double length = numbers.length;
        for (int position = 0; position < length; position = position + 1) {
            sum = sum + numbers[position];
        }
        mean = sum / length;
        return mean;
    }
    /**
    * This function does the math necessary for the program.
    *
    * @param numbers of inputs
    * @return function outputs
    */

    public static double median(int[]numbers) {

        // Code declares variables.
        double median = 0;

        // checks if the length is even
        final int length = numbers.length;
        if (length % 2 == 0) {
            median = (numbers[length / 2]
                      + numbers[length / 2 - 1]) / 2;
        } else {
            final int middle = (int) Math.floor(length / 2);
            median = numbers[middle];
        }
        // Code return the median as a double.
        return median;
    }
}
