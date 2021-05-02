/* CountInversions.java
   CSC 225 - Spring 2021
   Assignment 3 - Template for inversion counting

   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java CountInversions

   To conveniently test the algorithm with a large input, create a
   text file containing space-separated integer values and run the program with
	java CountInversions file.txt
   where file.txt is replaced by the name of the text file.
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the CountInversions class
public class CountInversions{
    /* CountInversions()
        Count and return the number of inversions in the input array A.

        The function may modify the input array A.

        Do not change the function signature (name/parameters).
    */
    public static int CountInversions(int[] A){

        int invCount = 0;                       //Track the number of inversions in the array
        int temp;                               //Temporary array value holder

        for (int i = 0; i < A.length - 1; i++){ //1. Loop while i is one less than the size of the array
            if (A[i] > A[i + 1]) {              //2. Determine if element 1 and element2 should be swapped
                temp = A[i];                    //3. Hold the element 1 value in temp
                A[i] = A[i + 1];                //4. Set element 1 to be element 2
                A[i + 1] = temp;                //5. Set element 2 to be temp which holds element 1
                invCount++;                     //6. Increase the inversion count
                if (i >= 1){                    //7. If two elements are swapped go back two indexes and determine
                    i -= 2;                     //   if the new index and next element should also be swapped
                }
            }
        }
        return invCount;                        //Return the number of inversion in the array
    }

    /* main()
       Contains code to test the CountInversions function. Nothing in this function
       will be marked. You are free to change the provided code to test your
       implementation, but only the contents of the CountInversions() function above
       will be considered during marking.
    */
    public static void main(String[] args){
        Scanner s;
        if (args.length > 0){
            try{
                s = new Scanner(new File(args[0]));
            } catch(java.io.FileNotFoundException e){
                System.out.printf("Unable to open %s\n",args[0]);
                return;
            }
            System.out.printf("Reading input values from %s.\n",args[0]);
        }else{
            s = new Scanner(System.in);
            System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
        }
        Vector<Integer> inputVector = new Vector<Integer>();

        int v;
        while(s.hasNextInt() && (v = s.nextInt()) >= 0)
            inputVector.add(v);

        int[] array = new int[inputVector.size()];

        for (int i = 0; i < array.length; i++)
            array[i] = inputVector.get(i);

        System.out.printf("Read %d values.\n",array.length);


        long startTime = System.currentTimeMillis();

        int inversionCount = CountInversions(array);

        long endTime = System.currentTimeMillis();

        double totalTimeSeconds = (endTime-startTime)/1000.0;

        System.out.printf("Number of inversions: %d\n",inversionCount);
        System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
    }
}