

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VigenereCipherApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VigenereCipherUI.fxml"));
        primaryStage.setTitle("Vigenère Cipher");
        primaryStage.setScene(new Scene(root, 600, 400)); // Adjust size as needed
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
