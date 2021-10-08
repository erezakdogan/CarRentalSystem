package View.FirmGUI.MainGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Model.Firm;
import Model.Rents;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import View.FirmGUI.FirmGUI;
import View.FirmGUI.MainGUI.miniRentItem.MiniFleetItem;
import View.FirmGUI.RentItem.RentItem;
import Model.Car;
import java.io.IOException;

public class MainGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label aboutText;

    @FXML
    private AnchorPane earningsGraph;

    @FXML
    private Label firmName;

    @FXML
    private VBox fleetBox;

    @FXML
    private VBox rentsBox;

    @FXML
    void initialize() {
        assert aboutText != null : "fx:id=\"aboutText\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert earningsGraph != null : "fx:id=\"earningsGraph\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert firmName != null : "fx:id=\"firmName\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert fleetBox != null : "fx:id=\"fleetBox\" was not injected: check your FXML file 'MainGUI.fxml'.";
        assert rentsBox != null : "fx:id=\"rentsBox\" was not injected: check your FXML file 'MainGUI.fxml'.";
    }

    public void loadPanes(Firm firm) {
        ArrayList<Rents> firmRents = Rents.getRents(firm);
        ArrayList<Car> firmCars = Car.getFleet(firm);
        for (int i = 0; i < firmRents.size(); i++) {
            rentsBox.getChildren().addAll(getNode(firmRents.get(i)));
        }
        for (int i = 0; i < 5; i++) {
            fleetBox.getChildren().addAll(getNode(firmCars.get(i)));
        }

    }

    private Pane getNode(Car car) {
        Pane pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiniFleetItem.class.getResource("MiniFleetItem.fxml"));
            pane = fxmlLoader.load();
            MiniFleetItem rentItem = fxmlLoader.getController();
            rentItem.setCarInfo(car);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pane;
    }

    public static Pane getNode(Rents rent) {
        Pane pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FirmGUI.class.getResource("RentItem.fxml"));
            pane = fxmlLoader.load();
            RentItem rentItem = (RentItem) fxmlLoader.getController();
            rentItem.setInfos(rent);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pane;
    }
}
