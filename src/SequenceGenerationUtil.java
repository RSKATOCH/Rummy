import java.util.ArrayList;
import java.util.List;

public class SequenceGenerationUtil {
    public static List<Card> generateSequence(Card startingCard, int length) {
        Card previousCard = startingCard;
        List<Card> cards = new ArrayList<> ();
        cards.add(startingCard);
        for (int i = 0; i < length-1 ; i++) {
            int faceValueToAdd = previousCard.getFaceValue() + 1;
            if (faceValueToAdd == 15) {
                faceValueToAdd = 2;
            }
            Card card = new Card(previousCard.getSuit(), faceValueToAdd);
            cards.add(card);
            previousCard = card;
        }
        return cards;
    }
    public static List<Card> generateSequenceRetainingCard(List<Card> cards, int indexToRetain) {
        Card cardToRetain = cards.get(indexToRetain);
        int length = cards.size();
        int faceValueOfFirstCard = cardToRetain.getFaceValue() - indexToRetain;
        if (faceValueOfFirstCard == 1) {
            faceValueOfFirstCard = 14;
        }
        else if (faceValueOfFirstCard == 0) {
            faceValueOfFirstCard = 13;
        }
        Card firstCard = new Card(cardToRetain.getSuit(), faceValueOfFirstCard);
        return generateSequence(firstCard, length);
    }
}
