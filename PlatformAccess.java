

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
  private boolean isOccupied = false;

  public synchronized void arrive() throws InterruptedException {
    // complete implementation
    for( ; isOccupied; wait());
    isOccupied = true;
    notifyAll();
    return;
  }

  public synchronized void depart() {
    // complete implementation
    isOccupied = false;
    notifyAll();
    return;
  }

}
