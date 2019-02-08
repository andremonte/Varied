// **************************************************************
// * Workshop 01                         LottoCentre.jar        *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class LottoCentre {

    public static final double TICKET_PRICE = 5;
    public static final double AWARD1 = 500;
    public static final double AWARD2 = 100;
    public static final double AWARD3 = 10;
    public static final double INIT_MONEY = 250;
    public static final int MAX_PLAYER = 10;
    public static final int MAX_DRAW = 50;
    public static final Date[] DATES = {new Date("12/11/2018"), new Date("01/12/2018"), new Date("05/09/2018"), new Date("29/04/2018")};

    public static class Generator {

        public static Ticket generator() {
            Random rand = new Random();
            Date d = DATES[rand.nextInt(DATES.length)];

            return new Ticket(d);
        }
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        
        System.out.println("..::All Initial balance for all players::..");
        //Creating 10 players and giving them 250 each.
        for(int i = 0; i < MAX_PLAYER; i++) {
            Player p = new Player(INIT_MONEY);
            
            //Displaying current balance
            
            //System.out.println("Player_" + (i + 1) + " CAD$ " + p.getBalance());
            System.out.printf(" Player_%d CAD$%.2f\n", i+1, p.getBalance());
            //Buying tickets
            for(int z = 0; z < MAX_DRAW; z++) {
                p.purchase(TICKET_PRICE, Generator.generator());
            }
            
            players.add(p);
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //checking winners
        System.out.println("\n*****Initializing Draw*****");
        for(Date d : DATES) {
            //generating winnerTicket
            Ticket winner = new Ticket(d);
            
            System.out.println(sdf.format(d) + " Winner ticket " + Arrays.toString(winner.getTicket()));
            
            for(Player p : players) {
                for (Ticket t : p.getTicketsByDate(d)) {
                    int nums = t.howManyNumbers(winner);
                    
                    if (nums > 0) {
                        System.out.println(" Player_" + (players.indexOf(p) + 1) + " " + nums + " numbers -> " + Arrays.toString(t.getTicket()));
                    }
                    
                    if (nums == 3) {
                        p.update(AWARD1);
                    }
                    
                    else if (nums == 2) {
                        p.update(AWARD2);
                    }
                    
                    else if(nums == 1) {
                        p.update(AWARD3);
                    }
                }
            }
        }
        
        System.out.println("\nThe current Balance for: ");
        for(int i = 0; i < players.size(); i++) {
                System.out.printf(" Player_%d CAD$%.2f\n", i+1, players.get(i).getBalance());
        }   
        //da dinheiro jogador
        //diz o preco do bilhete
        //checa se alguem ganhou
        //atualiza o dinheiro
        //tem os premios.
        //gerar bilhete.
        //criar 10 jogadores
        //obrigada cada jogador a comprar 50 bilhetes
        //mostrar balanco inicial e final de cada jogador.
    }
}
