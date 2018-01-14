package robot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Simulate {
    private List<Transmitter> transmitters;
    private Robot robot;
    private int width;
    private int height;

    /*private double charon(Punkt2D point1, Punkt2D point2, Punkt2D point3){
        double area,edge12,edge13,edge23,p;
        edge12 = point1.distance(point2);
        edge13 = point1.distance(point3);
        edge23 = point2.distance(point3);
        p=(edge12+edge13+edge23)/2;
        area=Math.sqrt(Math.abs(p*(p-edge12)*(p-edge13)*(p-edge23)));
        return area;

    }

    private boolean checkPos(List<Transmitter> transmitters){
        double areaABR,areaACR,areaBCR,sum;
        Punkt2D pointA = new Punkt2D(transmitters.get(0).getX(), transmitters.get(0).getY());
        Punkt2D pointB = new Punkt2D(transmitters.get(0).getX(), transmitters.get(0).getY());
        Punkt2D pointC = new Punkt2D(transmitters.get(0).getX(), transmitters.get(0).getY());
        Punkt2D pointR = new Punkt2D(robot.getX(),robot.getY());

        areaABR=charon(pointA,pointB,pointR);

        areaACR=charon(pointA,pointC,pointR);

        areaBCR=charon(pointB,pointC,pointR);

        sum = charon(pointA, pointB, pointC);



        if (Math.abs(sum - areaABR+areaACR+areaBCR) < 1) {
            return true;
        } else {
            return false;
        }
    }*/

    public static int randInt(int bound) {
        return (new Random()).nextInt(bound + 1);
    }


    public Simulate() {
        transmitters.add(new Transmitter(randInt(width), randInt(height), randInt(500), randInt(500)));
        transmitters.add(new Transmitter(randInt(width), randInt(height), randInt(500), randInt(500)));
        transmitters.add(new Transmitter(randInt(width), randInt(height), randInt(500), randInt(500)));
        robot = new Robot(randInt(width), randInt(height));
    }


    public static void main(String[] args) {
        /*final String title = "Testttt Window";
        final int width = 500;
        final int height = 500;

        //Creating the frame.
        JFrame frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        //Creating the canvas.
        Canvas canvas = new Canvas();

        canvas.setSize(width, height);
        canvas.setBackground(Color.BLACK);
        canvas.setVisible(true);
        canvas.setFocusable(false);


        //Putting it all together.
        frame.add(canvas);

        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;

        while (running) {
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, width, height);

            graphics.setColor(Color.GREEN);
            graphics.drawLine(simulate.transmitterA.getX(),simulate.transmitterA.getY(),simulate.transmitterB.getX(),simulate.transmitterB.getY());
            graphics.drawLine(simulate.transmitterA.getX(),simulate.transmitterA.getY(),simulate.transmitterC.getX(),simulate.transmitterC.getY());
            graphics.drawLine(simulate.transmitterC.getX(),simulate.transmitterC.getY(),simulate.transmitterB.getX(),simulate.transmitterB.getY());

            graphics.setColor(Color.WHITE);
            graphics.drawRect(simulate.robot.getX() - 1, simulate.robot.getY() - 1, 3, 3);

            bufferStrategy.show();
            graphics.dispose();
        }
    */
    }
}
