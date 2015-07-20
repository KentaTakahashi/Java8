package chapter_3.ex_03_08;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SampleController {

    @FXML
    private ColorPicker FrameColor;
    @FXML
    private TextField FrameSize;
    @FXML
    private Button addFrameBtn;
    @FXML
    private ImageView orginImg;
    @FXML
    private ImageView transImg;


    @FXML
    private void handleButtonAction(ActionEvent event) {

        Color framColor = FrameColor.getValue();
        int framSize;
        try {
            framSize = Integer.parseInt(FrameSize.getText());
        } catch (NumberFormatException nfex) {
            framSize = 0;
        }

        Image img = addFrame(orginImg.getImage(), framSize, framColor);

        transImg.setImage(img);
    }

    private static Image addFrame(Image in, int framSize, Color framColor) {
        return TransformImage.transform(in, (x, y, colorAtXY) -> {
            if(x <=framSize || in.getWidth() - framSize <= x ||
               y <=framSize || in.getHeight() - framSize <= y)
                return framColor;
            else
                return colorAtXY;
        });
    }
}
