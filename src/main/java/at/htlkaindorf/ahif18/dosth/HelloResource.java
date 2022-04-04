package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tasks")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return TaskDB.getInstance().getTaskList();
    }
}