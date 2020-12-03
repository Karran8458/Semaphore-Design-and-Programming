import java.util.concurrent.Semaphore;

//The class Server contains the three servers for serving food and a second customer waiting room.
public class Server {
//The number of people waiting in the waiting room (that has to be 15).
static int num_waiting=15;
//The Semaphore object to be used for acquiring and releasing.
static Semaphore sem;
//The name of a Server object.
static String name;
//The value of a Server object.
static int num;

	public void server()
	{
		
	}
	//The constructor of Customer that creates a new object with a name and a value assigned to it.
	public void Server(String name, int num)
	{
		//Creates a new name and assigns it to the global variable.
		this.name = name;
		//Creates a new number and assigns it to the global variable.
		this.num = num;
	}
	//The private beef area is where the customer can get beef from.
	public static void privateBeefarea(String name)
	{
		System.out.println("Customer " + name + " has gotten the beef from the private beef area. They are now heading to the next server.");
	}
	//The cheese area is where the customer can get cheese from.
	public static void cheeseArea(String name)
	{
		System.out.println("Customer " + name + " has gotten the cheese from the cheese area. They are now heading to the next server.");
	}
	//The tortilla area is where the customer can get a tortilla from.
	public static void tortillaArea(String name)
	{
		System.out.println("Customer " + name + " has gotten the tortilla from the tortilla area. They are now heading to the next server.");
	}
	//The waiting area is the place where the customers can wait to get into the waiting room which can only hold 15 people.
	public static void waitingArea()
	{
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
	//The waiting room is the place where customers can wait. There can only be 15 customers in the waiting room.
	public static void waitingRoom() {
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
}
