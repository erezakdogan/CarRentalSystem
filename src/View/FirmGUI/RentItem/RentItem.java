package View.FirmGUI.RentItem;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Car;
import Model.Customer;
import Model.Firm;
import Model.Rents;
import View.CustomerGUI.ProfileGUI.ProfileGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    public void setAvaibles(Car car, Customer customer, LocalDate localDate, LocalDate localDate2) {
        startDate.setVisible(false);
        endDay.setVisible(false);
        carMake.setText(car.getMake());
        carType.setText(car.getType());
        priceLabel.setText(String.valueOf(car.getDailyPrice()));
        rentButton.setOnAction(arg0 -> {
            if (customer.getIdentity() != null) {
                Rents.addRent(car, customer.getIdentity(), localDate, localDate2);
            } else {
                JOptionPane.showMessageDialog(null, "Edith Your Profile", "Miss Informations",
                        JOptionPane.ERROR_MESSAGE);

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(ProfileGUI.class.getResource("ProfileGUI.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    ProfileGUI profileGUI = fxmlLoader.getController();
                    profileGUI.setCustomer(customer);
                    Scene scene = new Scene(anchorPane);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void setInfos(Rents rents) {
        Firm firm = Firm.getFirms().stream().filter(predicate -> predicate.getId() == rents.getFirm_id()).findFirst()
                .orElse(null);
        String[] startEnd = rents.getRes_per().split("/");
        startDate.setText(startEnd[0]);
        endDay.setText(startEnd[1]);
        carMake.setText(rents.getCar_make());
        carType.setText(firm.getFirmName());
        priceLabel.setText(String.valueOf(rents.getPrice()));
        rentButton.setVisible(false);
        rentButton.setManaged(false);
    }
}
