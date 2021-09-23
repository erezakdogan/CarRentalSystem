package View.FirmGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FirmGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label firmName;

    @FXML
    private Button firmMainButton;

    @FXML
    private Button firmRentsButton;

    @FXML
    private Button firmFleetButton;

    @FXML
    private Button firmProfileButton;

    @FXML
    private Button firmLogoutButton;

    @FXML
    private AnchorPane firmRentOverview;

    @FXML
    private AnchorPane firmAbout;

    @FXML
    private AnchorPane firmCurrentRevenue;

    @FXML
    private AnchorPane firmFleetOverview;

    @FXML
    void initialize() {
        assert firmName != null : "fx:id=\"firmName\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmMainButton != null : "fx:id=\"firmMainButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmRentsButton != null : "fx:id=\"firmRentsButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmFleetButton != null : "fx:id=\"firmFleetButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmProfileButton != null : "fx:id=\"firmProfileButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmLogoutButton != null : "fx:id=\"firmLogoutButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmRentOverview != null : "fx:id=\"firmRentOverview\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmAbout != null : "fx:id=\"firmAbout\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmCurrentRevenue != null : "fx:id=\"firmCurrentRevenue\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmFleetOverview != null : "fx:id=\"firmFleetOverview\" was not injected: check your FXML file 'FirmGUI.fxml'.";

    }
}
