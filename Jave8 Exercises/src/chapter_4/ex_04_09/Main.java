package chapter_4.ex_04_09;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    static final double a = 300.0;
    static final double b = 200.0;
    static final double r = 20.0;

    @Override
    public void start(Stage primaryStage) {
        try {
            final Group group = new Group();
            final Scene scene = new Scene(group, 640, 440, Color.GHOSTWHITE);
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX Animations");
            primaryStage.show();

            final Circle circle = new Circle(2 * a  + r, b  + r, r);
            circle.setFill(Color.NAVY);

            final Path path = new Path();
            path.getElements().add(new MoveTo(2 * a  + r, b  + r));
            for(int t = 0; t < 3600; t++)
                path.getElements().add(new LineTo (
                        a * Math.cos(Math.toRadians(t)) + a + r,
                        b * Math.sin(Math.toRadians(t)) + b + r
                        ));

            path.setOpacity(1.0);

            group.getChildren().add(circle);
            final PathTransition pathTransition = new PathTransition();

            pathTransition.setDuration(Duration.seconds(10.0));
            pathTransition.setDelay(Duration.seconds(0.5));
            pathTransition.setPath(path);
            pathTransition.setNode(circle);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
            pathTransition.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
