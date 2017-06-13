package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;


public class Client extends Application {
    OutputStream output;
    InputStream input;
    ObjectInputStream objectInputStream;
    static ObjectOutputStream objectOutputStream;


    public void connect(Socket socket) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //Connecting
        boolean scanning = true;

        while (scanning) {
            try {
                socket = new Socket("localhost", 2222);
                scanning = false;
            } catch (ConnectException e) {
                alert.setTitle("Error!");
                alert.setHeaderText("Can't Connect To The Server...");
                alert.setContentText("Check Your Connection");
                alert.showAndWait();
                try {
                    Thread.sleep(2000);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
//connecting
    }







    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
//        primaryStage.getIcons().add(new Image("icon.jpg"));
        primaryStage.setTitle("Instagram");
        primaryStage.setScene(new Scene(root, 700, 650));
        primaryStage.show();

        Socket socket = null;
        connect(socket);
        output = socket.getOutputStream();
        input = socket.getInputStream();
        objectOutputStream = new ObjectOutputStream(output);
        objectInputStream = new ObjectInputStream(input);



    }


    public static void main(String[] args) {
        launch(args);

    }
}
