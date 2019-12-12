package Deck;

import Deck.Rank;
import Deck.Suit;


public class PlayingCard implements Comparable<PlayingCard>{ //zmienic na default

    private Rank rank;
    private Suit suit;

    PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String rankString = "";
        String suitString = "";

        switch (rank) {
            case TWO:
                rankString = "2";
                break;
            case THREE:
                rankString = "3";
                break;
            case FOUR:
                rankString = "4";
                break;
            case FIVE:
                rankString = "5";
                break;
            case SIX:
                rankString = "6";
                break;
            case SEVEN:
                rankString = "7";
                break;
            case EIGHT:
                rankString = "8";
                break;
            case NINE:
                rankString = "9";
                break;
            case TEN:
                rankString = "10";
                break;
            case JACK:
                rankString = "J";
                break;
            case QUEEN:
                rankString = "Q";
                break;
            case KING:
                rankString = "K";
                break;
            case ACE:
                rankString = "A";
                break;
        }

        switch (suit) {
            case Club:
                suitString = "\u2663";
                break;
            case Heart:
                suitString = "\u2665";
                break;
            case Spade:
                suitString = "\u2660";
                break;
            case Diamond:
                suitString = "\u2666";
                break;
        }
        return rankString + suitString;
    }

    @Override
    public int compareTo(PlayingCard playingCard) {
        return this.rank.compareTo(playingCard.rank);
    }
}
