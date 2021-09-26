package View.FirmGUI.ProfileGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProfileGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField profileName;

    @FXML
    private TextField address;

    @FXML
    private TextField mail;

    @FXML
    private TextField phone;

    @FXML
    private TextField pass;

    @FXML
    private Text about;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        assert profileName != null : "fx:id=\"profileName\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert about != null : "fx:id=\"about\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'ProfileGUI.fxml'.";

    }
}
