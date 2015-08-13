package chapter_3.ex_03_13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
    private Image in;
    private List<ImageTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage li = new LatentImage();
        li.in  = in;
        li.pendingOperations = new ArrayList<ImageTransformer>();
        return li;
    }
    public LatentImage transform(ImageTransformer it) {
        pendingOperations.add(it);
        return this;
    }

    public LatentImage transform(UnaryOperator<Color> up) {
        pendingOperations.add(ImageTransformer.convert(up));
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        Image out = in;
        Image prev = new WritableImage(in.getPixelReader(), width, height);
        for(ImageTransformer it : pendingOperations) {
            out = it.apply(prev);
            prev = new WritableImage(out.getPixelReader(), width, height);
        }
        return out;
    }
}
