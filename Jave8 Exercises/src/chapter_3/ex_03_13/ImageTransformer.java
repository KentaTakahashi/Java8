package chapter_3.ex_03_13;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ImageTransformer {
    Image apply(Image img);

    static ImageTransformer compose(ImageTransformer op1, ImageTransformer op2) {
        return img -> op2.apply(op1.apply(img));
    }

    static ImageTransformer convert(UnaryOperator<Color> op) {
        return (in) -> {
            int width = (int)in.getWidth();
            int height = (int)in.getHeight();
            WritableImage out = new WritableImage(width, height);
            for(int x = 0; x < width; x++)
                for(int y = 0; y < height; y++) {
                    Color c = op.apply(in.getPixelReader().getColor(x, y));
                    out.getPixelWriter().setColor(x, y, c);
                }
            return out;
        };
    }
}
