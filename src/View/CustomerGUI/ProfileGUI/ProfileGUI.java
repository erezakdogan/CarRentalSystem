package View.CustomerGUI.ProfileGUI;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField identity;

    @FXML
    private TextField mail;

    @FXML
    private TextField name;
    
    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {
        assert identity != null : "fx:id=\"identity\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
       
    }

    public void setCustomer(Customer customer) {
       try {
        name.setPromptText(customer.getName());
        mail.setPromptText(customer.getMail());
        password.setPromptText(customer.getPass());
        phone.setPromptText(customer.getPhone());
        identity.setPromptText(customer.getIdentity());
       } catch (NullPointerException e) {
           System.out.println(e.getMessage());
       }

       saveButton.setOnAction(arg0->{
        updateCustomer(customer);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    });
    }
    private void updateCustomer(Customer customer) {
        TextField[] textFields = { name, mail, password, phone,identity };
        for (int i = 0; i < textFields.length; i++) {

            if (textFields[i].getText().length() != 0) {
                Customer.updateCustomer(textFields[i].getId(), textFields[i].getText(), customer.getId());
            }
        }
    }

}
