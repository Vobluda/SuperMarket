package Supermarket;
import java.util.Random;

public class Market {
    Checkout[] checkout = new Checkout[4];
    int maxMinsWaited = 0;
    int longestQueue = 0;

    public void update(int ID) {

        if (checkout[ID].curr!=null) {
            checkout[ID].curr.incrementTimeWaited();//before anything else is done in a loop, increases amount of time waited for every variable relevant by 1 min
            checkout[ID].curr.hasBeenServiced();
        }
        checkout[ID].waiting.incrementTime();

        if (checkout[ID].isCurrFinished()) { //if the person currently in checkout is done
            if (checkout[ID].curr!=null) {
                if (checkout[ID].curr.minutesWaited > maxMinsWaited) { maxMinsWaited = checkout[ID].curr.minutesWaited; } //updates metric of longest waited
                System.out.println("Customer " + checkout[ID].curr.ID + " has been checked out with a wait time of " + checkout[ID].curr.minutesWaited); //output
            }
            checkout[ID].moveFromQToCurr(); //puts the front of the queue into curr (person being checked out)
            if (checkout[ID].curr!=null) {
                System.out.println("Dequeueing customer " + checkout[ID].curr.ID + " from checkout " + (ID+1));
            }
        }

        if ((checkout[ID].waiting.getLen() + 1) > longestQueue) { //checks if the queue is the longest it's ever been and updates metric if so
            longestQueue = (checkout[ID].waiting.getLen() + 1);
        }

        if (checkout[ID].curr!=null) {
            System.out.println("Customer " + checkout[ID].curr.ID + " is currently being checked out for " + Integer.toString(checkout[ID].curr.minutesBeingServiced) + " and has been waiting for " + checkout[ID].curr.minutesWaited + " minutes");
        } else {
            System.out.println("No one is being checked out at checkout " + (ID+1));
        }
        checkout[ID].waiting.displayAll(); //prints out entire queue
    }

    public void start() { //adds all necessary checkouts into the array of checkouts
        System.out.println("Market simulation is being started");
        for (int i = 0; i < 4; i++) {
            checkout[i] = new Checkout();
            System.out.println("Created checkout number " + (i+1));
        }
    }

    public int findIndexOfShortestQueue(){
        int shortestTime = 1000; // arbitrarily high value
        int index = 0;
        int time;
        for (int i = 0; i <= 3; i++) { //checks every queue for it's estimated amount of time till a new person would start getting serviced
            if (checkout[i].curr!=null) {
                time = (checkout[i].curr.serviceTime - checkout[i].curr.minutesBeingServiced) + (checkout[i].waiting.getLen() * 2); //formula: amount of time left on the person being checked out and 2 minutes average per person in queue
            } else { time = 0; }
            System.out.println("Queue length of checkout " + (i+1) + " is around " + time);
            if (time < shortestTime) { index = i; shortestTime = time; }
        }
        return index;
    }
}
