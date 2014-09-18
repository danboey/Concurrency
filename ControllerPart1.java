/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  public static int Max = 9;
  protected NumberCanvas passengers;

  // declarations required
  //count keeps track of number of ppl on platform
  protected int count;

  public Controller(NumberCanvas nc) {
    passengers = nc;
    count = 0;
  }

  public synchronized void newPassenger() throws InterruptedException {
    // complete implementation
    // use "passengers.setValue(integer value)" to update diplay

    //while platform full, wait. otherwise increment 
    for( ; count ==Max; wait());
    count++;
    passengers.setValue(count);
    notifyAll();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException {
    // complete implementation for part I
    int capacity = mcar;
  
    //if not enough ppl on platform to fill car, wait.
    for( ; count < capacity; wait());
    //decrement platform count by the car's capacity
    count = count - capacity;

    // update for part II
    // use "passengers.setValue(integer value)" to update diplay
    passengers.setValue(count);
    notifyAll();
    return capacity; 
  }

  public synchronized void goNow() {
    // complete implementation for part II
  }

}
