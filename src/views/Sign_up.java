/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import databaseControl.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author lojen youssef
 */
public class Sign_up extends Login {
        Stage s2;

    @Override
    public void start(Stage stage) {
        // هنا قمنا بإنشاء جميع الأشياء التي سنضيفها في النافذة
        Label password_label = new Label("Password");
        Label username_label = new Label("User Name");
        TextField username = new TextField();
        PasswordField passwordField = new PasswordField();
        Button save = new Button("save");
        username.setFocusTraversable(false);
        // هنا قمنا بتحديد مكان ظهور الأشياء التي سنضيفها في النافذة
  
        username_label.setTranslateX(100);
        username_label.setTranslateY(200);
        username.setTranslateX(300);
        username.setTranslateY(200);
        password_label.setTranslateX(100);
        password_label.setTranslateY(250);
        passwordField.setTranslateX(300);
        passwordField.setTranslateY(250);
     
        save.setTranslateX(250);
        save.setTranslateY(400);
        save.setPrefWidth(200);
        
        username_label.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 25));
        password_label.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 25));
        passwordField.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.ITALIC, 15));
        username.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.ITALIC, 15));
        username.setAlignment(Pos.CENTER);
        password_label.setTextFill(Color.AZURE);
        username_label.setTextFill(Color.AZURE);

 save.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
        save.setAlignment(Pos.CENTER);
                save.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(5), Insets.EMPTY)));

        save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        save.setEffect(shadow);
        });
        save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            save.setEffect(null);
        });
        //   button_1.setOnAction(this);
        save.setPrefSize(150, 50);
        save.setTextFill(Color.AZURE);
       
        // في النافذة Root Node لأننا ننوي جعله الـ Group هنا قمنا بإنشاء كائن من الكلاس
        GridPane root = new GridPane();
        root.setBackground(new Background(new BackgroundFill(Color.NAVY/*INDIGO*//*CORNFLOWERBLUE*/, new CornerRadii(5), Insets.EMPTY)));

        // root هنا قمنا بإضافة جميع الأشياء في الكائن
        root.getChildren().add(username_label);
        root.getChildren().add(username);
        root.getChildren().add(password_label);
        root.getChildren().add(passwordField);
        root.getChildren().add(save);
        
        // فيها و تحديد حجمها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root, 700, 700);

        // هنا وضعنا عنوان للنافذة
        stage.setTitle("Create a new account");

        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في كائن الـ scene هنا وضعنا كائن الـ
        stage.setScene(scene);

        // هنا قمنا بإظهار النافذة
        stage.show();
        s2 = stage;

        // passwordField هنا قمنا بتحديد ماذا سيحدث كلما تم إدخال أو مسح حرف في الـ
        save.setOnAction((ActionEvent Action) -> {
            
            if (passwordField.getText().length() < 8) {
                System.out.println("passwordField.getText().length() " + passwordField.getText().length());

                alert.setTitle("password is very short");
                alert.setHeaderText("error");
                alert.setContentText("Your password is very short\n please enter new password");
                alert.showAndWait().ifPresent((ButtonType response) -> {

                });
            }
            String text = username.getText();
            if (text.length() < 8) {
                System.out.println("status_username.getText().length() " + text.length());
                alert.setTitle("text is very short");
                alert.setHeaderText("error");
                alert.setContentText("USERNAME is very short\n please enter new User name");
                alert.showAndWait().ifPresent((ButtonType response) -> {
                    if (response == ButtonType.OK) {
                        username.getText();
                    }

                });
            } else {
                String uname = passwordField.getText();
                String pass = username.getText();
//                if (DatabaseHandler.CheckLoginUser(uname, pass)) { // sending data to databasehandler class to connection data
////
//                  
//
//s2.close();
//                    Menu m = new Menu();
//                    m.start(new Stage());
////                } else {
////                
//                }
//                else{
//                    alert.setTitle("Error");
//                    alert.setContentText("Error in login system");
//                    alert.show();
////            reseting user and pass field
//                    username.setText("");
//                    passwordField.setText("");
//                }
                s2.close();
                Menu m = new Menu();
                m.start(new Stage());
            }

        });

    }
}
