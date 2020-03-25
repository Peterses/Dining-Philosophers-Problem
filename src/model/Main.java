package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/MainWindow.fxml"));
        primaryStage.setTitle("Dining Philosophers Problem");
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of philosophers");
        int n = scanner.nextInt();

        Philosopher[] philosophers = new Philosopher[n];
        Fork[] forks = new Fork[philosophers.length];

        for (int i = 0; i < philosophers.length; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < philosophers.length - 1; i++) {
            philosophers[i] = new Philosopher(forks[i % forks.length], forks[ (i + 1) % forks.length ]);
        }

        philosophers[philosophers.length - 1] = new Philosopher(forks[philosophers.length - 1], forks[0]);

        for (int i = 0; i < philosophers.length; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.setName("Philosopher " + (i+1));
            thread.start();

        }

        launch(args);

    }
}
