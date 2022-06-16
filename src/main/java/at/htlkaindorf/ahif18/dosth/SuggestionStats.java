package at.htlkaindorf.ahif18.dosth;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class SuggestionStats {
    private static SuggestionStats theInstance;
    private HashMap<Suggestion, Integer> statistic;

    private SuggestionStats() {
        statistic = new HashMap<Suggestion, Integer>();

        List<Suggestion> suggestions = TaskDB.getInstance().getAllSuggestions();

        for(int i = 0; i < suggestions.size(); i++){
            statistic.put(suggestions.get(i), 0);
        }
    }

    public synchronized static SuggestionStats getInstance(){
        if(theInstance == null){
            theInstance = new SuggestionStats();
        }
        return theInstance;
    }

    public void increase(Suggestion suggestion){
        statistic.put(suggestion, statistic.get(suggestion)+1);

        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("Suggestion " + suggestion.getTitle() + " wurde um 1 erhöht und steht jetzt bei " + statistic.get(suggestion));
    }

    public HashMap<Suggestion, Integer> getStatistic() {
        return statistic;
    }
}
