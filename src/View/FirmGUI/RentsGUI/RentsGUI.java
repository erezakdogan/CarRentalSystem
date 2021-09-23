package View.FirmGUI.RentsGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class RentsGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane firmRentsGrid;

    @FXML
    private Label firmRentNum;

    @FXML
    private Label firmActiveRentCar;

    @FXML
    private Label firmTotRevenue;

    @FXML
    void initialize() {
        assert firmRentsGrid != null : "fx:id=\"firmRentsGrid\" was not injected: check your FXML file 'RentsGUI.fxml'.";
        assert firmRentNum != null : "fx:id=\"firmRentNum\" was not injected: check your FXML file 'RentsGUI.fxml'.";
        assert firmActiveRentCar != null : "fx:id=\"firmActiveRentCar\" was not injected: check your FXML file 'RentsGUI.fxml'.";
        assert firmTotRevenue != null : "fx:id=\"firmTotRevenue\" was not injected: check your FXML file 'RentsGUI.fxml'.";

    }
}
