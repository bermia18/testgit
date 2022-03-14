package at.htlkaindorf.ahif18;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/home")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "This is the home Website";
    }
}