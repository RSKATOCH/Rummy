
import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADES, Card.Face.SIX));
        cards.add(new Card(Card.Suit.SPADES, Card.Face.FOUR));
        cards.add(new Card(Card.Suit.SPADES, Card.Face.THREE));
        cards.add(new Card(Card.Suit.SPADES, Card.Face.FIVE));
        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card(Card.Suit.SPADES, Card.Face.FIVE));
        cards2.add(new Card(Card.Suit.SPADES, Card.Face.FIVE));
        cards2.add(new Card(Card.Suit.SPADES, Card.Face.SEVEN));
        cards2.add(new Card(Card.Suit.SPADES, Card.Face.FOUR));
        cards = SequenceTools.getRummySequenceWithCard(cards, 2);
        System.out.println(RummyTools.isRummyRun(cards, 4));
        System.out.println(RummyTools.getSwapCards(cards2, cards));
        List<Card> cards3 = new ArrayList<>();
        cards3.add(new Card(Card.Suit.SPADES, Card.Face.ACE));
        cards3.add(new Card(Card.Suit.SPADES, Card.Face.THREE));
        cards3.add(new Card(Card.Suit.SPADES, Card.Face.ACE));
        cards3.add(new Card(Card.Suit.SPADES, Card.Face.FOUR));
        cards3.add(new Card(Card.Suit.SPADES, Card.Face.FIVE));
        System.out.println("SEQUENCE:"+RummyTools.getSwapCardsForSequenceDuplicate(cards3));
        System.out.println(cards);
        System.out.println(cards2);
        System.out.println(cards3);
        List<Card> cards4 = new ArrayList<>();
        cards4.add(new Card(Card.Suit.SPADES, Card.Face.ACE));
        cards4.add(new Card(Card.Suit.DIAMONDS, Card.Face.ACE));
        cards4.add(new Card(Card.Suit.DIAMONDS, Card.Face.ACE));
        cards4.add(new Card(Card.Suit.HEARTS, Card.Face.THREE));
        System.out.println(RummyTools.getSwapCardsForSetDuplicate(cards4));
    }
}
