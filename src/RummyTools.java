import java.util.*;

public class RummyTools {

	public static Boolean isRummySet(List<Card> cards, int n) {
		Boolean isSetOfNCards = true;

		if(hasDuplicates(cards)) {
			return false;
		}

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

	public static boolean hasDuplicates(List<Card> cards) {

		for(int i=0;i<cards.size();i++) {
			Card checkCard = cards.get(i);

			if(cards.indexOf(checkCard)!=cards.lastIndexOf(checkCard)) {
				return true;
			}
		}
		return false;
	}

	public static Boolean isRummyRun(List<Card> cards, int length) {

		Boolean isRun = true;
		Boolean AceStart = false;

		if(hasDuplicates(cards)) {
			return false;
		}

		if (cards.size() == length) {
			sort(cards);
			
			if (cards.get(cards.size() - 1).getFaceValue() == 14) {
				AceStart = true;
			}
			
			int reqFace = cards.get(0).getFaceValue();
			Card.Suit suitToLookFor = cards.get(0).getSuit();
			for (Card card : cards) {
				
				if (!(card.isJoker())) {
					if (AceStart && (reqFace == (length + 1)) && card.getFaceValue() == 14) {
						isRun = true;
					}
					else if (card.getFaceValue() != reqFace) {
						isRun = false;
						AceStart = false;
					}
					reqFace ++;
					if (card.getSuit() != suitToLookFor) {
						isRun = false;
					}
				}
			}
		}
		else {
			isRun = false;
		}
		return isRun;
	}

	public static void sort(List<Card> cards) {
		Collections.sort(cards, new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				return o1.getFaceValue() - o2.getFaceValue();
			}
		});
	}

	public static List<Card> getSwapCards(List<Card> cards1, List<Card> cards2) {
		
		Set<Card> cardSet1 = new HashSet<>(cards1);
		Set<Card> cardSet2 = new HashSet<>(cards2);	
		
		cardSet1.removeAll(cardSet2);
		cardSet1.remove(new Card(Card.Suit.WILDCARD, Card.Face.WILDCARD));
		
		return new ArrayList<>(cardSet1);
	}

	/*
    DOES NOT WORK WELL WITH DUPLICATES. REMOVE DUPLICATES BEFORE PROCEEDING.
	 */
	 public static List<Card> getSwapCardsForSequence(List<Card> cards) {
		
		 List<Card> minCardsToSwap = new ArrayList<>(cards);
		
		 for (int i = 0; i < cards.size(); i++) {
			List<Card> sequence = SequenceTools.getRummySequenceWithCard(cards, i);
			sequence = getSwapCards(cards, sequence);
			if (sequence.size() < minCardsToSwap.size()) {
				minCardsToSwap = sequence;
			}
		}
		 
		return minCardsToSwap;
	}

	/*
    DOES NOT WORK WELL WITH DUPLICATES. REMOVE DUPLICATES BEFORE PROCEEDING.
	 */
	 public static List<Card> getSwapCardsForSet(List<Card> cards) {
		List<Card> minCardsToSwap = new ArrayList<>(cards);
		for (int i = 0; i < cards.size(); i++) {
			List<Card> sequence = SetTools.getMaxSet(cards.get(i));
			sequence = getSwapCards(cards, sequence);
			if (sequence.size() < minCardsToSwap.size()) {
				minCardsToSwap = sequence;
			}
		}
		return minCardsToSwap;
	 }
	 
	 public static List<Card> getSwapCardsForSequenceDuplicate(List<Card> cards) {
			
		 List<Card> minCardsToSwap = new ArrayList<>();
		 List<Card> uniqueCardSet = new ArrayList<>(cards);
		 if(hasDuplicates(cards)) {
			 for(int i=0;i<uniqueCardSet.size();i++) {
				 Card card = uniqueCardSet.get(i);
				 if(!minCardsToSwap.contains(card) && uniqueCardSet.indexOf(card)!=uniqueCardSet.lastIndexOf(card)) {
					 minCardsToSwap.add(card);
					 uniqueCardSet.remove(uniqueCardSet.lastIndexOf(card));
					 i--;
				 }
			 }
		 }
		 minCardsToSwap.addAll(getSwapCardsForSequence(uniqueCardSet));
		 return minCardsToSwap;
	}
	 
	 public static List<Card> getSwapCardsForSetDuplicate(List<Card> cards) {
			
		 List<Card> minCardsToSwap = new ArrayList<>();
		 List<Card> uniqueCardSet = new ArrayList<>(cards);
		 if(hasDuplicates(cards)) {
			 for(int i=0;i<uniqueCardSet.size();i++) {
				 Card card = uniqueCardSet.get(i);
				 if(!minCardsToSwap.contains(card) && uniqueCardSet.indexOf(card)!=uniqueCardSet.lastIndexOf(card)) {
					 minCardsToSwap.add(card);
					 uniqueCardSet.remove(uniqueCardSet.lastIndexOf(card));
					 i--;
				 }
			 }
		 }
		 minCardsToSwap.addAll(getSwapCardsForSet(uniqueCardSet));
		 return minCardsToSwap;
	}
	
}
