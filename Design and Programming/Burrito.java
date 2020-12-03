//-------------------------------------------------------------------------------------
// Karran Gowda		10/27/2020
// CS640 Operating Systems
// Professor Simco
//-------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class Burrito <E> {

static ArrayList<Customer> waiting1 = new ArrayList<Customer>();
//An array list of customers.
static ArrayList<Server> waiting2 = new ArrayList<Server>();
//The number of customers
static int num_customers = 30;

	public static void main(String args[]) throws InterruptedException  
    { 
        int[] numb = new int[15];
        for (int x = 0; x < 15; x++)
        {
        	numb[x] = (int) ((Math.random() * 19) + 20);
        }
        Arrays.sort(numb);
        while (num_customers > 0)
        {
        if (num_customers <= 15)
        {
        	//A for loop that creates new objects for 30 customers.
        	for (int i = 0; i < num_customers; i++) {
        		waiting1.add(new Customer(String.valueOf(i + 1), numb[i]));
        	}
        	//Instantiates the thread.
        	for (Customer i: waiting1) {
        		i.start();
        	}
        }
        //Only 15 customers are allowed in the waiting room.
        num_customers -= 15;
        }
        //A for loop that creates new objects for 30 customers.
        for (int i = 0; i < num_customers; i++) {
        	//Calls the add method for ArrayList
    		waiting2.add(new Server());
    		//Only 15 customers are allowed in the waiting room.
    		//num_customers -= 15;
    	}
          
    } 
} 
