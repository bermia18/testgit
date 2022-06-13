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

@WebListener
@ApplicationPath("/api")
public class HelloApplication extends Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*Timer timer = new Timer();

        int period = 1000;
        timer.schedule(new MyTimeTask(), period);*/

        //Wird nur einmal ausgeführt --> Sollte alle 1000 ms einmal ausgeführt werden

        Runnable drawRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run ausgeführt");
                TaskDB.getInstance().addSuggestions();
            }
        };

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(drawRunnable , 0, 30, TimeUnit.SECONDS);
    }
}