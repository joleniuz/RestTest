
package com.mycompany.rest.service.test;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import actor.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel
 */
@Path("actors")
public class NewDatabaseRest {
    
    
    @GET
    @Path("hello")
    public String helloWorld(){
        return "Hello WHO DIS";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(){
        List<ActorDTO> actors = new ActorDAO().getActors();
        return Response.ok(actors).build();
    }
}
