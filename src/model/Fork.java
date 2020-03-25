package model;

import javafx.scene.control.TextArea;
import java.util.concurrent.Semaphore;

public class Fork {

    private int ID;
    private String owner;
    private TextArea textArea;
    private Semaphore fork = new Semaphore(1);
    
    public Fork(int ID) {
        this.ID = ID;
        this.owner = "";
    }

    void take() {
        try {

            fork.acquire();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void release() {
        try {

            fork.release();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}