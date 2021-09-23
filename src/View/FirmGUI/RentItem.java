package View.FirmGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class RentItem {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label rentId;

    @FXML
    private Label startDate;

    @FXML
    private Label endDay;

    @FXML
    private Label carMake;

    @FXML
    private Label carType;

    @FXML
    private Label priceLabel;

    @FXML
    private ImageView carImage;

    @FXML
    private Button rentButton;

    @FXML
    void initialize() {
        assert rentId != null : "fx:id=\"rentId\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert endDay != null : "fx:id=\"endDay\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert carMake != null : "fx:id=\"carMake\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert carType != null : "fx:id=\"carType\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert priceLabel != null : "fx:id=\"priceLabel\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert carImage != null : "fx:id=\"carImage\" was not injected: check your FXML file 'RentItem.fxml'.";
        assert rentButton != null : "fx:id=\"rentButton\" was not injected: check your FXML file 'RentItem.fxml'.";

    }
}
