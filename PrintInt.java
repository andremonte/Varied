// **************************************************************
// * Workshop 01                         PrintInt.jar           *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.Scanner;

public class PrintInt {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inteiro;

        System.out.print("Please, enter an integer: ");

        while (!scan.hasNextInt()) {
            System.out.print("ONLY INTEGER CAN BE ENTERED!  --> ");
            System.out.print("Please, enter an integer: ");
            scan.next();
        }

        inteiro = scan.nextInt();
        System.out.println("Your number in binary is: " + Integer.toBinaryString(inteiro));
        System.out.println("Your number in Octal is: " + Integer.toOctalString(inteiro));
        System.out.println("Your number in Hexadecimal is: " + Integer.toHexString(inteiro));
        double xx = 1.0 / inteiro;
        System.out.println("The reciprocal of " + inteiro + " is: " + Double.toHexString(xx));
    }

}
