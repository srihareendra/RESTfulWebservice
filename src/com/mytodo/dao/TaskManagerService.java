package com.mytodo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mytodo.springservice.domain.Task;

public class TaskManagerService {
	List<Task> taskList = new ArrayList<Task>();
	Map<Integer, Task> taskData = new HashMap<Integer, Task>();
	public List<Task> getAllTasks() {
		
		/*Task task = new Task();
		task.setName("test");
		task.setDescription("desc");
		task.setId(1);
		task.setPriority("1");
		task.setStatus("ACTIVE");
		taskList.add(task);*/
		return taskList;	
		
	}
	
	public List<Task> archiveAllTasks(int[] taskIds) {
		return taskList;	
		
	}
	public List<Task> archiveTask(int taskId) {
		
		return taskList;	
		
	}
	
public List<Task> deleteTask(int taskId) {
	Iterator iterator = taskList.iterator();
	System.out.println("TaskManagerService : deleteTask id="+taskId);
	 while(iterator.hasNext()){
		Task sel = (Task) iterator.next();
		if(sel.getId()==taskId){
			System.out.println("deleting taskid="+taskId);
			taskList.remove(sel);
			break;
		}
	  }
		return taskList;	
		
	}
	
	public void changeTaskStatus(int taskId, String taskStatus){
		
		Iterator iterator = taskList.iterator();
		System.out.println("TaskManagerService : changeTaskStatus="+taskStatus);
		while(iterator.hasNext()){
			Task sel = (Task) iterator.next();
			sel.setStatus(taskStatus);
			if(sel.getId()==taskId){
				System.out.println("setting status for taskid="+taskId);
				sel.setStatus(taskStatus);
				break;
			}
		}
		return  ;
		
	}
	public void addTask(Task task){
		
		task.setId(1+taskList.size());
		taskList.add(task);
	}
}
