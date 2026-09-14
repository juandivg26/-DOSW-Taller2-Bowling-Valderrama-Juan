package edu.eci.dosw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private final int frameNumber;
    private final List<Integer> rolls;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.rolls = new ArrayList<>();
    }

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public List<Integer> getRolls() {
        return List.copyOf(rolls);
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public FrameType getType() {
        if (frameNumber == 10) {
            return FrameType.TENTH;
        }
        if (!rolls.isEmpty() && rolls.get(0) == 10) {
            return FrameType.STRIKE;
        }
        if (rolls.size() == 2 && rolls.get(0) + rolls.get(1) == 10) {
            return FrameType.SPARE;
        }
        return FrameType.NORMAL;
    }

    /** true cuando este frame ya no puede recibir mas tiros. */
    public boolean isComplete() {
        if (frameNumber < 10) {
            return rolls.size() == 2 || (!rolls.isEmpty() && rolls.get(0) == 10);
        }
        return isTenthFrameComplete();
    }

    private boolean isTenthFrameComplete() {
        if (rolls.size() < 2) {
            return false;
        }
        int first = rolls.get(0);
        int second = rolls.get(1);
        boolean earnedThirdRoll = first == 10 || first + second == 10;
        if (earnedThirdRoll) {
            return rolls.size() == 3;
        }
        return true;
    }
}