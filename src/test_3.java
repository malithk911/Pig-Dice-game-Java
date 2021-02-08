import java.util.Arrays;
import java.util.Scanner;

public class test_3 {

    public static int score = 0;
    public static int dice = 0;
    public static String user = "";
    public static boolean bol = false;
    public static int [] total_score = {0, 0, 0, 0};
    public static int n = 1;

    public static void main(String [] args){

        Scanner keyboard_input = new Scanner(System.in);

        try{
            System.out.print("\n♦ Enter number of players:");
            int num_players = keyboard_input.nextInt();

            while(true){
                if (num_players > 4){
                    System.out.println("\nMaximum possible players is 4!");
                } else if(num_players == 1){
                    System.out.println("\nMinimum possible players is 2!");
                } else{
                    System.out.println("\n\n━━━━━━━━━ \n Turn " + n + "\n━━━━━━━━━");
                    for(int i=0; i < num_players; i++){
                        System.out.println("\n\n\n__________________________ PLAYER " + (i + 1) + " _________________________");
                        score = 0;

                        while(true){
                            System.out.print("\n\nEnter 'R' to roll dice or 'H' to hold :-");
                            user = keyboard_input.next();

                            if(user.equals("H") || user.equals("h")){
                                System.out.println("\nHOLDING......" + "\nTurn Score:" + score);
                                break;

                            } else if(user.equals("R") || user.equals("r")){
                                dice = (int )(Math.random()*6+1);
                                System.out.println(dice);
                                score = score + dice;

                                if(dice == 1){
                                    score = 0;
                                    System.out.print("\nPLAYER " + i + 1 +  " LOST THE TURN!\nResult:" + dice + "\nscore:" + score);
                                    break;
                                } else{
                                    System.out.print("\nResult: " + dice + "\nTurn Score: " + score);
                                }

                            } else{
                                System.out.print("\nError! Invalid input.");
                            }
                            total_score[i] += score;
                            if(total_score[i] >= 10){
                                bol = true;
                                System.out.print("\nPLAYER " + (i + 1) + " WINS!\n" + "\nTOTAL SCORES :- " + Arrays.toString(total_score));
                                break;
                            }
                        }
                    }
                    n ++;
                    if(bol){
                        break;
                    }
                }
            }
        } catch(Throwable e) {
            System.out.println("Error! Invalid input");
        }
    }
}

