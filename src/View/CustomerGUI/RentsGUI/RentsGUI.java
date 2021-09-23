package View.CustomerGUI.RentsGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class RentsGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane customerRentsGrid;

    @FXML
    void initialize() {
        assert customerRentsGrid != null : "fx:id=\"customerRentsGrid\" was not injected: check your FXML file 'RentsGUI.fxml'.";

    }
}
