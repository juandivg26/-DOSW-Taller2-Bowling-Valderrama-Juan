package edu.eci.dosw.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Calcula el puntaje total de un juego de Bowling a partir de sus
 * frames ya jugados. Es una clase sin estado.
 */
public final class BowlingScorer {

    private BowlingScorer() {
    }

    public static int calculate(List<Frame> frames) {
        List<Integer> allRolls = new ArrayList<>();
        for (Frame frame : frames) {
            allRolls.addAll(frame.getRolls());
        }

        int total = 0;
        int rollIndex = 0;

        for (int i = 0; i < 9; i++) {
            Frame frame = frames.get(i);
            if (frame.getType() == FrameType.STRIKE) {
                total += 10 + allRolls.get(rollIndex + 1) + allRolls.get(rollIndex + 2);
                rollIndex += 1;
            } else if (frame.getType() == FrameType.SPARE) {
                total += 10 + allRolls.get(rollIndex + 2);
                rollIndex += 2;
            } else {
                total += allRolls.get(rollIndex) + allRolls.get(rollIndex + 1);
                rollIndex += 2;
            }
        }

        // Frame 10: ya trae sus propios tiros de bono, se suma directo
        for (int pins : frames.get(9).getRolls()) {
            total += pins;
        }

        return total;
    }
}