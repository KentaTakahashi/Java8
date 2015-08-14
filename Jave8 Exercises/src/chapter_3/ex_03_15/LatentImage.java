package chapter_3.ex_03_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
    private Color[][] in;
    private List<ColorTransformer> pendingOperations;
    public static LatentImage from(Image img) {
        LatentImage li = new LatentImage();
        int width = (int) img.getWidth();
        int height = (int) img.getHeight();
        Color[][] in = new Color[height][width];
        PixelReader reader = img.getPixelReader();
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                in[y][x] = reader.getColor(x, y);
        li.in = in;
        li.pendingOperations = new ArrayList<ColorTransformer>();
        return li;
    }

    public LatentImage transform(ColorTransformer ct) {
        pendingOperations.add(ct);
        return this;
    }

    public LatentImage transform(UnaryOperator<Color> uo) {
        pendingOperations.add(ColorTransformer.convert(uo));
        return this;
    }

    public Image toImage() {
        int n = Runtime.getRuntime().availableProcessors();
        int width = in[0].length;
        int height = in.length;
        Color[][] out = in.clone();
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1) * height / n;
                pool.submit(() -> {
                    for(ColorTransformer ct : pendingOperations)
                        for(int x = 0; x <width; x++)
                            for(int y = fromY; y < toY; y++)
                                out[y][x] = ct.apply(x, y, out[y][x]);
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        WritableImage img = new WritableImage(width, height);
        PixelWriter writer = img.getPixelWriter();
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                 writer.setColor(x, y, out[y][x]);

        return img;
    }
}
