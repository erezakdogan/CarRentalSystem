package View.SignUpGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane signupAnchor;

    @FXML
    private Button signupGoogle;

    @FXML
    private TextField signupName;

    @FXML
    private TextField signupMail;

    @FXML
    private TextField signupPass;

    @FXML
    private Button signupButton;

    @FXML
    private CheckBox signupTerms;

    @FXML
    void initialize() {
        assert signupAnchor != null : "fx:id=\"signupAnchor\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupGoogle != null : "fx:id=\"signupGoogle\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupName != null : "fx:id=\"signupName\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupMail != null : "fx:id=\"signupMail\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupPass != null : "fx:id=\"signupPass\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupTerms != null : "fx:id=\"signupTerms\" was not injected: check your FXML file 'SignUpGUI.fxml'.";

    }
}

