package View.FirmGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import Model.Firm;
import View.FirmGUI.FleetGUI.FleetGUI;
import View.FirmGUI.MainGUI.MainGUI;
import View.FirmGUI.ProfileGUI.ProfileGUI;
import View.FirmGUI.RentsGUI.RentsGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FirmGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label firmName;

    @FXML
    private Button firmMainButton;

    @FXML
    private Button firmRentsButton;

    @FXML
    private Button firmFleetButton;

    @FXML
    private Button firmProfileButton;

    @FXML
    private Button firmLogoutButton;

    @FXML
    private AnchorPane firmRentOverview;

    @FXML
    private AnchorPane firmAbout;

    @FXML
    private AnchorPane firmCurrentRevenue;

    @FXML
    private AnchorPane firmFleetOverview;

    @FXML
    private BorderPane borderPane;
    Firm firm;

    @FXML
    void initialize() {
        assert firmName != null : "fx:id=\"firmName\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmMainButton != null
                : "fx:id=\"firmMainButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmRentsButton != null
                : "fx:id=\"firmRentsButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmFleetButton != null
                : "fx:id=\"firmFleetButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmProfileButton != null
                : "fx:id=\"firmProfileButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmLogoutButton != null
                : "fx:id=\"firmLogoutButton\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmRentOverview != null
                : "fx:id=\"firmRentOverview\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmAbout != null : "fx:id=\"firmAbout\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmCurrentRevenue != null
                : "fx:id=\"firmCurrentRevenue\" was not injected: check your FXML file 'FirmGUI.fxml'.";
        assert firmFleetOverview != null
                : "fx:id=\"firmFleetOverview\" was not injected: check your FXML file 'FirmGUI.fxml'.";

        initButtons();
    }

    private void initButtons() {
        firmMainButton.setOnAction(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("MainGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                MainGUI mainGUI = (MainGUI) fxmlLoader.getController();
                mainGUI.loadPanes(firm);
                borderPane.setCenter(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });

        firmRentsButton.setOnAction(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(RentsGUI.class.getResource("RentsGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                RentsGUI rentsGUI = (RentsGUI) fxmlLoader.getController();
                rentsGUI.listRents(firm);
                borderPane.setCenter(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });

        firmFleetButton.setOnAction(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(FleetGUI.class.getResource("FleetGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                FleetGUI fleetGUI = fxmlLoader.getController();
                fleetGUI.setFirms(firm);
                borderPane.setCenter(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });
        firmProfileButton.setOnAction(arg0 -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(ProfileGUI.class.getResource("ProfileGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ProfileGUI profileGUI = fxmlLoader.getController();
                profileGUI.setFirm(reloadFirm(firm));
                borderPane.setCenter(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });

        firmLogoutButton.setOnAction(arg0->{
            Stage stage = (Stage) firmLogoutButton.getScene().getWindow();
            stage.close();
    });
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
        firmName.setText(firm.getFirmName());
    }

    public Firm reloadFirm(Firm firm){
        for(Firm f : Firm.getFirms()){
            if(f.getId()==firm.getId()){
                return f;
            }
        }
        return null;
    }
}
