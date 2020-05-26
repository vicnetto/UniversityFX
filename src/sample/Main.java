package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {

    final int length = 500;
    final int width = 375;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //GRIDPANE -----------------------
        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        //--------------------------------

        //TITLE --------------------------
        Text sceneTitle = new Text("Welcome!");
        Font font = new Font("Arial", 20);
        try {
            sceneTitle.setFont(Font.loadFont(new FileInputStream(new File("resources/fonts/Raleway-Black.ttf")), 30));
        } catch (IOException a) {
            System.out.println("Error trying to load the font!");
        }
        sceneTitle.setUnderline(true);
        root.add(sceneTitle, 2, 0, 1, 3);
        //--------------------------------

        //USERNAME FIELD -----------------
        Label userName = new Label("Username:");
        root.add(userName, 1, 4);

        TextField userInsert = new TextField();
        userInsert.setPromptText("User");
        root.add(userInsert, 2, 4);
        //--------------------------------

        //PASSWORD FIELD -----------------
        Label password = new Label("Password:");
        root.add(password, 1, 6);

        PasswordField passwordInsert = new PasswordField();
        passwordInsert.setPromptText("Password");
        root.add(passwordInsert, 2, 6);
        //--------------------------------

        //BUTTONS ------------------------
        Image image = new Image(new FileInputStream(new File("resources/images/ok1.png")), 30, 30, true, true);
        Button btn = new Button("Sign in", new ImageView(image));
        root.add(btn, 3, 8);

        Button btn1 = new Button("Sign up");
        root.add(btn1, 2, 8);

        Label bt1Label = new Label("Not an user?");
        root.add(bt1Label, 1, 8);

        final Text actionTarget = new Text();
        root.add(actionTarget, 2, 9);
        //--------------------------------

        //HANDLING BUTTONLOGIN -----------
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (userInsert.getText().matches("victor") && passwordInsert.getText().matches("salve")) {
                    actionTarget.setFill(Color.BLUEVIOLET); //If you want, you can put an login message.
                    actionTarget.setText("You are logged in");
                } else {
                    actionTarget.setFill(Color.RED); //If you want, you can put an login message.
                    actionTarget.setText("Wrong user or password!");
                }
            }
        });
        //--------------------------------

        //HANDLING BUTTONREGISTER --------
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();
                login.signUp(primaryStage);
            }
        });
        //--------------------------------

        //SHOWING THE FIRST SCENE --------
        primaryStage.setTitle("Register"); // Naming Register for the window.
        primaryStage.setScene(new Scene(root, length, width)); //Setting the first scene to the "studio".
        primaryStage.show(); //Showing the first scene.
        //--------------------------------
    }

    public static void main(String[] args) {
        launch(args);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
