package at.htlkaindorf.ahif18.dosth;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Database for the todolist and the suggestions
 * @project DoSth.
 * @author Michael M, Michael B
 * @since 13.06.2022
 */
public class TaskDB {

    private static TaskDB theInstance;
    private List<Task> todoList;
    private List<Task> finished;
    private List<Suggestion> allSuggestions;
    private List<Suggestion> currentSuggestions;

    /**
     * Constructor for the database, fills the suggestions with values
     */
    private TaskDB() {
        todoList = new ArrayList<>();
        finished = new ArrayList<>();

        /*todoList.add(new Task(1,"saveFromHobbys", "DoThat", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(2,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(3,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(4,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(5,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(6,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(7,"saveFromWork","Hallo", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
*/
        allSuggestions = new ArrayList<>();

        allSuggestions.add(new Suggestion("Wandern", 1));
        allSuggestions.add(new Suggestion("Shisha", 2));
        allSuggestions.add(new Suggestion("Schwimmen", 3));
        allSuggestions.add(new Suggestion("Fußball",4 ));
        allSuggestions.add(new Suggestion("Eislaufen",5 ));
        allSuggestions.add(new Suggestion("Handball",6));
        allSuggestions.add(new Suggestion("Basketball",7));
        allSuggestions.add(new Suggestion("Tanzen",8));
        allSuggestions.add(new Suggestion("Surfen",9));
        allSuggestions.add(new Suggestion("Lesen",10));
        allSuggestions.add(new Suggestion("Kinobesuch",11));
        allSuggestions.add(new Suggestion("Essen",12));
        allSuggestions.add(new Suggestion("Musik",13));

        currentSuggestions = new ArrayList<>();

        currentSuggestions.add(allSuggestions.get(0));
    }

    /**
     * adds a Task to the todoList
     * @param task task that should be added
     */
    public void addTask(Task task){
        todoList.add(task);
    }

    /**
     * updates the task to checked after you clicked the checkbox
     * @param task task that should be updated
     */
    public void updateTask(Task task){
        task.setChecked(true);

    }

    /**
     * getInstance class for the singleton Pattern
     * @return instance of TaskDB
     */
    public synchronized static TaskDB getInstance(){
        if(theInstance == null){
            theInstance = new TaskDB();
        }
        return theInstance;
    }

    /**
     * gets the complete todoList
     * @return todoList
     */
    public List<Task> getTodoList(){
        return todoList;
    }

    /**
     * gets the current Suggestions
     * @return current Suggestions
     */
    public List<Suggestion> getCurrentSuggestions() {
        return currentSuggestions;
    }

    /**
     * adds new suggestions to the current suggestions
     */
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

    /**
     * gets the suggestion of your choice
     * @param id of the suggestion you clicked on
     */
    public void suggestionChange(int id){
        String title = currentSuggestions.get(id).getTitle();
        todoList.add(new Task(todoList.size(), "saveFromHobbys", title, LocalDate.now(), LocalDate.now().plusDays(1),
                "Today you should try" + title , false));
    }

    /**
     * removes the suggestion you added
     * @param suggestionId id of suggestion
     */
    public void removeSuggestion(int suggestionId){
        currentSuggestions.remove(suggestionId);
    }

}
