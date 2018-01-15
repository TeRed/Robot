package com.robot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Robot {
    //Robot position
    private int x;
    private int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Goes to given transmitter
    //If 'returnHalfWay' set true, robot also goes back half way but in shortest line
    private void goToTransmitter(Transmitter transmitter, boolean returnHalfWay) {
        int moveRight = 0;
        int moveDown = 0;
        int lastMove = -1;

        while(true) {
            //Possible moves
            int[][] toCheckTemplate = {{x-1,y-1},{x,y-1},{x+1,y-1},{x+1,y},{x+1,y+1},{x,y+1},{x-1,y+1},{x-1,y}};

            //Moves to be checked
            int[] toCheck;
            List<Double> signals = new ArrayList<>();

            //Checking which moves need to be checked
            if(lastMove == -1) {
                toCheck = new int[toCheckTemplate.length];
                for(int i = 0; i < toCheck.length; i++) toCheck[i] = i;
            }
            else {
                toCheck = new int[3];
                toCheck[0] = (lastMove-1) == -1 ? 7 : (lastMove-1);
                toCheck[1] = lastMove;
                toCheck[2] = (lastMove+1) == 8 ? 0 : (lastMove+1);
            }

            //Signals in all moves
            for(int index : toCheck) {
                signals.add(transmitter.getSignal(toCheckTemplate[index][0], toCheckTemplate[index][1]));
            }

            //Getting max signal
            int maxSignalId = 0;
            for(int i = 0; i < signals.size(); i++) {
                if(signals.get(i) > signals.get(maxSignalId)) maxSignalId = i;
            }
            int maxId = toCheck[maxSignalId];

            //Counting all moves
            if(toCheckTemplate[maxId][0] > x) moveRight++;
            else if(toCheckTemplate[maxId][0] < x) moveRight--;

            if(toCheckTemplate[maxId][1] > y) moveDown++;
            else if(toCheckTemplate[maxId][1] < y) moveDown--;

            this.setXY(toCheckTemplate[maxId][0], toCheckTemplate[maxId][1]);
            lastMove = maxId;

            //Checking if we've reached transmitter
            if(Double.POSITIVE_INFINITY == signals.get(maxSignalId)) break;
        }
        if(returnHalfWay) this.setXY(x - (moveRight/2), y - (moveDown/2));
    }

    private void sortTransmitters(List<Transmitter> transmitters) {
        if(transmitters.get(0).getSignal(x, y) > transmitters.get(1).getSignal(x, y))
            Collections.swap(transmitters, 0, 1);

        if(transmitters.get(1).getSignal(x, y) > transmitters.get(2).getSignal(x, y))
            Collections.swap(transmitters, 1, 2);

        if(transmitters.get(0).getSignal(x, y) > transmitters.get(1).getSignal(x, y))
            Collections.swap(transmitters, 0, 1);
    }

    //Robot goes between three (of at least three) transmitters
    public void setPositionBetweenTransmitters(List<Transmitter> transmitters) {

        sortTransmitters(transmitters);
        Transmitter min = transmitters.get(2);

        goToTransmitter(min, false);

        sortTransmitters(transmitters);

        Transmitter other1 = transmitters.get(1), other2 = transmitters.get(0);

        goToTransmitter(other1, true);
        goToTransmitter(other2, true);
    }

    @Override
    public String toString() {
        return "Robot {x=" + x + "; y=" + y + "}";
    }
}
