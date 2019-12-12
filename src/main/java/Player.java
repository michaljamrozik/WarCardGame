
import Deck.PlayingCard;

import java.util.List;
import java.util.Queue;

public class Player {

    private String nick;
    private int quantityOfCards;
    private Queue<PlayingCard> playingCards;

    void setPlayingCards(Queue<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    Queue<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public Player(String nick) {
        this.nick = nick;
    }

    int getQuantityOfCards() {
        return quantityOfCards;
    }

    void setQuantityOfCards(int quantityOfCards) {
        this.quantityOfCards = quantityOfCards;
    }

    String getNick() {
        return nick;
    }


    public void add(PlayingCard playingCard) {
        playingCards.add(playingCard);
        quantityOfCards++;
    }

    void addCards(List<PlayingCard> carts){
        playingCards.addAll(carts);
        quantityOfCards+=carts.size();
    }

    void remove(){
        playingCards.remove();
        quantityOfCards--;
    }

    public void moveFirstToTheEnd(){
        PlayingCard temp = playingCards.peek();
        playingCards.remove();
        playingCards.add(temp);
    }

    @Override
    public String toString() {
        return getNick() + ": " + getPlayingCards() + " total cards: " +getQuantityOfCards();
    }
}
