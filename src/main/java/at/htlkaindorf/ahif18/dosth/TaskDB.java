package at.htlkaindorf.ahif18.dosth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDB {

    private static TaskDB theInstance;

    private List<Task> taskList;

    private TaskDB() {
        taskList = new ArrayList<>();

        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task("Hallo", "12-02-1220", "12-02-2022", "Da is was", false));

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
