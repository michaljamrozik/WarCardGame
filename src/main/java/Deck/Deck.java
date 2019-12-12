package Deck;


import java.util.*;

public class Deck {

    private List<PlayingCard> deck = new ArrayList<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Queue<PlayingCard> dealCardsToPlayer1(){
        Queue<PlayingCard> queue = new ArrayDeque<PlayingCard>();
        for(int i =0;i<deck.size();i++){
            if(i%2!=0){
                queue.add(deck.get(deck.size()-1-i));
            }
        }
        return queue;
    }

    public Queue<PlayingCard> dealCardsToPlayer2(){
        Queue<PlayingCard> queue = new ArrayDeque<PlayingCard>();
        for(int i =0;i<deck.size();i++){
            if(i%2==0){
                queue.add(deck.get(deck.size()-i-1));
            }
        }
        return queue;
    }

    @Override
    public String toString() {
        return deck.toString();
        }
    }


