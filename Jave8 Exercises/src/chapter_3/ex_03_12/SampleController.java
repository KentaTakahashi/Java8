package chapter_3.ex_03_12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SampleController {

    @FXML
    private Button transformBtn;
    @FXML
    private ImageView orginImg;
    @FXML
    private ImageView transImg;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Image orign = orginImg.getImage();

        Image img = LatentImage.from(orign)
                .transform(Color::brighter)
                .transform(
                        (x, y, colorAtXY) -> {
                            if(x <=10 || orign.getWidth() - 10 <= x ||
                               y <=10 || orign.getHeight() - 10 <= y)
                                return Color.GRAY;
                            else
                                return colorAtXY;
                        })
                .toImage();
        transImg.setImage(img);
        transformBtn.setText("done!");
    }

}
