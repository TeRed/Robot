package com.robot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Simulate {
    private static List<Transmitter> transmitters;
    private static Robot robot;
    private static int width;
    private static int height;

    public static int randInt(int bound) {
        return (new Random()).nextInt(bound + 1);
    }

    //Used to simulate given situation
    //Arguments contain strings with positions of transmitters, robot and map size
    //In case of problems new values are generated
    //Return value is all new values for positions
    public static List<Integer> simulate(List<String> arguments) {

        //Parser
        List<Integer> retval = new ArrayList<>(12);
        try {
            width = Integer.parseInt(arguments.get(0));
            height = Integer.parseInt(arguments.get(1));
        } catch(NumberFormatException e) {
            width = height = 500;
        }
        if(width <= 0 || height <= 0) {
            width = height = 500;
        }
        retval.add(width);
        retval.add(height);

        try {
            int x = Integer.parseInt(arguments.get(2));
            int y = Integer.parseInt(arguments.get(3));
            robot = new Robot(x, y);
        } catch(NumberFormatException e) {
            robot = new Robot(randInt(width), randInt(height));
        }
        if(robot.getX() < 0 || robot.getX() >= width
                || robot.getY() < 0 || robot.getY() >= height) robot = new Robot(randInt(width), randInt(height));
        retval.add(robot.getX());
        retval.add(robot.getY());

        transmitters = new ArrayList<>();
        for(int i = 4; i < arguments.size(); i+=2) {
            Transmitter tmp;
            try {
                int x = Integer.parseInt(arguments.get(i));
                int y = Integer.parseInt(arguments.get(i + 1));
                tmp = new Transmitter(x, y, randInt(1000), randInt(1000));
            } catch(NumberFormatException e) {
                tmp = new Transmitter(randInt(width), randInt(height), randInt(1000), randInt(1000));
            }
            if(tmp.getX() < 0 || tmp.getX() >= width
                    || tmp.getY() < 0 || tmp.getY() >= height) tmp = new Transmitter(randInt(width), randInt(height), randInt(1000), randInt(1000));
            transmitters.add(tmp);
        }
        for(Transmitter handler : transmitters) {
            retval.add(handler.getX());
            retval.add(handler.getY());
        }


        //Simulation
        robot.setPositionBetweenTransmitters(transmitters);

        retval.add(robot.getX());
        retval.add(robot.getY());

        return retval;
    }
}
