package arrays_and_strings.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {
            String pMove = playerMoves[i];
            String cMove = computerMoves[i];
            String result = playRound(pMove, cMove);

            System.out.printf("Round %d — Player: %s, Computer: %s | Result: %s%n", (i + 1), pMove, cMove, result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = ((double) wins / playerMoves.length) * 100.0;
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                playerMoves.length, wins, losses, draws, winPercentage);
    }
}