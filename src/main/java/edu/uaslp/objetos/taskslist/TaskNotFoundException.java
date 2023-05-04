package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends RuntimeException{

    private String str1 = "Task with title '";
    private String str3 = "' not found";
    public TaskNotFoundException(){
        super("Task with title 'Hacer ejercicio' not found");
    }

}
