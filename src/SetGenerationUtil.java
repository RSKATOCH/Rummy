import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetGenerationUtil {
    public static List<Card> generateSetOfFour(Card card) {
        Set<Card.Suit> suits = new HashSet<>();
        suits.add(Card.Suit.SPADES);
        suits.add(Card.Suit.CLUBS);
        suits.add(Card.Suit.HEARTS);
        suits.add(Card.Suit.DIAMONDS);
        suits.remove(card.getSuit());
        List<Card> setOfCards = new ArrayList<>();
        setOfCards.add(card);
        for (Card.Suit suit : suits) {
            setOfCards.add(new Card(suit, card.getFaceValue()));
        }
        return setOfCards;
    }
}
