package threading.Executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor_Service {
    public static void main(String args[]) throws InterruptedException {
        long starttime=System.currentTimeMillis();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            int finalI = i;
            executorService.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(factorial(finalI));
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10000, TimeUnit.SECONDS);
        System.out.println("Total time: "+ (System.currentTimeMillis()-starttime));
    }
    public static int factorial(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*i;
        }
        return ans;
    }
}
