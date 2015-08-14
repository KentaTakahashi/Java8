package chapter_4.ex_04_04;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class SampleController {

    @FXML
    private AnchorPane panel;
    @FXML
    private Circle circle;

    @FXML
    private void  handleKey()  {
        circle.setRadius(Math.min(panel.getWidth(), panel.getHeight()) * 0.5);
    }



}
