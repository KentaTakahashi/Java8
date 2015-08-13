package chapter_3.ex_03_13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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

        LatentImage lt = LatentImage.from(orign).transform(Color::brighter);
        Image img = lt.transform(
                (Image in) -> {
                    int width = (int)in.getWidth();
                    int height = (int)in.getHeight();
                    WritableImage out = new WritableImage(width, height);
                    for(int x = 0; x < width; x++)
                        for(int y = 0; y < height; y++) {
                            double redSum = 0.0;
                            double greenSum = 0.0;
                            double blueSum = 0.0;
                            for(int x0 = x - 3; x0 <= x + 3; x0++)
                                for(int y0 = y - 3; y0 <= y + 3; y0++) {
                                    int x1 = x0; //淵付近の例外処理用
                                    int y1 = y0; //淵付近の例外処理用
                                    if(x1 < 0) x1 = 0;
                                    if(x1 >= width) x1 = width -1;
                                    if(y1 < 0) y1 = 0;
                                    if(y1 >= height) y1 = height -1;

                                    Color c = in.getPixelReader().getColor(x1, y1);
                                    redSum   += c.getRed();
                                    greenSum += c.getGreen();
                                    blueSum  += c.getBlue();
                                }
                            Color c = Color.color(redSum /49.0, greenSum /49.0, blueSum /49.0);
                            out.getPixelWriter().setColor(x, y, c);
                        }
                    return out;

                }).toImage();
        /*
        Image img = LatentImage.from(orign)
                .transform(Color::darker)
                .transform(
                        (x, y, colorAtXY) -> {
                            int width = (int)orign.getWidth();
                            int heigh = (int)orign.getHeight();
                            double redSum = 0.0;
                            double greenSum = 0.0;
                            double blueSum = 0.0;
                            for(int x0 = x - 3; x0 <= x + 3; x0++)
                                for(int y0 = y - 3; y0 <= y + 3; y0++) {
                                    int x1 = x0; //淵付近の例外処理用
                                    int y1 = y0; //淵付近の例外処理用
                                    if(x1 < 0) x1 = 0;
                                    if(x1 >= width) x1 = width -1;
                                    if(y1 < 0) y1 = 0;
                                    if(y1 >= heigh) y1 = heigh -1;

                                    Color c = orign.getPixelReader().getColor(x1, y1);
                                    redSum   += c.getRed();
                                    greenSum += c.getGreen();
                                    blueSum  += c.getBlue();
                                }
                            return Color.color(redSum /49.0, greenSum /49.0, blueSum /49.0);
                        })
                .toImage();
*/
        transImg.setImage(img);
        transformBtn.setText("done!");
    }

}
