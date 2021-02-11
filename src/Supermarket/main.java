package Supermarket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        Market market = new Market(); //creates a new market
        int IDCounter = 1; //starts the counter for keeping track of the consumer ID
        market.start(); //starts the market, which creates the given amount of checkouts necessary. TO IMPROVE SCALABILITY, I would change the start function to take an int with the amount of checkouts desired and then have all other code feed off of that, but that's not implemented.

        for (int minuteCounter = 0; minuteCounter < 720; minuteCounter++) { //runs the simulation for the desired amount of time
            System.out.println("---Minute " + minuteCounter + "---");

            Random rand = new Random(); //generates if a new person comes to the counter every minute (50% chance)
            if ((rand.nextInt(2) == 1)) {
                int index = market.findIndexOfShortestQueue(); //finds the shortest queue

                market.checkout[index].addCustomer(IDCounter); //adds the customer to that specific queue
                IDCounter ++;
            }

            System.out.println("Queue 1"); //runs through and updates every single checkout. For scalability, this could be changed to a for loop instead to work with x amount of checkouts, but as before, not implemented right now
            market.update(0);
            System.out.println("Queue 2");
            market.update(1);
            System.out.println("Queue 3");
            market.update(2);
            System.out.println("Queue 4");
            market.update(3);

            try {
                TimeUnit.SECONDS.sleep(60); //pauses the program for a minute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---RESULTS---"); //outputs tracked metrics
        System.out.println("Longest time waited: " + market.maxMinsWaited);
        System.out.println("Longest queue: " + market.longestQueue);
    }
}
