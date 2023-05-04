package edu.uaslp.objetos.taskslist;

import java.util.*;

public class TaskList{
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
}
