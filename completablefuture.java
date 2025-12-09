package threading.Executor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class completable_future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> c1 =CompletableFuture.supplyAsync(()->{
//           return "hello";
//        });
//        CompletableFuture<String> c2 =CompletableFuture.supplyAsync(()->{
//            return "hi";
//        });
//        System.out.println(c1.get());
//        System.out.println(c2.get());
//
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(c1, c2);
//        System.out.println(voidCompletableFuture.get());

//        output
//        hello
//        hi
//        null
      
        ExecutorService s1=Executors.newSingleThreadExecutor();
        CompletableFuture<String> c1 =CompletableFuture.supplyAsync(()->{
            return "hello";
        },s1).thenApplyAsync(data -> data+ " hi",s1);
        System.out.println(c1.get());

      //output
      // hello hi
    }
}
