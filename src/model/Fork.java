package Model;

import java.util.concurrent.Semaphore;

public class Fork {

    private int ID;
    private String owner;

    public Semaphore fork = new Semaphore(1);

    public Fork(int ID) {
        this.ID = ID;
        this.owner = "";
    }

    public void take() {
        try {

            fork.acquire();

            System.out.println(Thread.currentThread().getName() + " is TAKING fork");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {

            fork.release();

            System.out.println(Thread.currentThread().getName() + " is PUTTING DOWN fork");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
