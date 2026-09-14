package edu.eci.dosw.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("B2: juego sin strikes ni spares -> suma directa de todos los pinos")
    void gameWithoutStrikesOrSpares_scoresDirectSum() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(3);
        }

        assertEquals(60, BowlingScorer.calculate(game.getFrames()));
    }

    @Test
    @DisplayName("B3: spare en frame 1 con siguiente tiro 3 -> frame 1 puntua 10 + 3 = 13")
    void spareInFirstFrame_addsNextRollAsBonus() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5); 
        game.roll(3); 
        game.roll(0); 
        for (int i = 0; i < 16; i++) {
            game.roll(0); 
        }

        assertEquals(16, BowlingScorer.calculate(game.getFrames()));
    }

}