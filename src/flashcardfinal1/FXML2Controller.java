package flashcardfinal1;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXML2Controller implements Initializable {

    FileChooser fileChooser = new FileChooser();
    ArrayList<String> string = new ArrayList<String>();
    private int count = 1;

    @FXML
    private Label showAnswer;
    @FXML
    private JFXButton showId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void show(ActionEvent event) {
        if (count != string.size()) {
            if (count % 2 == 0 || count == 0) {
                showId.setText("Show Answer");
                showAnswer.setText(string.get(count));
                count++;

            } else {
                showId.setText("Next Card");
                showAnswer.setText(string.get(count));
                count++;
            }
        } else {
            showId.setDisable(true);
            showAnswer.setDisable(true);
        }
    }

    @FXML
    private void choose(ActionEvent event) {
        try {
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            File myObj = fileChooser.showOpenDialog(primaryStage);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                string.add(data);
            }
            showAnswer.setText(string.get(0));
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
