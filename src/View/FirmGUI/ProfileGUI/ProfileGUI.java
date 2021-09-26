package View.FirmGUI.ProfileGUI;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Firm;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import View.FirmGUI.FleetGUI.FleetGUI;

public class ProfileGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField mail;

    @FXML
    private TextField phone;

    @FXML
    private TextField pass;

    @FXML
    private Text about;

    @FXML
    private Button saveButton;

    @FXML
    private AnchorPane profileAnchor;

    Firm firm;

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"profileName\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert about != null : "fx:id=\"about\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'ProfileGUI.fxml'.";
        initButtons();
    }

    private void initButtons() {
        saveButton.setOnAction(arg0 -> {
            updateFirm();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(FleetGUI.class.getResource("FleetGUI.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                FleetGUI fleetGUI = fxmlLoader.getController();
                fleetGUI.setFirms(firm);
                profileAnchor.getChildren().clear();
                profileAnchor.getChildren().add(anchorPane);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void setFirm(Firm firms) {
        this.firm = firms;
        setFields();
    }

    private void setFields() {
        name.setPromptText(firm.getFirmName());
        address.setPromptText(firm.getFirmAddres());
        mail.setPromptText(firm.getFirmMail());
        phone.setPromptText(firm.getFirmPhone());
        pass.setPromptText("********");
    }

    private void updateFirm() {
        TextField[] textFields = { name, address, mail, pass, phone };
        for (int i = 0; i < textFields.length; i++) {

            if (textFields[i].getText().length() != 0) {
                System.out.println(firm.getId());
                Firm.updateFirm(textFields[i].getId(), textFields[i].getText(), firm.getId());
            }
        }
    }
}
