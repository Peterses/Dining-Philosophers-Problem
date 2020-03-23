package Model;

import java.util.Random;

public class Philosopher implements Runnable {

    private int id;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() {
        try {

            System.out.println(Thread.currentThread().getName() + " is THINKING");

            Random rand = new Random();
            int random = rand.nextInt(2000) + 500;

            Thread.currentThread().sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {

            System.out.println(Thread.currentThread().getName() + " is EATING");

            Random rand = new Random();
            int random = rand.nextInt(2000) + 500;

            Thread.currentThread().sleep(2000);

            System.out.println(Thread.currentThread().getName() + " ENDED eating");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {

            think();

            if (leftFork.getID() < rightFork.getID()) {
                leftFork.take();
                rightFork.take();
                eat();
                rightFork.release();
                leftFork.release();
            }
            else if (rightFork.getID() < leftFork.getID()) {
                rightFork.take();
                leftFork.take();
                eat();
                leftFork.release();
                rightFork.release();
            }

        }

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

}
