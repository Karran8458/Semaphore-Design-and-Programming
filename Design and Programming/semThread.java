import java.util.concurrent.Semaphore;


public class semThread {
	Semaphore sem; 
    char threadName; 
    public semThread(Semaphore sem, char threadName)  
    { 
        super(); 
        this.sem = sem; 
        this.threadName = threadName; 
    } 
  
    public void run() { 
          
        // run by thread A 
        if(threadName=='A') 
        { 
            System.out.println("Starting " + threadName); 
            try 
            { 
                // First, get a permit. 
                System.out.println(threadName + " is waiting for a permit."); 
              
                // acquiring the lock 
                sem.acquire(); 
              
                System.out.println(threadName + " gets a permit."); 
          
                // Now, accessing the shared resource. 
                // other waiting threads will wait, until this  
                // thread release the lock 
                for(int i=0; i < 5; i++) 
                { 
                    shareThread.count++; 
                    System.out.println(threadName + ": " + shareThread.count); 
          
                    // Now, allowing a context switch -- if possible. 
                    // for thread B to execute 
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
          
                // Release the permit. 
                System.out.println(threadName + " releases the permit."); 
                sem.release(); 
        } 
          
        // run by thread B 
        else
        { 
            System.out.println("Starting " + threadName); 
            try 
            { 
                // First, get a permit. 
                System.out.println(threadName + " is waiting for a permit."); 
              
                // acquiring the lock 
                sem.acquire(); 
              
                System.out.println(threadName + " gets a permit."); 
          
                // Now, accessing the shared resource. 
                // other waiting threads will wait, until this  
                // thread release the lock 
                for(int i=0; i < 5; i++) 
                { 
                    shareThread.count--; 
                    System.out.println(threadName + ": " + shareThread.count); 
          
                    // Now, allowing a context switch -- if possible. 
                    // for thread A to execute 
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
                // Release the permit. 
                System.out.println(threadName + " releases the permit."); 
                sem.release(); 
        } 
    }

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void join() {
		// TODO Auto-generated method stub
		
	} 
} 

