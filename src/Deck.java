import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;
    public Deck() {
        cards.addAll(new Pack().getPackWithJokers());
        cards.addAll(new Pack().getPackWithJokers());

    }
    private void shuffleAndPickJoker() {
        Collections.shuffle(cards);
        Card chosenJoker = cards.get(0);
        cards.remove(chosenJoker);
        if (chosenJoker.isJoker()) {
            chosenJoker = new Card(Card.Suit.SPADES, Card.Face.ACE);
        }
        for (int i = 0; i < cards.size() ; i++) {
            if (cards.get(i).equals(chosenJoker)) {
                cards.set(i, new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
            }
        }
    }
    public List<Card> getCards() {
        return cards;
    }

    public List<Card> dealNCards(int n) {
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            dealtCards.add(cards.remove(0));
        }
        return dealtCards;
    }
}
