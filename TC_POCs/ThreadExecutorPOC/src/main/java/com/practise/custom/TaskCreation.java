package com.practise.custom;

public class TaskCreation implements Runnable{

	private String taskId;
	private Boolean isRunning = false;
	
	public TaskCreation() {
	}
	
	public TaskCreation(String taskId) {
		this.taskId = taskId;
	}
	
	@Override
	public void run() {
		while (getRunning()) {			
			System.out.println("Task: starting task : " + getTaskId());
		}
	}
	
	public String getTaskId(){
		return taskId;
	}
	
	public Boolean getRunning(){
		return isRunning;
	}
	
	public void setIsRunning(Boolean isRunning){
		this.isRunning = isRunning;
	}
	
	
}
