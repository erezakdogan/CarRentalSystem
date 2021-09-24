package View.LoginGUI;

import java.net.URL;
import java.util.ResourceBundle;

import View.CustomerGUI.CustomerGUI;
import View.FirmGUI.FirmGUI;
import View.SignUpGUI.SignUpGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;

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
        initButtons();
    }

    private void initButtons() {

        signinButton.setOnAction(arg0 -> {
            if (signinMail.getText().equals("c")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(CustomerGUI.class.getResource("CustomerGUI.fxml"));
                    BorderPane borderPane = fxmlLoader.load();
                    FXMLLoader fxmlLoader2 = new FXMLLoader(CustomerGUI.class.getResource("SearchGUI/SearchGUI.fxml"));
                    AnchorPane borderPane2 = fxmlLoader2.load();
                    borderPane.setCenter(borderPane2);
                    Scene scene = new Scene(borderPane);
                    Stage arg1 = new Stage();
                    arg1.setScene(scene);
                    arg1.setTitle("Customer Window");
                    arg1.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (signinMail.getText().equals("f")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(FirmGUI.class.getResource("FirmGUI.fxml"));
                    BorderPane anchorPane = fxmlLoader.load();
                    FXMLLoader fxmlLoader2 = new FXMLLoader(FirmGUI.class.getResource("MainGUI/MainGUI.fxml"));
                    AnchorPane anchorPane2 = fxmlLoader2.load();
                    anchorPane.setCenter(anchorPane2);

                    Scene scene = new Scene(anchorPane);
                    Stage arg1 = new Stage();
                    arg1.setScene(scene);
                    arg1.setTitle("Firm Window");
                    arg1.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        });

        signinGoogle.setOnAction(arg0->{

        });
        partnerButton.setOnAction(arg0->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(SignUpGUI.class.getResource("SignUpGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                AnchorPane mainAnPane = (AnchorPane) signinAnchor;
                mainAnPane.getChildren().removeAll();
                mainAnPane.getChildren().add(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
