package pract4;

import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        CompletableFuture<String> future =
//                CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> anotherFuture =
//                future.thenApply((s) -> {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return s + " world";
//                });
//        System.out.println(anotherFuture.get(3, TimeUnit.SECONDS));




//        ExecutorService executorService =
//                Executors.newSingleThreadExecutor();
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("We run it");
//        });
//        executorService.submit(() -> System.out.println("Start"));


        
        
        
        
        
        
//
//        ExecutorService executorService =
//                Executors.newFixedThreadPool(3);
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("We run it");
//        });
//        executorService.submit(() -> System.out.println("Start"));
//    }


        MyExecutorService service = new  MyExecutorService(3);
        service.submit(() -> System.out.println("Start"));
        for (int i = 1; i <= 3; i++){
            int finalI = i;
            Future future = service.submit(new Callable(){
                public Object call() throws Exception {
                    System.out.println("Another thread was executed");
                    return "My name " + finalI;
                }
            });
            System.out.println("Result: " + future.get());
        }
        service.submit(() -> System.out.println("Finish"));
}}

