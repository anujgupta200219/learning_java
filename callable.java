package threading.Executor_framework;

import java.util.concurrent.*;

public class callable {
    public static void main(String args[]) throws Exception {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
//        Runnable runnable=()-> "hello"; // Return type of run() method is void
        Callable callable=()-> {return "hi";}; // Return type is wildcard and throws error if returning nothing.
        System.out.println(callable.call());
        Future<?>future=executorService.submit(()->"hello");
        Future<?>f=executorService.submit(()-> System.out.println("bye"),1==1 ? "success": "false" );
        executorService.shutdown();
    }
}
