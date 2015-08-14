package chapter_3.ex_03_15;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer convert(UnaryOperator<Color> op) {
        return (x, y, color) -> op.apply(color);
    }
}
