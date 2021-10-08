package View.FirmGUI.MainGUI.miniRentItem;

import java.net.URL;
 import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import Model.Car;
 public class MiniFleetItem {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label dailyPrice;

    @FXML
    private ImageView image;

    @FXML
    private Label make;

    @FXML
    private Label model;

    @FXML
    void initialize() {
        assert dailyPrice != null : "fx:id=\"dailyPrice\" was not injected: check your FXML file 'MiniFleetItem.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'MiniFleetItem.fxml'.";
        assert make != null : "fx:id=\"make\" was not injected: check your FXML file 'MiniFleetItem.fxml'.";
        assert model != null : "fx:id=\"model\" was not injected: check your FXML file 'MiniFleetItem.fxml'.";

    }

    public void setCarInfo(Car car){
        dailyPrice.setText(String.valueOf(car.getDailyPrice()));
        make.setText(car.getMake());        
    }
}
