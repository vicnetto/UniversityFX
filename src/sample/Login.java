package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Login extends Main {
    public Login () {
    }

    public void signUp (Stage primaryStage) {
        //SETTING THE GRID ---------------
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25 ,25));
        //--------------------------------

        //PROFESSION ---------------------
        Label whatAreYou = new Label("• What is your function?");
        grid.add(whatAreYou, 0, 5, 10, 1);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Student");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Teacher");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Public Employee");
        rb3.setToggleGroup(group);

        grid.add(rb1, 0, 6, 10, 1);
        grid.add(rb2, 0, 7, 10, 1);
        grid.add(rb3, 0, 8, 10, 1);
        //--------------------------------

        //GETTING USER INPUT -------------
        Label personalData = new Label("• Getting personal data:");
        grid.add(personalData, 10, 5);

        TextField userRealName = new TextField();
        userRealName.setPromptText("Insert your name");
        grid.add(userRealName, 10, 6);

        TextField user = new TextField();
        user.setPromptText("Insert your username");
        grid.add(user, 10, 7);

        PasswordField password = new PasswordField();
        password.setPromptText("Insert your password");
        grid.add(password, 10, 8);
        //--------------------------------

        //UNIVERSITY IMAGE ---------------
        try{
            Image utfpr = new Image(new FileInputStream(new File("resources/images/utfpr.png")), 200, 200, true, true);
            ImageView utfprNew = new ImageView(utfpr);
            grid.add(utfprNew, 7, 0, 3, 3);
        } catch (FileNotFoundException file) {
            System.out.println("This image file does not exist - Login.Java");
        }

        //--------------------------------
        //MAKE ACCOUNT BUTTON ------------
        Button makeAccount = new Button("Make Account");
        GridPane.setHalignment(makeAccount, HPos.RIGHT);
        grid.add(makeAccount, 10, 11);
        //--------------------------------

        //SETTING THE SCENE --------------
        Scene second = new Scene(grid, getLength(), getWidth());
        primaryStage.setScene(second);
        //--------------------------------
    }

}
