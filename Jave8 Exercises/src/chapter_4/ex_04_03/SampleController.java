package chapter_4.ex_04_03;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class SampleController {

    @FXML
    private Label textLabel;
    @FXML
    private DelayTextField delayTextField;

    @FXML
    private void  handleKey(KeyEvent event)  {
        textLabel.setText(delayTextField.getText());
    }
}
