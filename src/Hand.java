import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand {
    List<Card> cards;
    public Hand(List<Card> cards) {
        this.cards = cards;
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(Card card) {
        if (cards.remove(card)) {
            return card;
        }
        return null;
    }

    public Card removeTop() {
        Card card = cards.get(0);
        cards.remove(card);
        return card;
    }



}
