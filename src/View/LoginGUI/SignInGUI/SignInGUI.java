package View.LoginGUI.SignInGUI;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Customer;
import Model.Firm;
import View.SignUpGUI.SignUpGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import View.CustomerGUI.CustomerGUI;
import View.FirmGUI.FirmGUI;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

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
        
        signinGoogle.setOnAction(arg0 -> {

        });

        
        signinButton.setOnAction(arg0 -> {
            String auth = authenticate(signinMail.getText(), signinPass.getText());
            if(auth!=null){
                if(auth=="customer"){
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
                }else if(auth == "firm"){
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
            }
        });
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

    private String authenticate(String mail, String pass) {
        String exists = null;
        for (Customer customer : Customer.getCustomers()) {
            if (customer.getMail().equals(mail) && customer.getPass().equals(pass)) {
                return "customer";
            }
        }
        for (Firm firm : Firm.getFirms()) {
            if (firm.getFirmMail().equals(mail) && firm.getPass().equals(pass)) {
                return "firm";
            }
        }
        return exists;
    }

}
