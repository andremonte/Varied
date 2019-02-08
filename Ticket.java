// **************************************************************
// * Workshop 01                         Ticket.jar             *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.Date;
import java.util.Random;

public class Ticket {

    public static final int QUANT_NUNS = 3;

    private Date date;
    private int[] ticket;

    public Ticket(Date curDate) {
        date = curDate;
        ticket = new int[QUANT_NUNS];

        //Gerando numeros do bilhete
        Random rand = new Random();
        int num1 = 0;
        int num2 = 0;
        while (num1 == num2) {
            num1 = rand.nextInt((10 - 1) + 1) + 1;
            num2 = rand.nextInt((10 - 1) + 1) + 1;
            if (num1 != num2) {
                ticket[0] = num1;
                ticket[1] = num2;
            }
        }

        int num3 = rand.nextInt((10 - 1) + 1) + 1;
        if (num3 != num1 && num3 != num2) {
            ticket[2] = num3;
        } else {
            while (num3 == num1 || num3 == num2) {
                num3 = rand.nextInt((10 - 1) + 1) + 1;

                if (num3 != num1 && num3 != num2) {
                    ticket[2] = num3;
                }
            }
        }
        //System.out.println(Arrays.toString(ticket));
    }

    public int howManyNumbers(Ticket tp_) {
        int quant = 0;

        if (tp_.date.equals(date)) {
            for (int i = 0; i < ticket.length; i++) {
                for (int j = 0; j < tp_.ticket.length; j++) {
                    if (tp_.ticket[j] == ticket[i]) {
                        quant++;
                        break;
                    }
                }
            }
        }

        return quant;
    }

    public Date getDate() {
        return date;
    }

    public int[] getTicket() {
        return ticket;
    }

}
