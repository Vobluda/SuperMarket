package Supermarket;
import java.util.Random;

public class Customer {
    int ID;
    int minutesWaited = 0;
    int serviceTime;
    int minutesBeingServiced;
    boolean isInQueue;
    boolean hasBeenServiced;

    public Customer (int ID) {
        this.ID = ID;
    }

    public void incrementTimeWaited() {
        this.minutesWaited += 1;
    }

    public void generateServiceTime() {
        Random rand = new Random();
        this.serviceTime = rand.nextInt(5);
    }

    public void hasBeenServiced() {
        if (minutesBeingServiced <=  serviceTime) {
            hasBeenServiced = true;
        } else { hasBeenServiced =  false; }
    }
}
