/**
 *
 * @author Darnell Simon
 * @since 4.28.2020
 *
 * This program bubble sorts two columns by based on the id number.
 *
 *
 *
 */
package bubblesortgrades;

import java.io.File;
import java.util.Scanner;

public class BubbleSortGrades {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 100;

        int count;
        int[] id = new int[MAXNUMBER]; //Array of ints for IDs
        String[] grade = new String[MAXNUMBER]; //Array of Strings for grades

        count = populateArray(id, grade); // Populate the array to determine the count

        // Invoking the bubble sort
        bubbleSort(id, grade, count);

        System.out.println("ID\tGRADE"); // Print heading of the arrays
        for (int i = 0; i < count; i++) {
            // Printing the two arrays side by side
            System.out.printf("%d\t%s\n", id[i], grade[i]);
        }
    } // end main

    //////////////////////////////
    ////////Populate Array////////
    //////////////////////////////
    public static int populateArray(int[] id, String[] grade) throws Exception {
        Scanner sc = new Scanner(new File("BubbleSortGrades.txt"));
        int count = 0;
        while (sc.hasNext()) {

            // Filling up two arrays in parallel to each other
            id[count] = sc.nextInt(); // read the int
            grade[count] = sc.next(); // read the string beside it

            count++;
        }
        return count;
    } // end populateArray

    /////////////////////////////////
    ////////Bubble Sort Array////////
    /////////////////////////////////
    public static void bubbleSort(int[] id, String[] grade, int n) {
        int hold, j, pass;
        String temp;
        boolean switched = true;

        for (pass = 0; pass < n - 1 && switched; pass++) {
            // outer loop controles the number of passes
            switched = false; // initially no interchanges have been 
            // made one this pass
            for (j = 0; j < n - pass - 1; j++) {
                // inner loop governs each individual pass
                if (id[j] > id[j + 1]) {
                    // elements are out of order an interhcange is necessary 
                    switched = true;
                    hold = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = hold;
                    temp = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = temp;
                } // end if
            } // end for (j = 0 ...
        }//endfor(pass=0... } // end bubbleSort method
    } // end BubbleSort class

}
