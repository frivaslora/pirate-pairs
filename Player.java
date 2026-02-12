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
    /* 
    public static void main(String[] args){
       Player p = new Player(1);

        p.addCard(3);
        p.addCard(5);
        p.addCard(8);

        System.out.println("Player ID: " + p.getId());
        System.out.println("Score: " + p.getScore());
        System.out.println("hand: " + p.showHand());

        System.out.println(" lowest card: " +p.lowestCard());
        
        System.out.println("is 5 a pair:? "+ p.isPair(5));
        System.out.println("is 7 a pair: " + p.isPair(7));

        System.out.println("has cards? " +p.hasCards());

        System.out.println("should fold if lowest visible is 4? " + p.shouldFold(4));

        p.addScore(10);
        System.out.println("New score: " + p.getScore());
        p.eliminate();
        System.out.println("is eliminated " + p.isEliminated());

        Deck testDeck = new Deck();
        p.clearHand(testDeck);
        System.out.println("hand after clearing: " + p.showHand());
    }
    */
    
}   

