package br.com.hospital.hospital.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;


@Configuration
@EnableAsync
public class AsynchConfiguration {

    @Bean(name = "asyncExecutorFork")
    public Executor asyncExecutorFork(){
        return new ForkJoinPool(6,ForkJoinPool.defaultForkJoinWorkerThreadFactory,null,true);
    }

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }
}
