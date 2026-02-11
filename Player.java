import java.util.Arrays;

public class Player {
    private int id;
    private int score = 0;
    private int [] hand = new int[20];
    private int handCount = 0;
    private boolean eliminated = false;

    public Player(int playerId){
        id = playerId;
    }

    public int getId(){
        return id;
    }
    
    public int getScore(){
        return score;
    }

    public boolean isEliminated(){
        return eliminated;
    }

    public void eliminate(){
        eliminated = true;
    }

    public void addScore(int points){
        score = score + points;
    }

    public boolean hasCards(){
        if (handCount > 0){
            return true;
        }else {
            return false;
        }
    }

    public void addCard(int card){
        hand[handCount] = card;
        handCount = handCount + 1;
    }
    public boolean isPair(int card){
        for (int i = 0; i <handCount; i++){
            if (hand[i] == card){
                return true;
            } else {
                return false;
            }
        }
    }
    public int lowestCard(){
        int smallest = hand[0];
        for (int i = 1; i < handCount; i++){
            if (hand[i] < smallest){
                smallest = hand[i];
            }
        }

        return smallest;
    }

    public void clearHand(Deck deck){
        for (int i = 0; i < handCount; i++){
            deck.addToDiscard(hand[i]);
        }
        handCount = 0;
    }
    
}   

