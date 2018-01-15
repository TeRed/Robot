package com.robot.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import com.robot.model.Simulate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private TextField robotX;
    @FXML
    private TextField robotY;
    @FXML
    private TextField mapSizeX;
    @FXML
    private TextField mapSizeY;

    @FXML
    private TextField transmitter1X;
    @FXML
    private TextField transmitter1Y;
    @FXML
    private TextField transmitter2X;
    @FXML
    private TextField transmitter2Y;
    @FXML
    private TextField transmitter3X;
    @FXML
    private TextField transmitter3Y;

    private GraphicsContext gc;

    @FXML
    public void reset(ActionEvent actionEvent) {
        mapSizeX.clear();
        mapSizeY.clear();

        robotX.clear();
        robotY.clear();

        transmitter1X.clear();
        transmitter1Y.clear();

        transmitter2X.clear();
        transmitter2Y.clear();

        transmitter3X.clear();
        transmitter3Y.clear();
    }

    @FXML
    public void simulate(ActionEvent actionEvent) {

        //Reading user input
        List<String> arguments = new ArrayList<>(10);
        arguments.add(mapSizeX.getText());
        arguments.add(mapSizeY.getText());
        arguments.add(robotX.getText());
        arguments.add(robotY.getText());
        arguments.add(transmitter1X.getText());
        arguments.add(transmitter1Y.getText());
        arguments.add(transmitter2X.getText());
        arguments.add(transmitter2Y.getText());
        arguments.add(transmitter3X.getText());
        arguments.add(transmitter3Y.getText());

        //Receiving data after simulation
        List<Integer> retval = Simulate.simulate(arguments);

        //Canvas/map refreshing
        mapSizeX.setText(retval.get(0).toString());
        mapSizeY.setText(retval.get(1).toString());
        canvas.setWidth(retval.get(0));
        canvas.setHeight(retval.get(1));

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.DARKORANGE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        //Transmitters refreshing
        gc.setFill(Color.BROWN);

        transmitter1X.setText(retval.get(4).toString());
        transmitter1Y.setText(retval.get(5).toString());
        gc.fillOval(retval.get(4)-1, retval.get(5)-1, 3, 3);

        transmitter2X.setText(retval.get(6).toString());
        transmitter2Y.setText(retval.get(7).toString());
        gc.fillOval(retval.get(6)-1, retval.get(7)-1, 3, 3);

        transmitter3X.setText(retval.get(8).toString());
        transmitter3Y.setText(retval.get(9).toString());
        gc.fillOval(retval.get(8)-1, retval.get(9)-1, 3, 3);

        gc.beginPath();
        gc.moveTo(retval.get(4), retval.get(5));
        gc.lineTo(retval.get(6), retval.get(7));
        gc.lineTo(retval.get(8), retval.get(9));
        gc.lineTo(retval.get(4), retval.get(5));
        gc.stroke();

        //Robot start and end position refreshing
        robotX.setText(retval.get(2).toString());
        robotY.setText(retval.get(3).toString());

        gc.setFill(Color.WHITE);
        gc.fillOval(retval.get(2)-1, retval.get(3)-1, 3, 3);
        gc.strokeText(retval.get(2) + ", " + retval.get(3), retval.get(2) + 5, retval.get(3) - 5);

        gc.setFill(Color.GREEN);
        gc.fillOval(retval.get(10)-1, retval.get(11)-1, 3, 3);
        gc.strokeText(retval.get(10) + ", " + retval.get(11), retval.get(10) + 5, retval.get(11) - 5);
    }
}
