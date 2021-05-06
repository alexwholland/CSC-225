/*
Alex Holland - V00928553
CSC 225 - Lab 7
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;


public class PairSum225{

    /*
        This method uses hashing to efficiently determine if there
        are two indices within the array that sum to a given value
        (in this case 225). As the whole array only needs to be
        traversed once, the time complexity is O(n).
    */
    public static boolean PairSum225(int[] A, int sum){
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i : A) {
            int temp = sum - i;
            if (s.contains(temp)) {
                return true;
            }
            s.add(i);
        }
        return false;
    }

    /*
        For completeness of this lab, here is a O(n^2)
        implementation of PairSUm225:
        for (int i = 0; i < A.length -1; i++) {
        for (int j = i + 1; j < A.length; j++) {
            if (A[i] + A[j] == sum) {
                return true;
            }
        }
        return false;
    }
    */

    /*
        Contains code to test the PairSum225 method.
        main() reads a txt file or command line and stores
        the contents into an array.
        Source: CSC 225 A3
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
        long endTime = System.currentTimeMillis();

        double totalTimeSeconds = (endTime-startTime)/1000.0;

        int sum = 225;
        boolean TorF = PairSum225(array, sum);

        System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
        System.out.print("There are two indices that exist such that there sum is " + sum + ": " + TorF);
    }
    
}