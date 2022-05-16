package at.htlkaindorf.ahif18.dosth;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDB {

    private static TaskDB theInstance;

    private List<Task> todoList;


    private TaskDB() {
        todoList = new ArrayList<>();

        todoList.add(new Task(1,"saveFromHobbys", "DoThat", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(2,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(3,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(4,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(5,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(6,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(7,"saveFromWork","Hallo", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));


    }

    public void addTask(Task task){
        todoList.add(task);
    }


    public synchronized static TaskDB getInstance(){
        if(theInstance == null){
            theInstance = new TaskDB();
        }
        return theInstance;
    }

    public List<Task> getTodoList(){
        return todoList;
    }
}
