package at.htlkaindorf.ahif18.dosth;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDB {

    private static TaskDB theInstance;

    private List<Task> taskList;

    private TaskDB() {
        taskList = new ArrayList<>();

        taskList.add(new Task(1,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(2,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(3,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(4,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(5,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(6,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(7,"Hallo", "12-02-1220", "12-02-2022", "Da is was", false));


    }

    public void addTask(Task task){
        taskList.add(task);
    }


    public synchronized static TaskDB getInstance(){
        if(theInstance == null){
            theInstance = new TaskDB();
        }
        return theInstance;
    }

    public List<Task> getTaskList(){
        return taskList;
    }
}
