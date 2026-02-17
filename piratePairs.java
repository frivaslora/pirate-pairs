public class piratePairs {

    public static void main(String[] args){
        int numPlayers = 3;
        Player [] players = new Player[numPlayers];

        for(int i = 0; i < numPlayers; i++){
            players[i] = new Player(i+1);
        }
        Deck deck = new Deck();
        deck.shuffle();

        int losingScore = (60/numPlayers) + 1;
        System.out.println("losing score: " + losingScore);

        boolean gameOver = false;
        Player p;
        while(!gameOver){
            for(int i = 0; i < numPlayers; i++){
                p = players[i];
                System.out.println(p.getScore());

                if(p.isEliminated()){
                    continue;
                }
        
            System.out.println("Player " + p.getId() + "'s turn");
        
            if(!p.hasCards()){
                int card = deck.drawCard();
                p.addCard(card);
                System.out.println("Drew: " + card);
                System.out.println("and now: " + p.showHand());
                continue;
            }
        
            int lowestVisible = 99;
            for(int j = 0; j < numPlayers; j++){
                if(players[j].hasCards()){
                    int lowest = players[j].lowestCard();
                    if(lowest < lowestVisible){
                        lowestVisible = lowest;
                    }
                }
            }
            
            if(p.shouldFold(lowestVisible)){
                int points = lowestVisible;
                p.addScore(points);
                System.out.println("Player folds and takes " + points + " points");
                p.clearHand(deck);
            } else {
                int card = deck.drawCard();
                System.out.println("Player draws: " + card);

                if(p.isPair(card)){
                    p.addScore(card);
                    System.out.println("Player drew a pair! " + card);
                    p.clearHand(deck);
                } else {
                    p.addCard(card);
                    System.out.println("Safe. Hand now: " + p.showHand());
                }
            }
            
                if(p.getScore() > losingScore){
                    p.eliminate();
                    System.out.println("Player " + p.getId() + " is eliminated");
                }   
            
            }
        
            int active = 0;
            for(int i = 0; i < numPlayers; i++){
            if(!players[i].isEliminated()){
                active++;
            }
            }
        
            if(active <=1){
                gameOver = true;
            }
        }
    
    
        for(int i = 0; i < numPlayers; i++){
        System.out.println("Player " + players[i].getId() + "score: " + players[i].getScore());
        }
    }
}
