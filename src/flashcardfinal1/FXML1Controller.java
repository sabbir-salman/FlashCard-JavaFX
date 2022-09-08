package flashcardfinal1;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.smartcardio.Card;

public class FXML1Controller implements Initializable {

    ArrayList<Card1> cardList = new ArrayList<Card1>();

    FileChooser fileChooser = new FileChooser();

    @FXML
    private Label wrong;
    @FXML
    private JFXTextField question;
    @FXML
    private TextArea answer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void save(MouseEvent event) throws IOException {
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            SaveSystem(file);
        }
    }

    public void SaveSystem(File file) throws FileNotFoundException, IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Iterator<Card1> cardIterator = cardList.iterator();
        while (cardIterator.hasNext()) {
            Card1 c = (Card1) cardIterator.next();
            writer.write(c.getQuestion() + "\n");
            writer.write(c.getAnswer() + "\n");
        }
        writer.close();
    }

    @FXML
    private void next(ActionEvent event) {
        if (answer.getText().isEmpty() && question.getText().isEmpty()) {
            wrong.setText("Fill both of those boxes");
        } else {

            Card1 card = new Card1(question.getText(), answer.getText());
            cardList.add(card);
            question.clear();
            answer.clear();

        }
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void exit(MouseEvent event) {
           System.exit(0);
    }

 

}
