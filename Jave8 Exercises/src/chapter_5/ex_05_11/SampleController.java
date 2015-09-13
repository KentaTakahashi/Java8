package chapter_5.ex_05_11;

import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SampleController implements Initializable{

    @FXML
    private AnchorPane panel;

    @FXML
    private ComboBox<String> timezone1;
    @FXML
    private ComboBox<Integer> year1;
    @FXML
    private ComboBox<Integer> month1;
    @FXML
    private ComboBox<Integer> day1;
    @FXML
    private ComboBox<Integer> hour1;
    @FXML
    private ComboBox<Integer> minute1;

    @FXML
    private ComboBox<String> timezone2;
    @FXML
    private ComboBox<Integer> year2;
    @FXML
    private ComboBox<Integer> month2;
    @FXML
    private ComboBox<Integer> day2;
    @FXML
    private ComboBox<Integer> hour2;
    @FXML
    private ComboBox<Integer> minute2;

    @FXML
    private Label result;
    @FXML
    private Button calcBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timezone1.getItems().addAll(
                "Japan",
                "Etc/GMT+2",
                "America/Los_Angeles");
        year1.getItems().addAll(2015, 2016);
        month1.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        day1.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
        hour1.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        minute1.getItems().addAll(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

        timezone2.getItems().addAll(
                "Japan",
                "Etc/GMT+2",
                "America/Los_Angeles");
        year2.getItems().addAll(2015, 2016);
        month2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        day2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
        hour2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        minute2.getItems().addAll(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        //出発時刻取得
        ZonedDateTime leaveTime = ZonedDateTime.of(
                year1.getValue(),
                month1.getValue(),
                day1.getValue(),
                hour1.getValue(),
                minute1.getValue(),
                0,
                0,
                ZoneId.of(timezone1.getValue())
                );
        //到着時刻取得
        ZonedDateTime arriveTime = ZonedDateTime.of(
                year2.getValue(),
                month2.getValue(),
                day2.getValue(),
                hour2.getValue(),
                minute2.getValue(),
                0,
                0,
                ZoneId.of(timezone2.getValue())
                );

        //フライト時間計算
        long hour = leaveTime.until(arriveTime, ChronoUnit.HOURS);
        long minute = leaveTime.until(arriveTime, ChronoUnit.MINUTES) % 60;

        result.setText(hour + "時間" + minute +"分");
    }
}
