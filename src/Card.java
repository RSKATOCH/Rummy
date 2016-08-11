
public class Card {
    private Suit suit;
    private Face face;

    public Card (Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Card (Suit suit, int faceValue) {
        this.suit = suit;
        switch(faceValue) {
            case 2 : face = Face.TWO; break;
            case 3 : face = Face.THREE; break;
            case 4 : face = Face.FOUR; break;
            case 5 : face = Face.FIVE; break;
            case 6 : face = Face.SIX; break;
            case 7 : face = Face.SEVEN; break;
            case 8 : face = Face.EIGHT; break;
            case 9 : face = Face.NINE; break;
            case 10 : face = Face.TEN; break;
            case 11 : face = Face.JACK; break;
            case 12 : face = Face.QUEEN; break;
            case 13 : face = Face.KING; break;
            case 14 : face = Face.ACE; break;
        }
    }

    public int getFaceValue() {
        return this.face.getValue();
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public boolean equals(Object c) {
        return this.hashCode() == c.hashCode();
    }

    @Override
    public String toString() {
        return "" + this.face.toString() + " " + this.suit.toString();
    }

    public Boolean isJoker() {
        return this.suit.equals(Suit.WILDCARD) && this.face.equals(Face.WILDCARD);
    }

    @Override
    public int hashCode() {
        int suitValue;
        if (suit.equals(Suit.WILDCARD)){
            suitValue = 0;
        }
        else if (suit.equals(Suit.SPADES)) {
            suitValue = 1;
        }
        else if (suit.equals(Suit.HEARTS)) {
            suitValue = 2;
        }
        else if (suit.equals(Suit.DIAMONDS)) {
            suitValue = 3;
        }
        else {
            suitValue = 4;
        }
        return suitValue * 14 + getFaceValue();
    }

    public enum Face {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14), WILDCARD(0);

        private int value;
        Face(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS, WILDCARD
    }
}
