package controllers;


import model.Fork;
import model.Philosopher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public ImageView table_ImageView;
    @FXML
    public Label label_F1;
    @FXML
    public ImageView forkFree1_ImageView;
    @FXML
    public ImageView forkFree2_ImageView;
    @FXML
    public ImageView forkFree3_ImageView;
    @FXML
    public ImageView forkFree4_ImageView;
    @FXML
    public ImageView forkFree5_ImageView;
    @FXML
    public ImageView forkBusyL1_ImageView;
    @FXML
    public ImageView forkBusyR1_ImageView;
    @FXML
    public ImageView forkBusyR2_ImageView;
    @FXML
    public ImageView forkBusyL2_ImageView;
    @FXML
    public ImageView forkBusyL3_ImageView;
    @FXML
    public ImageView forkBusyR3_ImageView;
    @FXML
    public ImageView forkBusyL4_ImageView;
    @FXML
    public ImageView forkBusyR4_ImageView;
    @FXML
    public ImageView forkBusyR5_ImageView;
    @FXML
    public ImageView forkBusyL5_ImageView;
    @FXML
    public Button startVisualization_Button;
    @FXML
    public Button pauseVisualization_Button;
    @FXML
    public ComboBox numberOfPhilosophers_ComboBox;
    @FXML
    public Button start_Button;
    @FXML
    public Button pause_Button;
    @FXML
    public TextField numOfMeals1_TextField;
    @FXML
    public TextField numOfMeals2_TextField;
    @FXML
    public TextField numOfMelals3_TextField;
    @FXML
    public TextField numOfMelas4_TextField;
    @FXML
    public TextField numOfMeals5_TextField;
    @FXML
    TextArea communcation_TextArea = new TextArea();


    public void startVisualization() {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[philosophers.length];

        Fork left = new Fork(0);
        Fork right = new Fork(1);

        left.setTextArea(communcation_TextArea);
        right.setTextArea(communcation_TextArea);


        for (int i = 0; i < philosophers.length; i++) {
            forks[i] = new Fork(i);
            forks[i].setTextArea(communcation_TextArea);
        }

        philosophers[0] = new Philosopher(forks[0 % forks.length], forks[(0 + 1) % forks.length], forkFree1_ImageView, forkBusyL1_ImageView, forkBusyR1_ImageView, forkFree2_ImageView, numOfMeals1_TextField);
        philosophers[1] = new Philosopher(forks[1 % forks.length], forks[(1 + 1) % forks.length], forkFree2_ImageView, forkBusyL2_ImageView, forkBusyR2_ImageView, forkFree3_ImageView, numOfMeals2_TextField);
        philosophers[2] = new Philosopher(forks[2 % forks.length], forks[(2 + 1) % forks.length], forkFree3_ImageView, forkBusyL3_ImageView, forkBusyR3_ImageView, forkFree4_ImageView, numOfMelals3_TextField);
        philosophers[3] = new Philosopher(forks[3 % forks.length], forks[(3 + 1) % forks.length], forkFree4_ImageView, forkBusyL4_ImageView, forkBusyR4_ImageView, forkFree5_ImageView, numOfMelas4_TextField);


        philosophers[philosophers.length - 1] = new Philosopher(forks[philosophers.length - 1], forks[0], forkFree5_ImageView, forkBusyL5_ImageView, forkBusyR5_ImageView, forkFree1_ImageView, numOfMeals5_TextField);

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i].setTextArea(communcation_TextArea);
            philosophers[i].setName("Philosopher " + (i + 1));
            Thread thread = new Thread(philosophers[i]);
            thread.setName("Philosopher " + (i + 1));
            thread.start();

        }

    }


    public void startWithoutVisualization() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
