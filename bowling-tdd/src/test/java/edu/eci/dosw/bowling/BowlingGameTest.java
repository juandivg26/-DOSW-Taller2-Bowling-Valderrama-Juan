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

    @Test
    @DisplayName("A3: roll(11) lanza IllegalArgumentException")
    void rollMoreThanTenPins_throwsException() {
        BowlingGame game = new BowlingGame();

        assertThrows(IllegalArgumentException.class, () -> game.roll(11));
    }

    @Test
    @DisplayName("A4: dos tiros de un frame que suman mas de 10 lanzan IllegalArgumentException en el segundo")
    void twoRollsExceedingTenInSameFrame_throwsExceptionOnSecondRoll() {
        BowlingGame game = new BowlingGame();
        game.roll(7);

        assertThrows(IllegalArgumentException.class, () -> game.roll(6));
    }

    @Test
    @DisplayName("A5: roll() cuando el juego ya esta completo lanza IllegalStateException")
    void rollAfterGameComplete_throwsIllegalStateException() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertThrows(IllegalStateException.class, () -> game.roll(0));
    }

    @Test
    @DisplayName("A6: roll(10) detecta strike y avanza directamente al siguiente frame")
    void rollTen_marksStrikeAndAdvancesFrame() {
        BowlingGame game = new BowlingGame();
        game.roll(10);

        assertEquals(FrameType.STRIKE, game.getFrames().get(0).getType());
        assertEquals(2, game.getFrames().size());
    }
    
}