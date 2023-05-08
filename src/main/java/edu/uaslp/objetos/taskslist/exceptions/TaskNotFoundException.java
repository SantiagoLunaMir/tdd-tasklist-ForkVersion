package edu.uaslp.objetos.taskslist.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message){
       super(message);
    }
    public TaskNotFoundException(){

    }

}
