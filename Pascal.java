// **************************************************************
// * Workshop 01                                Pascal.jar      *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.*;

class Pascal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please insert the number of lines for the Pascal Triangle");
        int numbLines = scan.nextInt();

        int num;
        int[][] mat = new int[numbLines + 1][numbLines + 1];

        for (int l = 0; l <= numbLines - 1; l++) {
            for (int c = 0; c <= l; c++) {
                if (c == 0 || c == l) {
                    num = 1;
                } else {
                    num = mat[l - 1][c - 1] + mat[l - 1][c];
                }

                mat[l][c] = num;
                System.out.print(num + " ");
            }
            System.out.print("\n");
        }

    }
}
