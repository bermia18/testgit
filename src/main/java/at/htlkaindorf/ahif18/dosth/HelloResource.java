package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tasks")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return TaskDB.getInstance().getTaskList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTask(Task task){
            TaskDB.getInstance().addTask(task);

            return Response.ok().build();
    }
}