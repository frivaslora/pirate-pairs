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
}   

