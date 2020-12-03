//The class Shop represents a shop where the counter locations and cash register are located.
public class Shop {

String threadname;
	//The constructor for the class Shop.
	public static void shop()
	{
		
	}
	//The first counter location that customers can go to.
	public static void counterLocation1(String name, int num)
	{
		System.out.println("Customer " + name + " has left the waiting room, they are heading to counter location 1.");
		//Tracks the amount of time a customer will stay at the first counter location.
		long restTime = (long) (Math.random() * 2000);
		//Makes sure to leave the loop if the right number of burritos the customer wants is served.
		if (num > 0)
		{
			try {
				//Goes to all of the servers and gets all of the ingredients for the burritos.
				Server.privateBeefarea(name);
				Server.cheeseArea(name);
				Server.tortillaArea(name);
	            System.out.println("Customer " + name + " gets " + num + " burritos made for them.");
	            //The sleep method is used to transcend the amount of time the customer waits in the first counter location.
	            Thread.sleep(restTime);
	        } catch (InterruptedException e) {
	        }
			//Only three burritos can be made at a time.
			num -= 3;
		}
		else
		{
			Server.name = name;
			Server.num = num;
			//Customer goes into a waiting area before getting three more burritos again.
			Server.waitingArea();
		}
	}
	//The second counter location that customers can go to.
	public static void counterLocation2(String name, int num)
	{
		System.out.println("Customer " + name + " has left the waiting room, they are heading to counter location 1.");
		//Tracks the amount of time a customer will stay at the second counter location.
		long restTime = (long) (Math.random() * 2000);
		//Makes sure to leave the loop if the right number of burritos the customer wants is served.
		if (num > 0)
		{
			try {
				//Goes to all of the servers and gets all of the ingredients for the burritos.
				Server.privateBeefarea(name);
				Server.cheeseArea(name);
				Server.tortillaArea(name);
	            System.out.println("Customer " + name + " gets " + num + " burritos made for them.");
	            //The sleep method is used to transcend the amount of time the customer waits in the first counter location.
	            Thread.sleep(restTime);
	        } catch (InterruptedException e) {
	        }
			//Only three burritos can be made at a time.
			num -= 3;
		}
		else
		{
			Server.name = name;
			Server.num = num;
			//Customer goes to the cash register to pay for the burritos.
			sharedCashregister(name, num);
		}
	}
	//The third counter location that customers can go to.
	public static void counterLocation3()
	{
		
	}
	//The cash register to pay and finally leave the shop.
	public static void sharedCashregister(String name, int num)
	{
		System.out.println("Customer " + name + " paid and left the shop.");
	}
	
}
