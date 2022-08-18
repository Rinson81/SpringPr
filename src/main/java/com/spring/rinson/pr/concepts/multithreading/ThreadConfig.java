package com.spring.rinson.pr.concepts.multithreading;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadConfig {
    @Bean
    public ExecutorService getExecutorService() {
        return new ThreadPoolExecutor(2, 4, 5L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new BasicThreadFactory.Builder()
                .namingPattern("Rinson-thread-%d")
                .priority(Thread.MAX_PRIORITY)
                .build());
    }
}
