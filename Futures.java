package threading.Executor_framework;

import java.util.concurrent.*;

public class Futures {
    public static void main(String args[]) throws ExecutionException, InterruptedException{
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        Future<String> future=executorService.submit(()->"hello");
        System.out.println(future.get());
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
