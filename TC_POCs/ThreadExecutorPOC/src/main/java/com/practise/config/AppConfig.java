package com.practise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * This class creates a bean for ThreadPoolTaskExecutor
 *
 */
@Configuration
public class AppConfig {
	/**
	 * Represent the thread pool
	 * corePoolSize
	 */
	@Value("${thread.core.pool.size}")
	public int corePoolSize;
	
	/**
	 * Represent the maximum size for the thread pool
	 * maxPoolSize
	 */
	@Value("${thread.max.pool.size}")
	public int maxPoolSize;

	/**
	 * Represent the capacity of the queue for a number of threads
	 * queueCapacity
	 */
	@Value("${thread.queue.capacity}")
	public int queueCapacity;

	/**
	 * Represent the time to wait for the Thread
	 * threadTimeout
	 */
	@Value("${thread.threadTimeout}")
	public int threadTimeout;

	/**
	 * Represent the name of the Thread
	 * threadNamePrefix
	 */
	@Value("${thread.name.prefix}")
	public String threadNamePrefix;
	
	/**
	 * @return threadPoolTaskScheduler
	 */
	@Bean (name = "threadPoolTaskScheduler")
	public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(corePoolSize);
		
	    return threadPoolTaskScheduler;
	}
	
	/**
	 * @return threadPoolTaskExecutor
	 */
	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
		threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
		threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
		threadPoolTaskExecutor.setKeepAliveSeconds(threadTimeout);
		threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
		return threadPoolTaskExecutor;
	}
}
