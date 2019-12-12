
import Deck.Deck;

import Deck.PlayingCard;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("gruby55");
        Player player2 = new Player("twojaStara");

        System.out.println(" --------------------------------------------------------------------------");
        System.out.println(" ***                New Deck before unboxing - peek on a left           ***");
        System.out.println(" --------------------------------------------------------------------------");
        Deck deck = new Deck();
        System.out.println(deck);

        System.out.println();
        System.out.println(" --------------------------------------------------------------------------");
        System.out.println(" ***                 Deck after shuffle  - peek on a left               ***");
        System.out.println(" --------------------------------------------------------------------------");
        deck.shuffle();
        System.out.println(deck);

        player1.setPlayingCards(deck.dealCardsToPlayer1());
        player2.setPlayingCards(deck.dealCardsToPlayer2());
        player1.setQuantityOfCards(26);
        player2.setQuantityOfCards(26);

        System.out.println();
        System.out.println(" --------------------------------------------------------------------------");
        System.out.println(" ***     Deck dealt between player1 and player2-  - peeks on a left     ***");
        System.out.println(" --------------------------------------------------------------------------");
        System.out.println(player1.getNick() + ": " + player1.getPlayingCards());
        System.out.println(player2.getNick() + ": " + player2.getPlayingCards());
        System.out.println();

        //-----------------GAME--------------------------------
        int round = 1;

        while (player1.getQuantityOfCards() != 0 && player2.getQuantityOfCards() != 0 && round <= 100_000) {

            System.out.println(" -------------------------------------------------");
            System.out.println("                      Round: " + round);
            System.out.println(" -------------------------------------------------");

            List<PlayingCard> fightingCards = new ArrayList<>();
            Main.particularRound(round, fightingCards, player1, player2);
            round++;
        }

        if (round > 100_000) {
            System.out.println();
            System.out.println(" ***********************************************************");
            System.out.println(" DRAW - no winner. Assuming you played each round 3 seconds,\n" +
                    " game took about 3.5 days without break.\n" + " You are addicted. Go to sleep.");
            System.out.println(" ***********************************************************");
        } else if (player1.getQuantityOfCards() == 0) {
            System.out.println();
            System.out.println(" ***********************************************************");
            System.out.println("End of game. " + player2.getNick() + " is a WINNER!!!");
            System.out.println(" ***********************************************************");
        } else if (player2.getQuantityOfCards() == 0) {
            System.out.println();
            System.out.println(" ***********************************************************");
            System.out.println("End of game. " + player1.getNick() + " is a WINNER!!!");
            System.out.println(" ***********************************************************");
        }
    }

    //------------------METHODS--------------------------------

    private static void particularRound(int round, List<PlayingCard> fightingCards, Player player1, Player player2) {
        PlayingCard tempCardPlayer1 = player1.getPlayingCards().peek();
        PlayingCard tempCardPlayer2 = player2.getPlayingCards().peek();

        System.out.println(player1.getNick() + ": " + tempCardPlayer1);
        System.out.println(player2.getNick() + ": " + tempCardPlayer2);

        //WAR
        if (tempCardPlayer1.compareTo(tempCardPlayer2) == 0) {

            System.out.println("WAR !!!!!!!!!!!!!!!");
            //case when  both players have just 2 cards in queue and there will be a war, card #3 and #4
            //do not fight, so there is a draw; the only possibility is both players have the same deck of 26 cards
            // in hand sorted in the same order
            if (player1.getQuantityOfCards() <= 2 && player2.getQuantityOfCards() <= 2) {
                for (int i = 0; i < 2; i++) {
                    removePeekFromBothPlayersAndAddToFightingList(fightingCards, player1, player2);
                }
                System.out.println(player1);
                System.out.println(player2);
                System.out.println("Fighting cards list: " + fightingCards);
                System.out.println(" *********************************************************************");
                System.out.println("    DRAW - no winner. Players do not have more cards to finish WAR");
                System.out.println(" *********************************************************************");
                System.exit(1);


            } else if (player2.getQuantityOfCards() <= 2) { //case when player2 has just 2 or 1 cards in hand and there will be war, player 2 loses automatically
                finishGameWhenPlayerHasTwoOrLessCards(fightingCards, player1, player2);
            } else if (player1.getQuantityOfCards() <= 2) {//case when player1 has just 2 or 1 cards in hand and there will be war, player1 loses automatically
                finishGameWhenPlayerHasTwoOrLessCards(fightingCards, player2, player1);
            } else {      //other cases, normal WAR
                removePeekFromBothPlayersAndAddToFightingList(fightingCards, player1, player2);//1st step of WAR
                removePeekFromBothPlayersAndAddToFightingList(fightingCards, player1, player2); //2nd step of WAR - these cards do not fight
                particularRound(round, fightingCards, player1, player2); //3rd step of WAR
                System.out.println("Fighting cards list: " + fightingCards);
            }

        } else if (tempCardPlayer1.compareTo(tempCardPlayer2) > 0) {
            System.out.println("Round " + round + " winner is: " + player1.getNick());
            player1.remove();
            player2.remove();
            fightingCards.add(tempCardPlayer1);
            fightingCards.add(tempCardPlayer2);
            player1.addCards(fightingCards);

            System.out.println(player1);
            System.out.println(player2);
        } else if ((tempCardPlayer1.compareTo(tempCardPlayer2) < 0)) {
            System.out.println("Round " + round + " winner is: " + player2.getNick());
            player1.remove();
            player2.remove();
            fightingCards.add(tempCardPlayer1);
            fightingCards.add(tempCardPlayer2);
            player2.addCards(fightingCards);

            System.out.println(player1);
            System.out.println(player2);

        }
    }

    private static void finishGameWhenPlayerHasTwoOrLessCards(List<PlayingCard> fightingCards, Player player1, Player player2) {
        int quntityOfCardsBeforeWarPlayer2 = player2.getQuantityOfCards();
        for (int i = 0; i < quntityOfCardsBeforeWarPlayer2; i++) {
            removePeekFromBothPlayersAndAddToFightingList(fightingCards, player1, player2);
        }
        player1.addCards(fightingCards);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("Fighting cards list: " + fightingCards);
        System.out.println(" *********************************************************************");
        System.out.println("          End of game. " + player1.getNick() + " WON!!!!!");
        System.out.println(" *********************************************************************");
        System.exit(1);
    }

    //order of players in below method does not matter
    private static void removePeekFromBothPlayersAndAddToFightingList(List<PlayingCard> fightingCards, Player player1, Player player2) {
        fightingCards.add(player1.getPlayingCards().peek());
        fightingCards.add(player2.getPlayingCards().peek());
        player1.remove();
        player2.remove();
    }
}


