package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My calculator");
        primaryStage.getIcons().add(new Image("sample/myCalc.png"));

        primaryStage.setResizable(false);
        root.styleProperty().setValue(" -fx-background-color: darkgrey;  -fx-border-color: white; -fx-border-width: 3px;"); // CSS локально

        primaryStage.setScene(new Scene(root, 480, 315));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}