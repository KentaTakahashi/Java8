package chapter_3.ex_03_06;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {

    @FXML
    private Slider brightSlider;
    @FXML
    private ImageView orginImg;
    @FXML
    private ImageView transImg;

    @FXML
    private void handleSliderAction() {
        Image orign = orginImg.getImage();
        Image img = TransformImage.transform(
                orign,
                (c, factor) -> c.deriveColor(0, 1, factor, 1),//factor分だけcを明るくする
                brightSlider.getValue());

        transImg.setImage(img);
    }
}
