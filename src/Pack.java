import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
    List<Card> cards = new ArrayList<>();

    public List<Card> getPackWithoutJoker() {
        cards.addAll(getSuit(Card.Suit.DIAMONDS));
        cards.addAll(getSuit(Card.Suit.HEARTS));
        cards.addAll(getSuit(Card.Suit.SPADES));
        cards.addAll(getSuit(Card.Suit.CLUBS));
        return cards;
    }

    public List<Card> getPackWithJokers() {
        cards = getPackWithoutJoker();
        cards.add(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
        cards.add(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
        return cards;
    }

    public static List<Card> getSuit(Card.Suit s) {
        List<Card> list = new ArrayList<>();
        for(int i = 2; i <= 14; i++) {
            list.add(new Card(s,i));
        }
        Collections.shuffle(list);
        return list;
    }
}