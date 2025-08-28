package com.kata;

import java.util.List;

public class Solution {

    private static final int FORTY = 40;

    // Mark next point
    private int nextPoint(int currentPoint) {
        return switch (currentPoint) {
            case 0 -> 15;
            case 15 -> 30;
            default -> FORTY;
        };
    }

    private String getAndPrintWinner(String name) {
        System.out.printf("Player %s wins%n", name);
        return name;
    }

    /**
     * Print the match result and find winner.
     *
     * @param result    String containing AB for each player winning round
     *
     * @return the player name if winner is found, else return "No Winner" as match is not completed.
     */
    public String findWinner(String result) {
        if (result == null || !result.matches("[AB]+")) {
            throw new IllegalArgumentException("Invalid input");
        }

        int scoreA = 0, scoreB = 0;
        boolean winFortyOrAdvA = false, winFortyOrAdvB = false, deuce = false;

        System.out.println(result);

        for (char scorer : result.toCharArray()) {
            if (scorer == 'A') {
                // score after winning 40 points or having advantage -> Win
                if (winFortyOrAdvA) return getAndPrintWinner("A");
                scoreA = nextPoint(scoreA);
                // mark win 40 points or have advantage
                winFortyOrAdvA = scoreA == FORTY;
            } else {
                // same logic
                if (winFortyOrAdvB) return getAndPrintWinner("B");
                scoreB = nextPoint(scoreB);
                winFortyOrAdvB = scoreB == FORTY;
            }

            if (winFortyOrAdvA && winFortyOrAdvB) {
                System.out.println("Deuce");
                winFortyOrAdvA = false;
                winFortyOrAdvB = false;
                deuce = true;
            } else if (deuce) {
                if (winFortyOrAdvA) {
                    System.out.println("Advantage-A");
                } else {
                    System.out.println("Advantage-B");
                }
                deuce = false;
            } else {
                System.out.printf("Player A: %s / Player B : %s%n", scoreA, scoreB);
            }
        }

        System.out.println("Match doesn't end");
        return "No winner";
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var examples = List.of(
            "ABABAA",
            "ABAABBBAABBAABBAABBB",
            "AAABBBAB"
        );
        for (String example : examples) {
            System.out.println("============");
            solution.findWinner(example);
        }
    }
}
