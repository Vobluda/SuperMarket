package Supermarket;
import java.util.Random;

public class Market {
    Checkout checkout = new Checkout();
    int IDCounter = 0;
    int maxMinsWaited = 0;
    int longestQueue = 0;
    int timeSinceLastQueue = 0;

    public void update() {

        if (checkout.curr!=null) {
            checkout.curr.incrementTimeWaited();//before anything else is done in a loop, increases amount of time waited for every variable relevant by 1 min
            checkout.curr.hasBeenServiced();
        }
        checkout.waiting.incrementTime();

        Random rand = new Random(); //generates if a new person comes to the counter every minute
        if ((rand.nextInt(5) == 1) | timeSinceLastQueue>=4) {
            checkout.addCustomer(IDCounter);
            IDCounter ++;
            timeSinceLastQueue = 0;
        } else {timeSinceLastQueue++;}

        if (checkout.isCurrFinished()) { //if the person currently in checkout is done
            if (checkout.curr!=null) {
                if (checkout.curr.minutesWaited > maxMinsWaited) { maxMinsWaited = checkout.curr.minutesWaited; } //updates metric of longest waited
                System.out.println("Customer " + checkout.curr.ID + " has been checked out with a wait time of " + checkout.curr.minutesWaited); //output
            }
            checkout.moveFromQToCurr(); //puts new person into the one being checked out
        }

        if ((checkout.waiting.getLen() + 1) > longestQueue) { //checks if the queue is the longest it's ever been and updates metric if so
            longestQueue = (checkout.waiting.getLen() + 1);
        }

        if (checkout.curr!=null) {
        System.out.println("Customer " + checkout.curr.ID + " is currently being checked out for " + Integer.toString(checkout.curr.minutesBeingServiced) + " and has been waiting for " + checkout.curr.minutesWaited + " minutes");
        } else {
            System.out.println("No one is being checked out");
        }
        checkout.waiting.displayAll();
    }

    public void start() { //adds first customer and puts him into checkout
        IDCounter = 1;
        checkout.addCustomer(1);
        IDCounter ++ ;
        checkout.moveFromQToCurr();
    }
}
