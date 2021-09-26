package View.FirmGUI.FleetGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Firm;
import View.FirmGUI.ProfileGUI.ProfileGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class FleetGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane firmFleetGrid;

    @FXML
    private TextField firmFleetMake;

    @FXML
    private TextField firmFleetPrice;

    @FXML
    private ComboBox<?> firmFleetType;

    @FXML
    private DatePicker pricePeriodStart;

    @FXML
    private DatePicker fleetAvailableStart;

    @FXML
    private DatePicker pricePeriodEnd;

    @FXML
    private DatePicker fleetAvailableEnd;

    @FXML
    private TextField fleetCount;

    @FXML
    private Button fleetAddButton;

    @FXML
    private AnchorPane fleetAnchor;

    Firm firm;

    @FXML
    void initialize() {
        assert firmFleetGrid != null
                : "fx:id=\"firmFleetGrid\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert firmFleetMake != null
                : "fx:id=\"firmFleetMake\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert firmFleetPrice != null
                : "fx:id=\"firmFleetPrice\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert firmFleetType != null
                : "fx:id=\"firmFleetType\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert pricePeriodStart != null
                : "fx:id=\"pricePeriodStart\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert fleetAvailableStart != null
                : "fx:id=\"fleetAvailableStart\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert pricePeriodEnd != null
                : "fx:id=\"pricePeriodEnd\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert fleetAvailableEnd != null
                : "fx:id=\"fleetAvailableEnd\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert fleetCount != null : "fx:id=\"fleetCount\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        assert fleetAddButton != null
                : "fx:id=\"fleetAddButton\" was not injected: check your FXML file 'FleetGUI.fxml'.";
        initButtons();
    }

    private void initButtons() {
        fleetAddButton.setOnAction(arg0 -> {
            if (firm.getFirmPhone() == null) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(ProfileGUI.class.getResource("ProfileGUI.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    ProfileGUI profileGUI = fxmlLoader.getController();
                    fleetAnchor.getChildren().clear();
                    fleetAnchor.getChildren().add(anchorPane);
                    profileGUI.setFirm(firm);

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void setFirms(Firm firm) {
        this.firm = firm;
    }
}
