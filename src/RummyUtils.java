import java.util.*;

public class RummyUtils {

    public static Boolean isSetOfNCards(List<Card> cards, int n) {
        Boolean isSetOfNCards = true;
        if (cards.size() == n) {
            int faceValue = cards.get(0).getFaceValue();
            Set<Card.Suit> suitsFound = new HashSet<>();
            for (Card card : cards) {
                if (!(card.isJoker())) {
                    if (card.getFaceValue() != faceValue) {
                        isSetOfNCards = false;
                    }
                    if (suitsFound.contains(card.getSuit())) {
                        isSetOfNCards = false;
                    } else {
                        suitsFound.add(card.getSuit());
                    }
                }
            }
        }
        else {
            isSetOfNCards = false;
        }
        return isSetOfNCards;
    }

    public static Boolean isSequenceOfNCards(List<Card> cards, int n) {
        Boolean isSequenceOfNCards = true;
        Boolean couldStartWithAce = false;
        if (cards.size() == n) {
            sort(cards);
            if (cards.get(cards.size() - 1).getFaceValue() == 14) {
                couldStartWithAce = true;
            }
            int faceValueToLookFor = cards.get(0).getFaceValue();
            Card.Suit suitToLookFor = cards.get(0).getSuit();
            for (Card card : cards) {
                if (!(card.isJoker())) {
                    if (couldStartWithAce && (faceValueToLookFor == (n + 1)) && card.getFaceValue() == 14) {
                        isSequenceOfNCards = true;
                    }
                    else if (card.getFaceValue() != faceValueToLookFor) {
                        isSequenceOfNCards = false;
                        couldStartWithAce = false;
                    }
                    faceValueToLookFor ++;
                    if (card.getSuit() != suitToLookFor) {
                        isSequenceOfNCards = false;
                    }
                }
            }
        }
        else {
            isSequenceOfNCards = false;
        }
        return isSequenceOfNCards;
    }

    public static void sort(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getFaceValue() - o2.getFaceValue();
            }
        });
    }

    public static List<Card> cardsToSwap(List<Card> cards1, List<Card> cards2) {
        Set<Card> cardSet1 = new HashSet<>(cards1);
        Set<Card> cardSet2 = new HashSet<>(cards2);
        cardSet1.removeAll(cardSet2);
        cardSet1.remove(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
        return new ArrayList<>(cardSet1);
    }

    /*
    DOES NOT WORK WELL WITH DUPLICATES. REMOVE DUPLICATES BEFORE PROCEEDING.
     */
    public static List<Card> cardsToSwapToMakeSequence(List<Card> cards) {
        List<Card> minCardsToSwap = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            List<Card> sequence = SequenceGenerationUtil.generateSequenceRetainingCard(cards, i);
            sequence = cardsToSwap(cards, sequence);
            if (sequence.size() < minCardsToSwap.size()) {
                minCardsToSwap = sequence;
            }
        }
        return minCardsToSwap;
    }

    /*
    DOES NOT WORK WELL WITH DUPLICATES. REMOVE DUPLICATES BEFORE PROCEEDING.
     */
    public static List<Card> cardsToSwapToMakeSet(List<Card> cards) {
        List<Card> minCardsToSwap = new ArrayList<>(cards);
            for (int i = 0; i < cards.size(); i++) {
                List<Card> sequence = SetGenerationUtil.generateSetOfFour(cards.get(i));
                sequence = cardsToSwap(cards, sequence);
                if (sequence.size() < minCardsToSwap.size()) {
                    minCardsToSwap = sequence;
                }
            }
        return minCardsToSwap;
    }
}
