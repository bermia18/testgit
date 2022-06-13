package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;
import java.util.NoSuchElementException;

@Path("/tasks")
/**
 * Hello Ressource for tasks
 * @project DoSth.
 * @author Michael M
 * @since 14.03.2022
 */
public class HelloResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * Get method to get all Tasks in the todolist
     */
    public List<Task> getTasks() {
        return TaskDB.getInstance().getTodoList();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    /**
     * PUT Method to update the tasks in checked
     */
    public Response checkTask(@PathParam("id") int id) {
        List<Task> list = TaskDB.getInstance().getTodoList();

        Task changedTask = list.stream().filter(task -> task.getId() == id).findFirst().get();

        TaskDB.getInstance().updateTask(changedTask);

        try{
            return Response.ok(changedTask).build();
        }catch (NoSuchElementException nsee){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    /**
     * POST adds Task to the list
     */
    public Response addTask(Task task) {

        TaskDB.getInstance().addTask(task);


        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path("" + task.getId());

        return Response.created(uriBuilder.build()).entity(task).build();
    }
}
