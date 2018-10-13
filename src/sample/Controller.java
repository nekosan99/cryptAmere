package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.w3c.dom.events.Event;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    @FXML
    private TextField cle;

    @FXML
    private Button getFile;

    @FXML
    private Button getPicture;

    @FXML
    private Button getDirectory;

    @FXML
    private Button go;

    public void getFilePath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //actionStatus.setText("File selected: " + selectedFile.getName());
            System.out.println("Button file clicked");
        }
        else {
            //actionStatus.setText("File selection cancelled.");
            System.out.println("Button file cancel clicked too");
        }

    }

    public void getPicturePath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //actionStatus.setText("File selected: " + selectedFile.getName());
            System.out.println("Button picture clicked");
        }
        else {
            //actionStatus.setText("File selection cancelled.");
            System.out.println("Button picture cancel clicked to9o");
        }

    }

    public void outPutDirectory(ActionEvent actionEvent){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if(selectedDirectory == null){
            //No Directory selected
        }else{
            System.out.println(selectedDirectory.getAbsolutePath());
        }
    }

    public void getGo(ActionEvent actionEvent) {

        System.out.println("Button picture clicked");
        }

    }
