package View.FirmGUI.MainGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Model.Firm;
import Model.Rents;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import View.FirmGUI.FirmGUI;
import View.FirmGUI.RentItem;
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

    public void loadPanes(Firm firm){
        ArrayList<Rents> firmRents = Rents.getRents(firm);
        for(int i=0; i<firmRents.size();i++){
            rentsBox.getChildren().addAll(getNode(firmRents.get(i)));
        }
    }
    public static Pane getNode(Rents rents) {
        Pane pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FirmGUI.class.getResource("RentItem.fxml"));
            pane = fxmlLoader.load();
            RentItem rentItem = (RentItem) fxmlLoader.getController();
            rentItem.setInfos(rents);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pane;
    }
}
