// **************************************************************
// * Workshop 01                                Player.jar      *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.ArrayList;
import java.util.Date;

public class Player {

    private ArrayList<Ticket> ticketList;
    private double curMoney;

    public Player(double money_) {
        curMoney = money_;
        ticketList = new ArrayList<>();
    }

    public void purchase(double compra_, Ticket ticket_) {
        curMoney -= compra_;
        ticketList.add(ticket_);
    }

    public void update(double premio_) {
        curMoney += premio_;
    }

    public double getBalance() {
        return curMoney;
    }

    public ArrayList<Ticket> getTicketsByDate(Date data_) {
        ArrayList<Ticket> resposta = new ArrayList<>();

        for (Ticket t : ticketList) {
            if (t.getDate().equals(data_)) {
                resposta.add(t);
            }
        }
        return resposta;
    }
}
