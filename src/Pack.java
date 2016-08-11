import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
    List<Card> cards = new ArrayList<>();

    public List<Card> getPackWithoutJoker() {
        cards.addAll(getAllOfSuit(Card.Suit.DIAMONDS));
        cards.addAll(getAllOfSuit(Card.Suit.HEARTS));
        cards.addAll(getAllOfSuit(Card.Suit.SPADES));
        cards.addAll(getAllOfSuit(Card.Suit.CLUBS));
        return cards;
    }

    public List<Card> getPackWithJokers() {
        cards = getPackWithoutJoker();
        cards.add(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
        cards.add(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
        return cards;
    }

    public static List<Card> getAllOfSuit(Card.Suit s) {
        List<Card> list = new ArrayList<>();
        for(int i = 2; i <= 14; i++) {
            list.add(new Card(s,i));
        }
        Collections.shuffle(list);
        return list;
    }
}