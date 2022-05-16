package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/tasks")
public class HelloResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return TaskDB.getInstance().getTodoList();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTask(Task task) {

        TaskDB.getInstance().addTask(task);


        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path("" + task.getId());

        return Response.created(uriBuilder.build()).entity(task).build();
    }
}
