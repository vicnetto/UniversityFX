package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Main {
    public Login () {
    }

    public void signUp (Stage primaryStage) {
        //SETTING THE GRID ---------------
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25 ,25));
        //--------------------------------

        //PROFESSION ---------------------
        Label whatAreYou = new Label("• What is your function?");
        grid.add(whatAreYou, 0, 2);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Student");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Teacher");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Public Employee");
        rb3.setToggleGroup(group);

        grid.add(rb1, 0, 4);
        grid.add(rb2, 0, 5);
        grid.add(rb3, 0, 6);
        //--------------------------------

        //SETTING THE SCENE --------------
        Scene second = new Scene(grid, getLength(), getWidth());
        primaryStage.setScene(second);
        //--------------------------------
    }

}
