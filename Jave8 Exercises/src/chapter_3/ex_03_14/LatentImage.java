package chapter_3.ex_03_14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage li = new LatentImage();
        li.in  = in;
        li.pendingOperations = new ArrayList<ColorTransformer>();
        return li;
    }
    public LatentImage transform(ColorTransformer ct) {
        pendingOperations.add(ct);
        return this;
    }

    public LatentImage transform(UnaryOperator<Color> up) {
        pendingOperations.add(ColorTransformer.convert(up));
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();

        PixelReader chash = in.getPixelReader();
        WritableImage out = new WritableImage(in.getPixelReader(), width, height);

        for(ColorTransformer ct : pendingOperations) {
            PixelWriter writer = out.getPixelWriter();
            for(int x = 0; x < width; x++)
                for(int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                    c = ct.apply(x, y, chash);
                    writer.setColor(x, y, c);
            }
            chash = out.getPixelReader(); //update
        }
        return out;
    }
}
