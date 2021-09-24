package View.LoginGUI;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import View.LoginGUI.SignInGUI.SignInGUI;
import View.SignUpGUI.SignUpGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.FXMLLoader;
public class LoginGUI {

    @FXML
    private Button partnerButton;

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
        assert signinAnchor != null : "fx:id=\"signinAnchor\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinGoogle != null : "fx:id=\"signinGoogle\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinMail != null : "fx:id=\"signinMail\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinPass != null : "fx:id=\"signinPass\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinRem != null : "fx:id=\"signinRem\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinForg != null : "fx:id=\"signinForg\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinCreate != null : "fx:id=\"signinCreate\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert signinButton != null : "fx:id=\"signinButton\" was not injected: check your FXML file 'LoginGUI.fxml'.";
        assert partnerButton != null : "fx:id=\"signinButton\" was not injected: check your FXML file 'LoginGUI.fxml'.";
       
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignInGUI.class.getResource("SignInGUI.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            signinAnchor.getChildren().removeAll();
            signinAnchor.getChildren().addAll(anchorPane);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        initButtons();
    }

    private void initButtons() {

        
        partnerButton.setOnAction(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(SignUpGUI.class.getResource("SignUpGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                SignUpGUI signUpGUI = (SignUpGUI) fxmlLoader.getController();
                signUpGUI.isFirm(true);
                signinAnchor.getChildren().removeAll();
                signinAnchor.getChildren().add(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
