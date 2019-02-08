// **************************************************************
// * Workshop 01                              IsSquare.jar      *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.*;
import java.util.Scanner;
import java.util.stream.*;

class IsSquare {
    //Counting how many entrys the user entry.

    static int numbOfEntries = 0;
    static int rowNumber = 1;

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>(4);
        Scanner in = new Scanner(System.in);

        //Getting the first entries from user.
        System.out.println("Enter the numbers for your " + rowNumber + " square's ROW.");
        System.out.println("** When you done, just press enter without any entry **");
        String tmp = in.nextLine();

        //ERROR If user tries to enter blank in the first entry.
        if (tmp.isEmpty()) {
            System.out.println("YOUR FIRST ENTRY CANNOT BE A BLANK INPUT --> PLEASE RE-START THE PROGRAM AND ENTER A NUMBER!!");
        } else {
            while (!tmp.isEmpty()) {

                //Saving user entries into the listator and keeping changing index.
                lista.add(Integer.parseInt(tmp));
                tmp = in.nextLine();
                numbOfEntries++;

                if (tmp.isEmpty()) {
                    for (int q = 0; q < numbOfEntries - 1; q++) {
                        rowNumber++;
                        System.out.println();
                        System.out.println("Now, type the " + rowNumber + " square's ROW");
                        for (int i = 0; i < numbOfEntries; i++) {
                            lista.add(in.nextInt());
                        }
                    }
                }
            }
        }
        //creating array
        int[][] square = new int[numbOfEntries][numbOfEntries];

        //copying all elements from list to array
        for (int i = 0; i < numbOfEntries; i++) {
            for (int j = 0; j < numbOfEntries; j++) {
                square[i][j] = lista.get((i * numbOfEntries) + j);

                /*. 0.0, 0.1, 0.2, 0.3 -> 0-3
				1.0, 1.1, 1.2, 1.3 -> 4-7
				2.0, 2.1, 2.2, 2.3 -> 8-11
				3.0, 3.1, 3.2, 3.3 -> 12-15
				(i * numbOfEntries) + j */
            }
        }

        //Finding the magic number.
        int magicNumb = IntStream.of(square[0]).sum();

        //Checking rows
        for (int k = 0; k < numbOfEntries; k++) {
            if (IntStream.of(square[k]).sum() != magicNumb) {
                System.out.print("This square is not magic");
                return;//Encerra o metodo
            }
        }

        //checkin Columns
        for (int c = 0; c < numbOfEntries; c++) {
            int sum2 = 0;

            for (int r = 0; r < numbOfEntries; r++) {
                //int sum2 = 0;
                sum2 += square[r][c];
            }

            if (sum2 != magicNumb) {
                System.out.print("This square is not magic");
                return;
            }
        }

        //checkin main diagonal 
        int sumD = 0;
        for (int rc = 0; rc < numbOfEntries; rc++) {
            sumD += square[rc][rc];
        }
        if (sumD != magicNumb) {
            System.out.print("This square is not magic");
            return;
        }

        int sumD2 = 0;
        for (int l = numbOfEntries - 1, c = 0; l >= 0 && c < numbOfEntries; l--, c++) {
            sumD2 += square[l][c];
        }
        if (sumD2 != magicNumb) {
            System.out.print("This square is not magic");
            return;
        }
        //Square is magic!
        System.out.print("This square IS MAGIC!!");
    }
}
