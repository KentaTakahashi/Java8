package chapter_3.ex_03_08;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class TransformImage {
    public static Image transform(Image in, BiFunction<Integer, Color, Color> f, int framSize) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);

        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y, f.apply(framSize, in.getPixelReader().getColor(x, y)));

        return out;
    }
    public static Image transform(Image in, ColorTransformer ct) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);

        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y, ct.apply(x, y, in.getPixelReader().getColor(x, y)));

        return out;
    }
}
