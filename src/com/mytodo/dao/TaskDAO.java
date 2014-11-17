package com.mytodo.dao;

import java.util.List;

import com.mytodo.springservice.domain.Task;


public interface TaskDAO 
{
	//This method will be called when a employee object is added
    public void addTask(Task task);
    //This method return list of employees in database
    public List<Task> getAllTasks();
    //Deletes a employee by it's id
    public void deleteTask(Integer taskId);
}