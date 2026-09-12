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
    return FrameType.NORMAL; // TODO: implementar con TDD
    }
}