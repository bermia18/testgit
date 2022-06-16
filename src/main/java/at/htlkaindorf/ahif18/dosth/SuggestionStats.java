package at.htlkaindorf.ahif18.dosth;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Database for the suggestions (Which suggestions are often taken)
 * @project DoSth.
 * @author Michael B
 * @since 15.06.2022
 */
public class SuggestionStats {
    private static SuggestionStats theInstance;
    private HashMap<Suggestion, Integer> statistic;

    /**
     * Constructor for the database, inits the Hashmap for the statistic with all the possible suggestion and values 0 for each one
     */
    private SuggestionStats() {
        statistic = new HashMap<Suggestion, Integer>();

        List<Suggestion> suggestions = TaskDB.getInstance().getAllSuggestions();

        for(int i = 0; i < suggestions.size(); i++){
            statistic.put(suggestions.get(i), 0);
        }
    }

    /**
     * getInstance class for the singleton Pattern
     * @return instance of SuggestionStats
     */
    public synchronized static SuggestionStats getInstance(){
        if(theInstance == null){
            theInstance = new SuggestionStats();
        }
        return theInstance;
    }

    /**
     * increases the value in the hashmap for the key (suggestion) by 1
     * @param suggestion which was used
     */
    public void increase(Suggestion suggestion){
        statistic.put(suggestion, statistic.get(suggestion)+1);

        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("Suggestion " + suggestion.getTitle() + " wurde um 1 erhöht und steht jetzt bei " + statistic.get(suggestion));
    }

    /**
     * getter for the HashMap with the statistics if needed for future features
     */
    public HashMap<Suggestion, Integer> getStatistic() {
        return statistic;
    }
}
