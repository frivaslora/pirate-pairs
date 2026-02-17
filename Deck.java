import java.util.Random;
import java.util.Arrays;

public class Deck {
    private int cards[];
    private int top;

    private int [] discard;
    private int discardCount;

    public Deck(){
        cards = new int[55];
        int index = 0;
        
        for(int number = 1; number <= 10; number++){
            for(int count = 0; count < number; count++){
                cards[index] = number;
                index++;
            }
        }
        top = 0;
        discard = new int[55];
        discardCount = 0;
    }

    public void shuffle(){
        Random rand = new Random();
        for(int i = 0; i < cards.length ; i++){
            int randomIndex = rand.nextInt(cards.length);
            int temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public int drawCard(){
        if (top >= cards.length){
            shuffle();
            top = 0;
;        }
        int card = cards[top];
        top++;
        return card;
    }

    public void addToDiscard(int card){
        discard[discardCount] = card;
        discardCount++;
    }

    private void reshuffleDiscard(){
        for(int i = 0; i < discardCount; i++){
            cards[i] = discard[i];
        }
        top =0;
        discardCount = 0;
        shuffle();
    }

}
