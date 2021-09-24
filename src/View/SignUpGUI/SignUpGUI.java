package View.SignUpGUI;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Customer;
import Model.Firm;
import View.LoginGUI.LoginGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

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

    private boolean isFirm;

    @FXML
    private TextField signUpAddress;

    @FXML
    private Label addressLabel;

    @FXML
    void initialize() {
        assert signupAnchor != null : "fx:id=\"signupAnchor\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupGoogle != null : "fx:id=\"signupGoogle\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupName != null : "fx:id=\"signupName\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupMail != null : "fx:id=\"signupMail\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupPass != null : "fx:id=\"signupPass\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupButton != null : "fx:id=\"signupButton\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signupTerms != null : "fx:id=\"signupTerms\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        addressLabel.setVisible(false);
        signUpAddress.setVisible(false);
        if (isFirm) {
            addressLabel.setVisible(true);
            signUpAddress.setVisible(true);
        }
        initButtons();
    }

    private void initButtons() {
        signupButton.setOnAction(arg0 -> {
            addUser();
            goToSignIn();
        });
    }

    

    private void addUser() {
        if (signupMail.getText().length() != 0 && signupName.getText().length() != 0
                && signupPass.getText().length() != 0 || signUpAddress.getText().length() != 0) {
            if (signupTerms.isSelected()) {
                if (!isFirm) {
                    Customer.addCustomer(signupName.getText(), signupMail.getText(), signupPass.getText());
                }else{
                    Firm.addFirm(signupName.getText(), signupMail.getText(), signupPass.getText(),signUpAddress.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Terms&Conditions must be accepted.", "Not eccepted error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fill the personal information fields", "Blank fields error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void goToSignIn() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginGUI.class.getResource("SignInGUI/SignInGUI.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            signupAnchor.getChildren().removeAll();
            signupAnchor.getChildren().add(anchorPane);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void isFirm(Boolean isFirm) {
        this.isFirm = isFirm;
    }

}
