import java.util.Arrays;

public class Deck {
    private int[] cards = new int[55];
    private int nextCard = 0;

    private int [] discard = new int[55];
    private int discardCount = 0;

    public Deck(){
        int index = 0;
        
        for(int number = 1; number <= 10; number++){
            for(int count = 0; count < number; count++){
                cards[index] = number;
                index++;
            }
        }
    }

    public void shuffle(){
        for(int i = 0; i < cards.length; i++){
            int randomIndex = (int)(Math.random() * cards.length);

            int temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public int drawCard(){
        if (nextCard >= cards.length){
            return -1
;        }
        int card = cards[nextCard];
        nextCard++;
        return card;
    }

    public void addToDiscard(int card){
        discard[discardCount] = card;
        discardCount++;
    }

    public boolean isEmpty(){
        return nextCard>= cards.length;
    }

}
