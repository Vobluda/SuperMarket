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
    } //constructor that allows a specific ID to be inputted

    public void incrementTimeWaited() {
        this.minutesWaited += 1;
    } //changes the minutes waited by 1

    public void generateServiceTime() { //randomly generates the amount of time it will take for the person to be checked out
        Random rand = new Random();
        this.serviceTime = rand.nextInt(5);
    }

    public void hasBeenServiced() { //checks whether or not the person has been checkout yet
        if (minutesBeingServiced >=  serviceTime) {
            hasBeenServiced = true;
        } else { hasBeenServiced =  false; minutesBeingServiced++; }
    }
}
