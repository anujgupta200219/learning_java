package threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class bankacc {
    public final Lock lock =new ReentrantLock();
    public void withdraw() {
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ //wait for 1 sec for acquring lock if not available
                try{
                    System.out.println(Thread.currentThread().getName()+" : processing");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+" : process over");
                }
                catch(Exception e){
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock(); //release the lock
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+" : Not able to acquire lock");
            }
        }
        catch (Exception e){
            Thread.currentThread().interrupt(); //If the thread is interruptes then the exception will be handled by catch but we don't know thread was already interrupted.
        }
        if(Thread.currentThread().isInterrupted()){ //check for thread is interrupted or not
            System.out.println(Thread.currentThread().getName()+" Thread Interrupted");
        }
    }
}

public class bankaccMain {
    public static void main(String args[]){
        bankacc bankacc=new bankacc();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                bankacc.withdraw();
            }
        };
        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        t1.start();
        t2.start();
    }
  
}
