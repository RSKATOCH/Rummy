import java.util.ArrayList;
import java.util.List;

public class SequenceTools {
    public static List<Card> generateSequence(Card beginCard, int length) {
        Card previousCard = beginCard;
        List<Card> cards = new ArrayList<> ();
        cards.add(beginCard);
        for (int i = 0; i < length-1 ; i++) {
            int nextCardValue = previousCard.getFaceValue() + 1;
            if (nextCardValue == 15) {
                nextCardValue = 2;
            }
            Card card = new Card(previousCard.getSuit(), nextCardValue);
            cards.add(card);
            previousCard = card;
        }
        return cards;
    }
    public static List<Card> getRummySequenceWithCard(List<Card> cards, int position) {
        Card card = cards.get(position);
        int length = cards.size();
        int faceValueOfFirstCard = card.getFaceValue() - position;
        if (faceValueOfFirstCard == 1) {
            faceValueOfFirstCard = 14;
        }
        else if (faceValueOfFirstCard == 0) {
            faceValueOfFirstCard = 14;
        }
        Card firstCard = new Card(card.getSuit(), faceValueOfFirstCard);
        return generateSequence(firstCard, length);
    }
}
