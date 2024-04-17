import java.util.*;

public class Play {

    private int boardSize;
    private Map<Integer,Integer> snake;
    private Map<Integer,Integer> ladder;
    private Dice dice;
    private Map<String,Integer> playerAndCurrentPoistion;
    private List<String> playersQueue;
    private List<String> winners;

    public Play(int boardSize, Map<Integer, Integer> snake, Map<Integer, Integer> ladder, Dice dice,
            Map<String, Integer> playerAndCurrentPoistion, List<String> players) {
        this.boardSize = boardSize;
        this.snake = snake;
        this.ladder = ladder;
        this.dice = dice;
        this.playerAndCurrentPoistion = playerAndCurrentPoistion;
        this.playersQueue = players;
        this.winners=new ArrayList<String>();
    }

    //winners list
    
    int winnersCount=0;
    int TotalRollingCount=0;

    public void startGame(){
        while(playerAndCurrentPoistion.size()>winnersCount){
            int playerTurn=(TotalRollingCount%playerAndCurrentPoistion.size());
            String currentPlayerName=playersQueue.get(playerTurn);
            int currentPlayerPosition=playerAndCurrentPoistion.get(currentPlayerName);
            int diceRoll=dice.rollDice();
            int rollAndCurrentPosition=diceRoll+currentPlayerPosition;
            System.out.println("Rolling........ got "+diceRoll);
            if(rollAndCurrentPosition==boardSize){
                System.out.println(currentPlayerName+" moved to place"+rollAndCurrentPosition);
                winners.add(currentPlayerName);
                playerAndCurrentPoistion.remove(currentPlayerName);
                winnersCount++;
                playersQueue.remove(playerTurn);
                System.out.println(winnersCount+" Place is: "+winners.get(winnersCount-1));
            }
            else if(rollAndCurrentPosition>boardSize){
                System.out.println(currentPlayerName+" exceed the board waiting wait for next turn");
                playerAndCurrentPoistion.put(currentPlayerName, currentPlayerPosition);
            }
            else{
                //snake check
                if(snake.containsKey(rollAndCurrentPosition)){
                    System.out.println("Snake bitten "+currentPlayerName+" moved from "+rollAndCurrentPosition+" to "+snake.get(rollAndCurrentPosition));
                    playerAndCurrentPoistion.put(currentPlayerName, snake.get(rollAndCurrentPosition));
                }
                //ladder check
                else if(ladder.containsKey(rollAndCurrentPosition)){
                    System.out.println("huraaaah "+currentPlayerName+" got a ladder moved from "+rollAndCurrentPosition+" to "+ladder.get(rollAndCurrentPosition));
                    playerAndCurrentPoistion.put(currentPlayerName, ladder.get(rollAndCurrentPosition));
                }
                else{
                    System.out.println(currentPlayerName+" moved to place"+rollAndCurrentPosition);
                    playerAndCurrentPoistion.put(currentPlayerName, rollAndCurrentPosition);
                }
            }
            TotalRollingCount++;

        }
    }

    public void WinnerList(){
        System.out.println("Winners List");
        for(int i=0;i<winners.size();i++){
            System.out.println((i+1)+")"+winners.get(i));
        }
    }
    

   
}
