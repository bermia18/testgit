package at.htlkaindorf.ahif18.dosth;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TaskDB {

    private static TaskDB theInstance;

    private List<Task> taskList;
    private List<Suggestion> allSuggestions;
    private List<Suggestion> currentSuggestions;

    private TaskDB() {
        taskList = new ArrayList<>();

        taskList.add(new Task(1,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(2,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(3,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(4,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(5,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(6,"DoThis", "12-02-1220", "12-02-2022", "Da is was", false));
        taskList.add(new Task(7,"Hallo", "12-02-1220", "12-02-2022", "Da is was", false));

        allSuggestions = new ArrayList<>();

        allSuggestions.add(new Suggestion("Wandern"));
        allSuggestions.add(new Suggestion("Shisha"));
        allSuggestions.add(new Suggestion("Schwimmen"));
        allSuggestions.add(new Suggestion("Fußball"));
        allSuggestions.add(new Suggestion("Eislaufen"));
        allSuggestions.add(new Suggestion("Handball"));
        allSuggestions.add(new Suggestion("Basketball"));
        allSuggestions.add(new Suggestion("Tanzen"));
        allSuggestions.add(new Suggestion("Surfen"));
        allSuggestions.add(new Suggestion("Lesen"));
        allSuggestions.add(new Suggestion("Kinobesuch"));
        allSuggestions.add(new Suggestion("Essen"));
        allSuggestions.add(new Suggestion("Musik"));

        currentSuggestions = new ArrayList<>();

        currentSuggestions.add(allSuggestions.get(0));
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

    public List<Suggestion> getCurrentSuggestions() {
        return currentSuggestions;
    }

    public void addSuggestions(){
        currentSuggestions.clear();
        Random rand = new Random();

        for(int i = 0; i < 4;){
            int index = rand.nextInt(allSuggestions.size());
            Suggestion newSuggestion = allSuggestions.get(index);

            if(!currentSuggestions.contains(newSuggestion)){
                currentSuggestions.add(newSuggestion);
                i++;
            }
        }
    }

    public void removeSuggestion(int suggestionId){
        currentSuggestions.remove(suggestionId);
    }

}
