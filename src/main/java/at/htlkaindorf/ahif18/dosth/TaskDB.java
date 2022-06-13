package at.htlkaindorf.ahif18.dosth;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TaskDB implements Subjekt {

    private static TaskDB theInstance;

    private List<Task> todoList;
    private List<Suggestion> allSuggestions;
    private List<Suggestion> currentSuggestions;

    private List<Beobachter> beobachterListe = new ArrayList<Beobachter>();
    private String aktion;

    private TaskDB() {
        todoList = new ArrayList<>();

        todoList.add(new Task(1,"saveFromHobbys", "DoThat", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(2,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(3,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(4,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(5,"saveFromWork","DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(6,"saveFromHobbys", "DoThis", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));
        todoList.add(new Task(7,"saveFromWork","Hallo", LocalDate.parse("1220-12-02"), LocalDate.parse("2022-12-02"), "Da is was", false));

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
        System.out.println(task);
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

        this.benachrichtigeBeobachter();
    }

    public void removeSuggestion(int suggestionId){
        currentSuggestions.remove(suggestionId);
    }

    @Override
    public void registriereBeobachter(Beobachter beobachter) {
        this.beobachterListe.add(beobachter);
    }

    @Override
    public void entferneBeobachter(Beobachter beobachter) {
        this.beobachterListe.remove(beobachter);
    }

    @Override
    public void benachrichtigeBeobachter() {
        for (Beobachter beobachter : beobachterListe){
            beobachter.aktualisiere();
        }
    }
}
