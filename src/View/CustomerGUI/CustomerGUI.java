package View.CustomerGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class CustomerGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameLabel;

    @FXML
    private Button searchButton;

    @FXML
    private Button rentsHistoryButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Button customerLogoutButton;

    @FXML
    private Button buttonSearchRents;

    @FXML
    private TextField searchCity;

    @FXML
    private DatePicker dateArrival;

    @FXML
    private DatePicker dateDeparture;

    @FXML
    private ComboBox<?> typeVehicle;

    @FXML
    void initialize() {
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert searchButton != null
                : "fx:id=\"searchButton\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert rentsHistoryButton != null
                : "fx:id=\"rentsHistoryButton\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert myProfileButton != null
                : "fx:id=\"myProfileButton\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert customerLogoutButton != null
                : "fx:id=\"customerLogoutButton\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert buttonSearchRents != null
                : "fx:id=\"buttonSearchRents\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert searchCity != null : "fx:id=\"searchCity\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert dateArrival != null : "fx:id=\"dateArrival\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert dateDeparture != null
                : "fx:id=\"dateDeparture\" was not injected: check your FXML file 'CustomerGUI.fxml'.";
        assert typeVehicle != null : "fx:id=\"typeVehicle\" was not injected: check your FXML file 'CustomerGUI.fxml'.";

    }

}
