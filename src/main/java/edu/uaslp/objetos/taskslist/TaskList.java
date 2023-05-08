package edu.uaslp.objetos.taskslist;

import edu.uaslp.objetos.taskslist.exceptions.TaskNotFoundException;

import java.time.LocalDateTime;
import java.util.*;

public class TaskList{
    LinkedList<Task> taskList;
    TaskList(){
     taskList=new LinkedList<>();
    }
    public int getSize(){
        return taskList.size();
    }
    public void add(Task task){
        taskList.add(task);
    }
    public void remove(Task task){
        taskList.remove(task);
    }
    public Task find(String title) throws TaskNotFoundException {
        for(Task task:taskList){
            if(task.getTitle().equals(title)){
                return task;
            }
        }
        throw new TaskNotFoundException("Task with title '"+title+"' not found");
    }
    public void markAsDone(String title){
        Task task=find(title);
        task.setDone(true);
    }
    public void markAsNotDone(String title){
        Task task=find(title);
        task.setDone(false);
    }
    public Task getNextTask(){
        Task nextTask;
        Iterator<Task> iterator=taskList.iterator();
        nextTask=iterator.next();
        while(iterator.hasNext()){
            Task actualTask= iterator.next();
            if(actualTask.getDueDate().isBefore(nextTask.getDueDate())&&!actualTask.isDone()){
                nextTask=actualTask;
            }
        }
        return nextTask;
    }
    public List getNextTasks(){
        LinkedList<Task> taskFound=new LinkedList<>();
        Iterator<Task> iterator=taskList.iterator();
        while(iterator.hasNext()){
            Task actualTask= iterator.next();
            if(actualTask.getDueDate().isAfter(LocalDateTime.now()) && !actualTask.isDone()){
                Task task=new Task(actualTask.getTitle(), actualTask.getDescription(),actualTask.getDueDate() , actualTask.isDone());
                taskFound.add(task);
            }
        }
        taskFound.sort((Task a, Task b)->a.getDueDate().compareTo(b.getDueDate()));
        return taskFound;
    }

    /*
      private LinkedList<Task> listaTareas;
    private int size=0;
    public TaskList(){
        listaTareas=new LinkedList<Task>();
    }
    public int getSize(){
        return size;//size
    }
    public void add(Task task){
        listaTareas.add(task);
        size++;
    }
    public void remove(Task task){
        listaTareas.remove(task);
        size--;
    }
    public Task find(String title) throws TaskNotFoundException{
        int index= listaTareas.indexOf(title);
        if(index>=0){
            return listaTareas.get(index);
        }
       throw new TaskNotFoundException();
    }
    public void markAsDone(String title){
        int index=listaTareas.indexOf(title);
        if(index!=-1){
            listaTareas.get(index).setDone(true);
        }
    }
    //markAsNotDone
    public void markAsNotDone(String title) {
        int index=listaTareas.indexOf(title);
        if(index!=-1){
            listaTareas.get(index).setDone(false);
        }
    }
    public Task getNextTask() throws TaskNotFoundException {
        if (size > 0) {
            Task currentTask = listaTareas.peek();
            int currentIndex = listaTareas.indexOf(currentTask);
            if (currentIndex < size - 1) {
                return listaTareas.get(currentIndex + 1);
            }
        }
        throw new TaskNotFoundException();
    }

    public LinkedList<Task> getNextTasks(){
        return null;
    }
     */
}
