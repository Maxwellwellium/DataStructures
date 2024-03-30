import java.util.Scanner;

public class Main {

    enum Hand {
        ROCK, PAPER, SCISSORS;
    }
    enum Mode {
        EASY, HARD
    }

    public Main() {
        Mode gameMode = null;
        System.out.println("Enter game mode difficulty: Easy | Hard");
        Scanner difficulty = new Scanner(System.in);
        String difficultyChosen = difficulty.nextLine();
        gameMode = switch (difficultyChosen) {
            case "EASY", "Easy", "easy", "E", "e", "1" -> Mode.EASY;
            case "HARD", "Hard", "hard", "H", "h", "2" -> Mode.HARD;
            default -> gameMode;
        };

        Hand playerHand = null;
        System.out.println("Choose: Rock | Paper | Scissors");
        Scanner player = new Scanner(System.in);
        String choose = player.nextLine();

        playerHand = switch (choose) {
            case "ROCK", "Rock", "rock", "R", "r" -> Hand.ROCK;
            case "PAPER", "Paper", "paper", "P", "p" -> Hand.PAPER;
            case "SCISSORS", "Scissors", "scissors", "S", "s" -> Hand.SCISSORS;
            default -> playerHand;
        };
        Hand botHand = null;
        if (gameMode == Mode.EASY) {
            int[] rand = {0, 1, 2};
            int randChoose = rand[(int) Math.floor(Math.random() * rand.length)];
            botHand = switch (randChoose) {
                case 0 -> Hand.ROCK;
                case 1 -> Hand.PAPER;
                case 2 -> Hand.SCISSORS;
                default -> botHand;
            };
        }else{
            assert playerHand != null;
            botHand = switch (playerHand) {
                case Hand.ROCK -> Hand.PAPER;
                case Hand.PAPER -> Hand.SCISSORS;
                case Hand.SCISSORS -> Hand.ROCK;
            };
        }
        detectWinner(playerHand, botHand);

    }

    String detectWinner(Hand player, Hand bot){
        String outcome = "Game inconclusive, Computer Wins by default";
        if (player == bot) {
            outcome = "Tie, try again";
        }
        switch (player) {
            case Hand.ROCK:
                if (bot == Hand.PAPER) {
                    outcome = "Computer Wins: Paper beats Rock";
                }else{
                    outcome = "Player Wins: Rock beats Scissors";
                }
                break;

            case Hand.PAPER:
                if (bot == Hand.SCISSORS) {
                    outcome = "Computer Wins: Scissors beats Paper";
                }else{
                    outcome = "Player Wins: Paper beats Rock";
                }
                break;

            case Hand.SCISSORS:
                if (bot == Hand.ROCK) {
                    outcome = "Computer Wins: Rock beats Scissors";
                }else{
                    outcome = "Player Wins: Scissors beats Paper";
                }
                break;

        }
        System.out.println(outcome);
        return outcome;
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}