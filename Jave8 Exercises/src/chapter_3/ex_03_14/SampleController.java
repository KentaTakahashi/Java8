package chapter_3.ex_03_14;

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
                .transform(Color::darker)
                .transform((x, y, reader) -> reader.getColor((int)orign.getWidth() - (x + 1), y))
                .toImage();
        transImg.setImage(img);
        transformBtn.setText("done!");
    }

}
