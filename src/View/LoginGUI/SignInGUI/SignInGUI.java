package View.LoginGUI.SignInGUI;

import java.net.URL;
import java.util.ResourceBundle;

import org.postgresql.util.LruCache.CreateAction;

import View.SignUpGUI.SignUpGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignInGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane signinAnchor;

    @FXML
    private Button signinGoogle;

    @FXML
    private TextField signinMail;

    @FXML
    private TextField signinPass;

    @FXML
    private CheckBox signinRem;

    @FXML
    private Label signinForg;

    @FXML
    private Label signinCreate;

    @FXML
    private Button signinButton;

    @FXML
    void initialize() {
        assert signinAnchor != null : "fx:id=\"signinAnchor\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinGoogle != null : "fx:id=\"signinGoogle\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinMail != null : "fx:id=\"signinMail\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinPass != null : "fx:id=\"signinPass\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinRem != null : "fx:id=\"signinRem\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinForg != null : "fx:id=\"signinForg\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinCreate != null : "fx:id=\"signinCreate\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        assert signinButton != null : "fx:id=\"signinButton\" was not injected: check your FXML file 'SignInGUI.fxml'.";
        initButtons();
    }

    private void initButtons() {
        signinCreate.setOnMouseClicked(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(SignUpGUI.class.getResource("SignUpGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                signinAnchor.getChildren().removeAll();
                signinAnchor.getChildren().add(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

}
