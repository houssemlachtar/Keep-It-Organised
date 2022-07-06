package stages;

import core.Session;
import core.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class MainStage {
    public MainStage(Stage primaryStage) throws IOException {
        // Loads the required scene
        Parent root;
        User loggedInUser = User.findLoggedInUser();

        // If logged in user exists, loads their data into session and forwards to profile view
        if(loggedInUser!=null) {
            Session.beginSession(loggedInUser);
            root = FXMLLoader.load(getClass().getResource("/ProfileView.fxml"));
        }
        // Otherwise, forwards to login page
        else
            root = FXMLLoader.load(getClass().getResource("/LoginPageView.fxml"));

        // Sets window (stage) to default size
        primaryStage.setScene(new Scene(root, 1400, 900));

        // Sets application window name
        primaryStage.setTitle("Organised.");

        // Makes scene non resizable and removes toolbar
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Adds the application logo
        Image newImage = new Image(MainStage.class.getResourceAsStream("/icon.png"));
        primaryStage.getIcons().add(newImage);

        // Focuses away from the fields for prompt text to be visible
        root.requestFocus();

        // Saves primaryStage in Session, so it can be used for dragging
        Session.setMainStage(primaryStage);

        // Shows the window
        primaryStage.show();
    }
}
