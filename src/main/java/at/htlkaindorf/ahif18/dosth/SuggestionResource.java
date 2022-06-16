package at.htlkaindorf.ahif18.dosth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/suggestions")
public class SuggestionResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Suggestion> getSuggestion() {
        return TaskDB.getInstance().getCurrentSuggestions();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response replaceSuggestions(){
        TaskDB.getInstance().addSuggestions();

        return Response.ok().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response addSuggestion(@PathParam("id") int id){
        TaskDB.getInstance().suggestionChange(id);
        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response removeSuggestion(@PathParam("id") int id){
        TaskDB.getInstance().removeSuggestion(id);

        return Response.ok().build();
    }
    
}
