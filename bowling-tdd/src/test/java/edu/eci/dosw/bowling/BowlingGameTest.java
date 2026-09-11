package edu.eci.dosw.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BowlingGameTest {

    @Test
    @DisplayName("A1: roll(0) en el primer tiro no lanza excepcion y registra 0 pinos")
    void rollZero_firstRoll_doesNotThrowAndRegistersZero() {
        BowlingGame game = new BowlingGame();

        game.roll(0);

        assertEquals(1, game.getFrames().size());
        assertEquals(0, game.getFrames().get(0).getRolls().get(0));
    }

    @Test
    @DisplayName("A2: roll(-1) lanza IllegalArgumentException")
    void rollNegativePins_throwsException() {
        BowlingGame game = new BowlingGame();

        assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
    }
}