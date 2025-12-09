package threading.Executor_framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class schedule_executor_service {
    public static void main(String args[]){
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("Executing tasks after 2 seconds"),2,2,TimeUnit.SECONDS);
        scheduledExecutorService.schedule(()-> {
            System.out.println("Initiating Shutdown...");
            scheduledExecutorService.shutdown();
        },10, TimeUnit.SECONDS);

    }
}

//----------------Output-----------------
//Executing tasks after 2 seconds
//Executing tasks after 2 seconds
//Executing tasks after 2 seconds
//Executing tasks after 2 seconds
//Executing tasks after 2 seconds
//Initiating Shutdown...
