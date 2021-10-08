package View.CustomerGUI.RentsGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Rents;
import View.FirmGUI.RentItem.RentItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import Model.Customer;
import javafx.scene.layout.Pane;

public class RentsGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane customerRentsGrid;

    @FXML
    void initialize() {
        assert customerRentsGrid != null
                : "fx:id=\"customerRentsGrid\" was not injected: check your FXML file 'RentsGUI.fxml'.";

    }

    public void listRents(Customer customer) {
        ArrayList<Rents> rents = Rents.getRents(customer);
        int i = 0;
        for (int r = 0; r < rents.size() / 3 + 1; r++) {
            for (int c = 0; c < 3; c++) {
                if (i < rents.size()) {
                    customerRentsGrid.add(getNode(rents.get(i)), c, r);
                    i++;
                }
            }
        }
    }

    public static Pane getNode(Rents rents) {
        Pane pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RentItem.class.getResource("RentItem.fxml"));
            pane = fxmlLoader.load();
            RentItem rentItem = (RentItem) fxmlLoader.getController();
            rentItem.setInfos(rents);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pane;
    }
}
