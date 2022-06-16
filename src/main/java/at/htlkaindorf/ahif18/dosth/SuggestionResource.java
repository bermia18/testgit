package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * Suggestion Resource for the suggestions
 * @project DoSth.
 * @author Michael M, Michael B
 * @since 17.05.2022
 */
@Path("/suggestions")
public class SuggestionResource {
    /**
     * GET Method to get the current 4 suggestions to the Client
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Suggestion> getSuggestion() {
        return TaskDB.getInstance().getCurrentSuggestions();
    }

    /**
     * POST Method to load 4 new suggestions
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response replaceSuggestions(){
        TaskDB.getInstance().addSuggestions();

        return Response.ok().build();
    }

    /**
     * POST Method get a specific suggestion
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response addSuggestion(@PathParam("id") int id){
        TaskDB.getInstance().suggestionChange(id);
        return Response.ok().build();
    }

    /**
     * DELETE Method remove a suggestion
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response removeSuggestion(@PathParam("id") int id){
        TaskDB.getInstance().removeSuggestion(id);

        return Response.ok().build();
    }
    
}
