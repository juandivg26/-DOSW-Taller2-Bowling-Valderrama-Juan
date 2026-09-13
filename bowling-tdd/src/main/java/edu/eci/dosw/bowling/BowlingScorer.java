package edu.eci.dosw.bowling;

import java.util.List;

/**
 * Calcula el puntaje total de un juego de Bowling a partir de sus
 * frames ya jugados. Es una clase sin estado.
 */
public final class BowlingScorer {

    private BowlingScorer() {
    }

    public static int calculate(List<Frame> frames) {
        int total = 0;
        for (Frame frame : frames) {
            for (int pins : frame.getRolls()) {
                total += pins;
            }
        }
        return total;
    }
}