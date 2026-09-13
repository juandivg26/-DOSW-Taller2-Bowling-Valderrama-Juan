package edu.eci.dosw.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingScorerTest {

    @Test
    @DisplayName("B1: juego con todos los tiros a 0 -> score() == 0")
    void allZeroGame_scoresZero() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertEquals(0, BowlingScorer.calculate(game.getFrames()));
    }
}