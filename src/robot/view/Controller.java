package robot.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
    public void simulate(ActionEvent actionEvent) {
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



        //        canvas.setHeight(500);
//        canvas.setWidth(500);
//        gc = canvas.getGraphicsContext2D();
//
//        gc.setFill(Color.PURPLE);
//        gc.fillRect(0,0,500,500);
//
//        gc.setFill(Color.RED);
//        gc.fillOval(40, 50, 10, 10);
//        gc.fillOval(79, 80, 10, 10);
//        gc.setFill(Color.BLUE);
//        gc.fillOval(225, 226, 10, 10);
//        gc.fillOval(41, 303, 10, 10);
//        gc.setFill(Color.GREEN);
    }
}
