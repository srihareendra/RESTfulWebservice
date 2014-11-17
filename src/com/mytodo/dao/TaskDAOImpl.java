package com.mytodo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mytodo.springservice.domain.Task;


public class TaskDAOImpl implements TaskDAO {
	private List<Task> tasksList = new ArrayList<Task>();
	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		task.setId(1+tasksList.size());
		System.out.println("adding task ..." +task.getId()) ;
		tasksList.add(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		System.out.println("TaskDAOImpl : getAllTasks size - "+tasksList.size());
		
		/*if(tasksList.isEmpty()){
			Task tsk = new Task();
			tsk.setId(1);
			tsk.setName("test");
			tsk.setStatus("PENDING");
			tsk.setPriority("1");
			tasksList.add(tsk);
		}*/
		return tasksList;
	}

	@Override
	public void deleteTask(Integer taskId) {
		// TODO Auto-generated method stub
		System.out.println("TaskDAOImpl: deleet task = "+taskId);
		Iterator iterator  =tasksList.iterator();
		
		while(iterator.hasNext()){
		  Task sel	=(Task)iterator.next();
		  
		  if(sel.getId()==taskId.intValue()){
			  System.out.println("removing sel task ID "+taskId);
			  tasksList.remove(sel);
			  break;
		  }
		  
		}
		
	}

}
