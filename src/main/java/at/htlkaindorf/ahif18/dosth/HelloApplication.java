package at.htlkaindorf.ahif18.dosth;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Context;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@WebListener
@ApplicationPath("/api")
/**
 * HelloApplication for tasks
 * @project DoSth.
 * @author Michael M, Michael B
 * @since 15.06.2022
 */
public class HelloApplication extends Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new Beobachter();

        Runnable drawRunnable = new Runnable() {
            @Override
            public void run() {
                TaskDB.getInstance().addSuggestions();
            }
        };

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable , 0, 30, TimeUnit.SECONDS);
    }
}