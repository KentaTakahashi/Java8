package chapter_4.ex_04_04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class SampleController implements Initializable{

    @FXML
    private AnchorPane panel;
    @FXML
    private Circle circle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        circle.centerXProperty().bind(Bindings.divide(panel.widthProperty(), 2.0));
        circle.centerYProperty().bind(Bindings.divide(panel.heightProperty(), 2.0));
        circle.radiusProperty().bind(Bindings.divide(Bindings.min(panel.widthProperty(), panel.heightProperty()), 2.0));
    }
}
