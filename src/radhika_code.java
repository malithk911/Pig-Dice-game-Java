import java.util.Scanner;

public class radhika_code {
    public static void main(String[] args) {
        game_loop();
    }

    public static void game_loop(){
        int [] playerPoints = {0, 0, 0, 0};
        int turn = 0;
        int currentPlayersPoints;
        boolean gameIsRunning = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nW E L C O M E   T O   T H E   P I G   D I C E   G A M E");
        System.out.print("\nEnter number of players (between 2 and 4): ");
        int numberOfPlayers = scanner.nextInt();

        while (gameIsRunning){
            if (1 < numberOfPlayers && numberOfPlayers < 5){
                System.out.print(" \n\n-SCORES-\n\n");
                for (int i = 0; i < playerPoints.length; i++){
                    System.out.println("Player " + (i+1) + ": " + playerPoints[i]);
                }
                turn++;
                System.out.print("\n║   R O U N D   " + turn + "   ║\n");

                for (int x = 0; x < numberOfPlayers; x++){
                    System.out.print("\n\n_____________ Player " + (x + 1) + " ___________\n");
                    currentPlayersPoints = 0;

                    while (playerPoints[x] < 100){
                        System.out.print("\n\nEnter 'R' for ROLL and 'H' for HOLD: ");
                        String userTurn = scanner.next();

                        if (userTurn.equals("r") || userTurn.equals("R")){
                            int roll = (int) (Math.random() * 6 + 1);
                            if (roll != 1){
                                currentPlayersPoints += roll;
                                System.out.print("You rolled: " + roll + "\nRound score: " + currentPlayersPoints);
                                playerPoints[x] += roll;

                                if (playerPoints[x] >= 10){
                                    System.out.println("\n◀  P L A Y E R  " + (x + 1) + "   H A S   W O N   T H E   G A M E  ▶");
                                    gameIsRunning = false;
                                    break;
                                }
                            } else {
                                playerPoints[x] -= currentPlayersPoints;
                                System.out.print("\nYou rolled: " + roll + "\npoints earned\nCurrent score: " + playerPoints[x]);
                                break;
                            }
                        } else if (userTurn.equals("h") || userTurn.equals("H")){
                            System.out.print("\nYou have chosen to hold......\nYour score: " + playerPoints[x]);
                            break;
                        } else {
                            System.out.print("Enter a valid input!");
                        }
                    }


                    if (!gameIsRunning){
                        break;
                    }
                }


            } else {
                System.out.print("Enter number between 2 and 4!\n");
                game_loop();
            }
        }
    }
}

