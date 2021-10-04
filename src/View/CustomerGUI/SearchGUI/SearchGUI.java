package View.CustomerGUI.SearchGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Car;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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
            listAvaibles();
        });
    }

    private void listAvaibles() {
        if (searchCity.getText().length() != 0 && typeVehicle.getSelectionModel().getSelectedItem() != null) {
            ArrayList<Car> availables = Car.getAvailables(searchCity.getText(), typeVehicle.getSelectionModel().getSelectedItem(),
            dateArrival.getValue(), dateDeparture.getValue());
            VBox vBox = new VBox();
            Label label;
            for(int i=0; i<availables.size();i++){
                label = new Label();
                label.setText(availables.get(i).getMake());            
                vBox.getChildren().add(label);
                System.out.println(availables.get(i).getMake());
            }
            Scene scene = new Scene(vBox);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        } else {
            JOptionPane.showMessageDialog(null, "Fill in the blanks", "Blank spaces", JOptionPane.ERROR_MESSAGE);

        }
    }
}
