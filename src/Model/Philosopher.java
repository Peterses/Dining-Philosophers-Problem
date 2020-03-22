package Model;

public class Philosopher implements Runnable{

    private int id;
    private Object leftFork;
    private Object rightFork;


    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    private void think() {
        try {
            System.out.println(Thread.currentThread().getName() + "go to sleep");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {
            System.out.println(Thread.currentThread().getName() + "go is eating");
            Thread.currentThread().sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

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

    public void setLeftFork(Object leftFork) {
        this.leftFork = leftFork;
    }

    public Object getRightFork() {
        return rightFork;
    }

    public void setRightFork(Object rightFork) {
        this.rightFork = rightFork;
    }
}
