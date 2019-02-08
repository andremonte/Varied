// **************************************************************
// * Workshop 01                       PrintRandomString.jar    *
// * André Machado do Monte                                     *
// * 152848164                                                  *
// **************************************************************
package jac444.wk1;

import java.util.Random;

class PrintRandomString {

    public static void main(String[] args) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        int length = 10;

        Random rand = new Random();
        String text = "";

        for (int i = 0; i < length; i++) {
            text += characters.charAt(rand.nextInt(characters.length()));//characters.length = 62.
        }

        System.out.println(Long.parseLong(text, 36));
    }
}
