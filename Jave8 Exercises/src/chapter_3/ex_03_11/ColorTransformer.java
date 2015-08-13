package chapter_3.ex_03_11;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer compose(ColorTransformer op1, ColorTransformer op2) {
        return (x, y, colorAtXY) -> op2.apply(x, y, op1.apply(x, y, colorAtXY));
    }

    static ColorTransformer convert(UnaryOperator<Color> op) {
        return (x, y, color) -> op.apply(color);
    }
}
