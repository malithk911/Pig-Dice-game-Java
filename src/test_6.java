import java.util.Arrays;
import java.util.Scanner;

public class test_6 {
    public static int score = 0;
    public static int dice = 0;
    public static String user = "";
    public static boolean bol = false;
    public static int [] total_score = {0, 0, 0, 0};
    public static int n = 1;

    public static void main(String [] args) {
        pig_dice();
    }

    public static void pig_dice(){
        Scanner keyboard_input = new Scanner(System.in);

        try{
            System.out.println("\n\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\t\t\t\tP I G   D I C E   G A M E" + "\n\t\t\t━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("\n♦ Number of players: ");
            int num_players = keyboard_input.nextInt();

            while(true){
                if (1 < num_players && num_players < 5){
                    System.out.println("\n\n\n\t\t\t\t\tᐊᐊ    TURN " + n + "    ᐅᐅ");

                    for(int i=0; i < num_players; i++){
                        System.out.println("\n\n________________________ PLAYER " + (i + 1) + " _______________________");
                        score = 0;

                        while(true){
                            System.out.print("\n\nEnter 'R' to roll dice or 'H' to hold:- ");
                            user = keyboard_input.next();

                            if(user.equals("H") || user.equals("h")){
                                System.out.println("\nHOLDING......" + "\nTurn Score: " + score);
                                break;
                            } else if(user.equals("R") || user.equals("r")){
                                dice = (int )(Math.floor(Math.random()*6+1));
                                score = score + dice;
                                if(dice == 1){
                                    score = 0;
                                    System.out.print("\nPLAYER " + (i + 1) +  " LOST THE TURN!\nResult: " + dice + "\nTurn score: " + score);
                                    break;
                                } else{
                                    System.out.print("\nResult: " + dice + "\nTurn Score: " + score);
                                }
                            } else{
                                System.out.print("\tERROR! ENTER VALID INPUT!");
                            }
                        }

                        total_score[i] = total_score[i] + score;
                        if(total_score[i] >= 100){
                            bol = true;
                            System.out.print("\nPLAYER " + (i + 1) + " WINS!\n" + "\nTOTAL SCORES:- " + Arrays.toString(total_score) + "\n\n");
                            break;
                        }
                    }

                } else{
                    System.out.println("\tERROR! ENTER A NUMBER BETWEEN 2 AND 4!");
                    pig_dice();
                    break;
                }
                n ++;
                System.out.println("\nTOTAL SCORES :- " + Arrays.toString(total_score) + "\n\n");
                if(bol){
                    break;
                }
            }
        }catch(Throwable e) {
            System.out.println("\tERROR! ENTER A NUMBER!");
            pig_dice();
        }
    }
}
