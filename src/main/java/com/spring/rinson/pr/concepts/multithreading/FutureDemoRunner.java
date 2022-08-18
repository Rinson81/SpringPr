package com.spring.rinson.pr.concepts.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
@Slf4j
public class FutureDemoRunner implements CommandLineRunner {
    private final ExecutorService executorService;

    public FutureDemoRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Callable<Integer> myCallableTask = () -> {
            log.info("Thread One Started");
            TimeUnit.SECONDS.sleep(2);
            return 12345;
        };

        Runnable myRunnableTask = () -> log.info("Thread Two Started");

        Future<Integer> futureStatus = executorService.submit(myCallableTask);

        executorService.execute(myRunnableTask);

        while (true) {
            if (futureStatus.isDone()) {
                log.info("Value From Future Task:" + futureStatus.get());
                break;
            }
            log.info("Waiting for thread to be complete");
            TimeUnit.SECONDS.sleep(1);
        }
        log.info("Exiting");
        executorService.shutdown();
    }
}
