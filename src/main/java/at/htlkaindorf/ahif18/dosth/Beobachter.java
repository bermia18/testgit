package at.htlkaindorf.ahif18.dosth;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Beobachter {

    public Beobachter() {
        TaskDB.getInstance().registriereBeobachter(this);
    }

    public void notify(Suggestion suggestion) {
        SuggestionStats.getInstance().increase(suggestion);
    }
}
