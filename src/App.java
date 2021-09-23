import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View/LoginGUI/LoginGUI.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        arg0.setScene(scene);
        arg0.setTitle("CarRental");
        arg0.show();
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }
}
