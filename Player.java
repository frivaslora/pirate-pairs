import java.util.Arrays;

public class Player {
    private int id;
    private int score = 0;
    private int [] hand = new int[20];
    private int handCount = 0;
    private boolean eliminated = false;

    public Player(int playerId){
        id = playerId;
        score = 0;
        hand = new int[20];
        handCount = 0;
        eliminated = false;
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
        handCount++;
    }
    public boolean isPair(int card){
        for (int i = 0; i <handCount; i++){
            if (hand[i] == card){
                return true;
            } 
        }

        return false;
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

    public boolean shouldFold(int lowestVisible){
        if(handCount == 0){
            return false;
        }
        int myLowest = lowestCard();
        
    if (lowestVisible < myLowest){
            return true;
        } else {
            return false;
        }
    }

    public String showHand(){
        String text = "[";
        for (int i = 0; i <handCount; i++){
            text = text + hand[i];

            if(i < handCount - 1){
                text = text + ",";
            }
        }
        text = text + "]";
        return text;
    }

}   

