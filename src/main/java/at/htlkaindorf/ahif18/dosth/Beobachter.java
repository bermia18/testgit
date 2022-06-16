package at.htlkaindorf.ahif18.dosth;

/**
 * Observer for the Observer Pattern
 * @project DoSth.
 * @author Michael B
 * @since 15.06.2022
 */
public class Beobachter {

    /**
     * Constructor for the Observer class, registers the Observer to the List to observe (In TaskDB)
     */
    public Beobachter() {
        TaskDB.getInstance().registriereBeobachter(this);
    }

    /**
     * calling the increase function of SuggestionStats class
     * notify is called in TaskDB
     */
    public void notify(Suggestion suggestion) {
        SuggestionStats.getInstance().increase(suggestion);
    }
}
