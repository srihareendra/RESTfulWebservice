package com.mytodo.springservice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytodo.dao.TaskManagerService;
import com.mytodo.springservice.domain.Task;


@RestController
public class TaskManagerController {
	
	TaskManagerService taskmanagerservice=new TaskManagerService();
	
	 @RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Task> getAllTasks() {	 

	  List<Task> tasks=taskmanagerservice.getAllTasks();
		 System.out.println("TaskManagerController: getAlltasks....tasks= "+tasks);
	  return tasks;
	
	 }
	 
	 
	 @RequestMapping(value="/tasks/archive/{taskIds}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> archiveAllTasks(@PathVariable int[] taskIds) {	
		 
		 System.out.println("TaskManagerController: archiveAllTasks....taskIds[]= "+taskIds);
		 for(int i=0;i<taskIds.length;i++){
			 taskmanagerservice.archiveTask(taskIds[i]);	
			 
		 }
	  List<Task> tasks=taskmanagerservice.getAllTasks();
	  return tasks;
	
	 }
	 
	 @RequestMapping(value="/tasks/delete/{taskId}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> deleteTask(@PathVariable int taskId) {	
		 System.out.println("TaskManagerController: deleting taskId = "+taskId);
		return	 taskmanagerservice.deleteTask(taskId);	
	 }
	 
	 @RequestMapping(value="/tasks/{taskId}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> changeTaskStatus(@PathVariable int taskId,@PathVariable String taskStatus) throws ParseException {	
		 
		 System.out.println("TaskManagerController: changeTaskStatus....taskId= "+taskId+" taskStatus= "+taskStatus);
		 taskmanagerservice.changeTaskStatus(taskId,taskStatus);		 
		 return taskmanagerservice.getAllTasks();
		 
	 }
	 
	 @RequestMapping(value="/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> addTask(@PathVariable String taskName,@PathVariable String taskDesc,@PathVariable String taskPriority,@PathVariable String taskStatus) throws ParseException {	
		Task task = new Task();
		task.setName(taskName);
		task.setDescription(taskDesc);		
		task.setPriority(taskPriority);
		task.setStatus(taskStatus);
		
		System.out.println("TaskManagerController: addTask....taskName= "+taskName+" taskStatus= "+taskStatus+" taskDesc="+taskDesc+" taskPriority="+taskPriority);
		taskmanagerservice.addTask(task);
		return taskmanagerservice.getAllTasks();
		 
	 }	 	 	 	 
}