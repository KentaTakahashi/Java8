package chapter_4.ex_04_01;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController {

    @FXML
    private Label textLabel;
    @FXML
    private TextField textField;

    @FXML
    private void  handleKey(KeyEvent event)  {
        textLabel.setText(textField.getText());
    }
}
