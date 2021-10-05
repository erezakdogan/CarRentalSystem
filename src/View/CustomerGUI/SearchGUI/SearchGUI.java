package View.CustomerGUI.SearchGUI;

import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Car;
import View.FirmGUI.FirmGUI;
import View.FirmGUI.RentItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;

public class SearchGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSearchRents;

    @FXML
    private DatePicker dateArrival;

    @FXML
    private DatePicker dateDeparture;

    @FXML
    private TextField searchCity;

    @FXML
    private ComboBox<String> typeVehicle;
    
    @FXML
    private GridPane availablesGrid;

    @FXML
    void initialize() {
        assert buttonSearchRents != null
                : "fx:id=\"buttonSearchRents\" was not injected: check your FXML file 'SearchGUI.fxml'.";
        assert dateArrival != null : "fx:id=\"dateArrival\" was not injected: check your FXML file 'SearchGUI.fxml'.";
        assert dateDeparture != null
                : "fx:id=\"dateDeparture\" was not injected: check your FXML file 'SearchGUI.fxml'.";
        assert searchCity != null : "fx:id=\"searchCity\" was not injected: check your FXML file 'SearchGUI.fxml'.";
        assert typeVehicle != null : "fx:id=\"typeVehicle\" was not injected: check your FXML file 'SearchGUI.fxml'.";
        typeVehicle.getItems().addAll("Sedan", "Suv", "HeatchBack");
        buttonSearchRents.setOnAction(arg0 -> {            
            availablesGrid.getChildren().clear();
            listAvailables();
            System.out.println("clicked");
        });
    }

    private void listAvailables() {
        if (searchCity.getText().length() != 0 && typeVehicle.getSelectionModel().getSelectedItem() != null) {
            ArrayList<Car> availables = Car.getAvailables(searchCity.getText(),
                    typeVehicle.getSelectionModel().getSelectedItem(), dateArrival.getValue(),
                    dateDeparture.getValue());
                    int i = 0;
                    System.out.println(availables.size()/3);
            for (int r = 0; r < availables.size()/3+1; r++) {
                for(int c = 0; c<3;c++){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(FirmGUI.class.getResource("RentItem.fxml"));
                        Pane rentItem = fxmlLoader.load();
                        RentItem rentItemController = (RentItem) fxmlLoader.getController();
                        if(i<availables.size()){
                            availablesGrid.add(rentItem, c, r);
                            rentItemController.setAvaibles(availables.get(i));
                            i++;
                        }
                       
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                

            }
            

        } else {
            JOptionPane.showMessageDialog(null, "Fill in the blanks", "Blank spaces", JOptionPane.ERROR_MESSAGE);

        }
    }
}
