package model;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Philosopher implements Runnable {

    private int id;
    private String name;
    private Fork leftFork;
    private Fork rightFork;

    private TextArea textArea;
    private ImageView leftForkFree;
    private ImageView leftForkBusy;
    private ImageView rightForkBusy;
    private ImageView rightForkFree;
    private TextField numberOfMeals;

    public Philosopher(Fork leftFork, Fork rightFork, ImageView leftForkFree, ImageView leftForkBusy, ImageView rightForkBusy, ImageView rightForkFree, TextField numberOfMeals) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.leftForkFree = leftForkFree;
        this.leftForkBusy = leftForkBusy;
        this.rightForkBusy = rightForkBusy;
        this.rightForkFree = rightForkFree;
        this.numberOfMeals = numberOfMeals;
    }

    private void think() {
        try {

            Platform.runLater(() -> {

                String oldText = textArea.getText();
                String newText = oldText + name + " is THINKING\n";

                textArea.setText(newText);

            });

            Random rand = new Random();
            int random = rand.nextInt(7000) + 4000;

            Thread.currentThread().sleep(random);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {

            System.out.println(Thread.currentThread().getName() + " is EATING");

            Platform.runLater(() -> {

                String oldText = textArea.getText();
                String newText = oldText + name + " is EATING\n";

                textArea.setText(newText);

            });


            Random rand = new Random();
            int random = rand.nextInt(7000) + 4000;

            Thread.currentThread().sleep(random);

            System.out.println(Thread.currentThread().getName() + " ENDED EATING");

            Platform.runLater(() -> {

                int sum = Integer.parseInt(numberOfMeals.getText());
                sum++;
                numberOfMeals.setText(String.valueOf(sum));

                String oldText = textArea.getText();
                String newText = oldText + name + " ENDED EATING\n";

                textArea.setText(newText);

            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeLeftFork() {

            leftFork.take();

            Platform.runLater(() -> {

                String oldText = textArea.getText();
                String newText = oldText + name + " is TAKING LEFT fork\n";

                textArea.setText(newText);
                leftForkFree.setVisible(false);
                leftForkBusy.setVisible(true);

            });

    }

    private void takeRightFork() {

            rightFork.take();
            Platform.runLater(() -> {

                String oldText = textArea.getText();
                String newText = oldText + name + " is TAKING RIGHT fork\n";

                textArea.setText(newText);
                rightForkFree.setVisible(false);
                rightForkBusy.setVisible(true);

            });
    }

    private void putDownLeftFork() {



        Platform.runLater(() -> {

            String oldText = textArea.getText();
            String newText = oldText + name + " is PUTTING DOWN LEFT fork\n";

            textArea.setText(newText);
            leftForkBusy.setVisible(false);
            leftForkFree.setVisible(true);

        });

        leftFork.release();

    }

    private void putDownRightFork() {

        Platform.runLater(() -> {

            String oldText = textArea.getText();
            String newText = oldText + name + " is PUTTING DOWN RIGHT fork\n";

            textArea.setText(newText);
            rightForkBusy.setVisible(false);
            rightForkFree.setVisible(true);

        });

        rightFork.release();

    }

    @Override
    public void run() {

        while (true) {

            think();

            if (leftFork.getID() < rightFork.getID()) {

                takeLeftFork();
                takeRightFork();
                eat();
                putDownRightFork();
                putDownLeftFork();
            }
            else if (rightFork.getID() < leftFork.getID()) {
                takeRightFork();
                takeLeftFork();
                eat();
                putDownLeftFork();
                putDownRightFork();
            }

        }

    }

    public ImageView getLeftForkFree() {
        return leftForkFree;
    }

    public void setLeftForkFree(ImageView leftForkFree) {
        this.leftForkFree = leftForkFree;
    }

    public ImageView getLeftForkBusy() {
        return leftForkBusy;
    }

    public void setLeftForkBusy(ImageView leftForkBusy) {
        this.leftForkBusy = leftForkBusy;
    }

    public ImageView getRightForkBusy() {
        return rightForkBusy;
    }

    public void setRightForkBusy(ImageView rightForkBusy) {
        this.rightForkBusy = rightForkBusy;
    }

    public ImageView getGetRightForkFree() {
        return rightForkFree;
    }

    public void setGetRightForkFree(ImageView rightForkFree) {
        this.rightForkFree = rightForkFree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public Object getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
}
