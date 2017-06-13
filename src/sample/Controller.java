package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller {
    public Button signInButton;
    public Button signUpButton;
    public TextField usernameTextField;
    public PasswordField passwordField;

    @FXML
    public void signInButtonHandler() throws IOException {

        if (!(usernameTextField.getText().equals("") && passwordField.getText().equals(""))){
            Client.objectOutputStream.writeObject(usernameTextField.getText());
            Client.objectOutputStream.flush();
            Client.objectOutputStream.writeObject(passwordField.getText());
        }


    }
    @FXML
    public void signUpButtonHandler(){
        signUpButton.setText("clicked");
    }




}

