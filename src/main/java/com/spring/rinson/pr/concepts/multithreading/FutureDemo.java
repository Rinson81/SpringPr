package com.spring.rinson.pr.concepts.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class FutureDemo {
    @Autowired
    private ExecutorService executorService;
    private CallableTask myCallableTask = new CallableTask();


    public void runDemo () {
        Future<Integer> futureStatus1 = executorService.submit(myCallableTask);
        Future<Integer> futureStatus2 = executorService.submit(myCallableTask);
        log.info("After calling executor Service to start new Thread");
    }

}
@Slf4j
class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        log.info("Starting Call method in Thread: "  + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10);
        log.info("Ending Call method in Thread: "  + Thread.currentThread().getName());
        return 10;
    }

}
