package chapter_4.ex_04_10;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class SampleController {

    @FXML
    private Button back;
    @FXML
    private TextField url;
    @FXML
    private WebView webView;

    @FXML
    private void  handleKey(KeyEvent e)  {
        if(e.getCode() == KeyCode.ENTER) {
            WebEngine engine = webView.getEngine();
            engine.load(url.getText());
        }
    }

    @FXML
    private void  backButton(MouseEvent e)  {
        WebEngine engine = webView.getEngine();
        WebHistory history = engine.getHistory();

        int index = history.getCurrentIndex() - 1;
        if(index < 0) index = 0;
        Entry entry = history.getEntries().get(index);
        engine.load(entry.getUrl());
        history.go(-1);
    }


}
