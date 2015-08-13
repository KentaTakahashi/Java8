package chapter_3.ex_03_14;

import java.util.function.UnaryOperator;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, PixelReader reader);

    static ColorTransformer convert(UnaryOperator<Color> op) {
        return (x, y, reader) -> op.apply(reader.getColor(x, y));
    }
}
