package View.FirmGUI.RentsGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import View.FirmGUI.FirmGUI;
import java.io.IOException;
import View.FirmGUI.RentItem;

import Model.Firm;
import Model.Rents;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    public void listRents(Firm firm) {
    ArrayList<Rents> firmsRents = Rents.getRents(firm);
    int i=0;
    for(int r=0; r<firmsRents.size()/3+1;r++){
        for(int c=0; c<3;c++){
            if(i<firmsRents.size()){
              firmRentsGrid.add(getNode(firmsRents.get(i)) , c, r);
              i++;
            }
        }
    }
    }

    public  Pane getNode(Rents rents) {
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
