import java.util.Arrays;
import java.util.Scanner;

public class test_4 {
    public static void main(String [] args){
        Scanner keyboard_input = new Scanner(System.in);
        int score;
        int dice;
        String user;
        boolean bol = false;
        boolean lost_turn = false;
        int [] total_score = {0, 0, 0, 0};
        int n = 1;

        try{
            System.out.print("\n♦ Enter number of players:");
            int num_players = keyboard_input.nextInt();

            while(true){
                if (num_players > 4){
                    System.out.println("\nMaximum possible players is 4!");
                    break;
                } else if(num_players == 1){
                    System.out.println("\nMinimum possible players is 2!");
                    break;
                } else{
                    System.out.println("\n\n\t\t\t\t\t━━━━━━━━━━━━━━━━ \n\t\t\t\t\t\t TURN " + n + "\n\t\t\t\t\t━━━━━━━━━━━━━━━━");
                    for(int i=0; i < num_players; i++){
                        System.out.println("\n\n_______________________ PLAYER " + (i + 1) + " _______________________");
                        score = 0;

                        while(true){
                            System.out.print("\n\n♦ Enter 'R' to roll dice or 'H' to hold :-");
                            user = keyboard_input.next();

                            if(user.equals("H") || user.equals("h")){
                                System.out.println("\nHOLDING......" + "\n\nTurn Score:" + score + "\nTOTAL SCORES :- " + Arrays.toString(total_score));
                                break;

                            } else if(user.equals("R") || user.equals("r")){
                                dice = (int )(Math.random()*6+1);
                                score = score + dice;

                                if(dice == 1){
                                    lost_turn = true;
                                    score = 0;
                                    System.out.print("\nPLAYER " + (i + 1) +  " LOST THE TURN!\nResult:" + dice + "\nTurn score:" + score);
                                    total_score[i] += 0;
                                    break;
                                } else{
                                    System.out.print("\nResult: " + dice + "\nTurn Score: " + score);
                                }

                            } else{
                                System.out.print("\nError! Invalid input.");
                            }

                            if(!lost_turn) {
                                total_score[i] += score;
                                if (total_score[i] >= 100) {
                                    bol = true;
                                    System.out.print("\nPLAYER " + (i + 1) + " WINS!\n" + "\nTOTAL SCORES :- " + Arrays.toString(total_score));
                                    break;
                                }
                            }
                        }
                        if (bol){
                            break;
                        }
                    }
                    n ++;
                    if(bol){
                        break;
                    }
                }
            }
        }catch(Throwable e) {
            System.out.println("Error! Invalid input");
        }
    }
}

