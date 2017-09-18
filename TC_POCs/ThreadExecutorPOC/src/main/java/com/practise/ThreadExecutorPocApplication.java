package com.practise;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.practise.custom.TaskCreation;

@SpringBootApplication
@EnableScheduling
public class ThreadExecutorPocApplication implements CommandLineRunner{
	@Autowired
	private ApplicationContext context;
	
	@Value("${request.timeout.threshold}")
	private String timeout;
	
	private ThreadPoolTaskScheduler threadPoolTaskScheduler = null;
	private ThreadPoolTaskExecutor threadPoolTaskExecutor = null;
	private boolean isStateChangeSuccessful = true;
	private int counter;
	
	public static void main(String[] args) {
		SpringApplication.run(ThreadExecutorPocApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		threadPoolTaskScheduler = (ThreadPoolTaskScheduler) context.getBean("threadPoolTaskScheduler");
		threadPoolTaskExecutor = (ThreadPoolTaskExecutor) context.getBean("threadPoolTaskExecutor");
		Date currentDate = new Date();
		currentDate.setTime(currentDate.getTime() + Long.parseLong(timeout) * 1000);

		counter = 50;

		String imei1 = "imeiOne";
		TaskCreation taskOne = new TaskCreation(imei1);
		String imei2 = "imeiTwo";
		TaskCreation taskTwo = new TaskCreation(imei2);

		threadPoolTaskScheduler.schedule(() -> {
			System.out.println("Thread one: " + threadPoolTaskScheduler.getThreadNamePrefix());
			taskOne.setIsRunning(true);
			taskOne.run();

		}, currentDate);

		do {
			counter--;
			System.out.println("Waiting 1st time");
		} while (counter != 0);

		threadPoolTaskScheduler.schedule(() -> {
			taskTwo.setIsRunning(true);
			taskTwo.run();
		}, currentDate);

		counter = 50;
		do {
			counter--;
			System.out.println("Waiting 2nd time");
		} while (counter != 0);

		threadPoolTaskScheduler.schedule(() -> {
			taskOne.setIsRunning(false);
			taskTwo.setIsRunning(false);
		}, currentDate);

		// Boolean testing.
		if (!isStateChangeSuccessful)
			System.out.println("State change Unsuccessful");
		else {
			System.out.println("State change Successful");

		}
	}

	
	
}
