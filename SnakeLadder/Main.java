import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        //board size
        System.out.println("Enter board size");
        int boardSize=sc.nextInt();

        //snack tail head
        Map<Integer,Integer> snake=new HashMap<>();

        //ladder tail,head
        Map<Integer,Integer> ladder=new HashMap<>();

        //snake
        System.out.println("enter no.of snake");
        int snakeCount=sc.nextInt();
        for(int i=0;i<snakeCount;i++){
            System.out.println("Enter snake Head Value");
            int head=sc.nextInt();
            System.out.println("Enter snake tail Value");
            int tail=sc.nextInt();
            while(head<tail){
                System.out.println("Sorry..! The tail is typically smaller than the head...");
                System.out.println("Enter snake tail Value");
                tail=sc.nextInt();
            }
            snake.put(head, tail);
        }
        System.out.println("********************************************");
        //ladder
        System.out.println("enter no.of Ladder");
        int ladderCount=sc.nextInt();
        for(int i=0;i<ladderCount;i++){
            System.out.println("Enter Ladder Head Value");
            int head=sc.nextInt();
            System.out.println("Enter Ladder tail Value");
            int tail=sc.nextInt();
            while(head>tail){
                System.out.println("Sorry..! The tail is typically greater than the head...");
                System.out.println("Enter ladder tail Value");
                tail=sc.nextInt();
            }
            ladder.put(head, tail);
        }

        System.out.println("********************************************");

        //set Dice 
        Dice dice=new Dice();
        System.out.println("No of Dices");
        int totalDices=sc.nextInt();
        dice.setDices(totalDices);

        System.out.println("********************************************");

        //no of player 
        Map<String,Integer> playerAndCurrentPoistion=new HashMap<>();
        System.out.println("Enter no.of player");
        int playerCount=sc.nextInt();
        int i=0;
        List<String> players=new ArrayList<>();
        while(i<playerCount){
            System.out.println("Enter player no "+(i+1)+" name:");
            String name=sc.next();
            if(!playerAndCurrentPoistion.containsKey(name)){
                playerAndCurrentPoistion.put(name, 0);
                players.add(name);
                i++;
            }
            else{
                System.out.println("Name is already taken please try another name");
            }
        }

        System.out.println("All Done let's play");
        Play play=new Play(boardSize,snake,ladder,dice,playerAndCurrentPoistion,players);
        play.startGame();
        play.WinnerList();
    }
}
