import java.util.concurrent.Semaphore;


public class Customer implements Runnable{
	
	Thread thread;
	//The Semaphore object to be used for acquiring and releasing.
	static Semaphore sem; 
	//The thread name that is a character variable.
    static char threadName; 
    //The name of a Customer object.
    String name;
    //The value of a Customer object.
    int num;
    //The number of people waiting in the waiting room (that has to be 15).
    static int num_waiting=15;
    //The constructor of Customer that creates a new object with a name and a value assigned to it.
	public Customer(String name, int num) {
		//Creates a new name and assigns it to the global variable.
		this.name = name;
		//Creates a new number and assigns it to the global variable.
		this.num = num;
	}
	//The constructor of Customer that creates a new object with a semaphore and a character variable.
	public void customer(Semaphore sem, char threadName)
	{
		//Creates a new semaphore and assigns it to the global variable.
        this.sem = sem; 
      //Creates a new character variable and assigns it to the global variable.
        this.threadName = threadName;
	}
	//This method acquires the semaphore.
	public void wait(int num)
	{
		try {
			sem.acquire();
		} catch (InterruptedException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
		System.out.println("Waiting");
	}
	//This method releases the semaphore.
	public void signal(int num)
	{
		System.out.println(threadName + " releases the permit."); 
        sem.release(); 
		System.out.println("Done");
	}
	//The method that manages the customers waiting in the waiting room.
	public void run() {
		//Tracks the amount of time the customer waits in the waiting room.
        long time = (long) (Math.random() * 2000);
        //Checks to see if there are still customers going in the waiting room.
        if (num_waiting > 0) {
            waitingRoom();
        } else {
            try {
                System.out.println("Customer " + name + " is waiting");
                //The sleep method uses the value of time to make the customer wait for that amount.
                Thread.sleep(time);
                //sem.acquire();
                System.out.println("Customer " + name + " is checking for a free spot in the waiting room.");
                waitingRoom();
            } catch (InterruptedException e) {
            	//sem.release();
                e.printStackTrace();
            }
        }

    }
	
	public void waitingRoom() {
		//Checks to see if there are still customers going in the waiting room.
        if (num_waiting > 0) {
        //Tracks the amount of time the customer waits in the waiting room.
        long time = (long) (Math.random() * 2000);
        try {
            num_waiting--;
            System.out.println("Customer " + name + " sits in the waiting room.");
          //The sleep method uses the value of time to make the customer wait for that amount.
            Thread.sleep(time);
            //sem.acquire();
        } catch (InterruptedException e) {
        	//sem.release();
        }
        num_waiting++;
        //The customer will leave for the first counter location.
        Shop.counterLocation1(name, num);

    } else {
    	//The customer will leave for the second counter location.
    	Shop.counterLocation2(name, num);
        //System.out.println("Customer " + name + " has left since there is no space in the waiting room.");
    }
    }
	//The start method that instantiates a new thread for the class.
    public void start() {
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
	
}
