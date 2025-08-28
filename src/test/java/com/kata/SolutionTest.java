package com.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void givenNullInput_whenRunFindWinner_thenThrowException() {
        var game = new Solution();
        assertThrows(IllegalArgumentException.class, () -> game.findWinner(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        "ABC",
        "A B   ",
        " A B   "
    })
    public void givenInvalidInput_whenRunFindWinner_thenThrowException(String invalidInput) {
        var game = new Solution();
        assertThrows(IllegalArgumentException.class, () -> game.findWinner(invalidInput));
    }

    @ParameterizedTest
    @CsvSource({
        "AAAA,A",
        "BBBB,B",
        "AAAB,No winner",
        "ABAB,No winner",
        "AABABB,No winner",
        "AAABBBAB,No winner",
        "AAABBBABA,No winner",
        "AAABBBBAABB,No winner",
        "AAABBBABABA,No winner",
        "ABBABBABB,B",
        "ABABABABAB,No winner",
        "AAABBBABBB,B",
        "AAABBB,No winner",
        "AAAB,No winner",
        "ABABAA,A",
        "AABBAA,A",
        "AAABBBBB,B",
        "ABABABABABABABABAA,A",
        "AAA,No winner",
        "AAABBBAB,No winner",
        "ABABABABAB,No winner",
        "AABBAB,No winner",
        "AAABBBABAA,A",
        "AAABBBABBB,B",
        "AAAA,A",
        "AAAAB,A",
        "AAABBBAB,No winner",
        "AAAB,No winner",
        "ABAABBBAAA,A",
        "ABAABBBAABBAABBAABBB,B"
    })
    public void givenValidInput_whenRunFindWinner_thenWinnerFoundCorrectly(String roundWinners, String expectedWinner) {
        var game = new Solution();
        assertEquals(expectedWinner, game.findWinner(roundWinners));
    }
}