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
    private Button getText;

    @FXML
    private Button getPicture;

    @FXML
    private Button getDirectory;

    @FXML
    private Button go;

    private String enterPass = null;
    private String outPutpass = null;
    private String imageFile = null;
    private String textFile = null;




    ////partie gauche

    public void getTextPath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            textFile = selectedFile.getName();
            System.out.println(textFile);
        }
        else {
            //actionStatus.setText("File selection cancelled.");
            System.out.println("no path selected");
        }

    }

    public void getPicturePath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            imageFile = selectedFile.getName();
            System.out.println(imageFile);
        }
        else {
            //actionStatus.setText("File selection cancelled.");
            System.out.println("Button picture cancel clicked too");
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

    ////partie droite

    public void givePicture(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            //actionStatus.setText("File selected: " + selectedFile.getName());
            System.out.println("Button picture clicked");
        }
        else {
            //actionStatus.setText("File selection cancelled.");
            System.out.println("Button picture cancel clicked too");
        }
    }

    public void givedirectory(ActionEvent actionEvent){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if(selectedDirectory == null){
            //No Directory selected
        }else{
            System.out.println(selectedDirectory.getAbsolutePath());
        }
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }
    ///////action go

    public void getGo(ActionEvent actionEvent) {

        if (textFile != null) {

            if (imageFile != null) {
                System.out.println("tout est ok");
            }else{
                System.out.println("Pas d'image selectioné");
            }

        } else {
            System.out.println("Pas de fichier texte selectionéd");
        }

    }

    }
