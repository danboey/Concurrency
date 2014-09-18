/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

  public static int Max = 9;
  protected NumberCanvas passengers;

  // declarations required
  protected int count;
  protected boolean button = false;
  protected int capacity;
  protected int passengersInCar;

  public Controller(NumberCanvas nc) {
    passengers = nc;
    count = 0;
  }

  public synchronized void newPassenger() throws InterruptedException {
    // complete implementation
    // use "passengers.setValue(integer value)" to update diplay
    for( ; count ==Max; wait());
    count++;
    passengers.setValue(count);
    notifyAll();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException {
    // complete implementation for part I
    capacity = mcar;
    for( ; ((count < capacity) && !(button)); wait());
    //if button pressed before count == capacity, make passengersInCar
    //equal to the number of ppl currently on the platform
    if((count < capacity) && (button)){
      passengersInCar = count;
    }
    else{
      passengersInCar = capacity;
    }
    count = count - passengersInCar;
    passengers.setValue(count);
    notifyAll();
    //reset so that the button press is not remembered
    button = false;
    capacity = 0;
    return passengersInCar; 
  }

  public synchronized void goNow() {
    // complete implementation for part II
    if((count > 0) && !(button) && (capacity > 0)){
      button = true;
      notifyAll();
    }
  }

}
