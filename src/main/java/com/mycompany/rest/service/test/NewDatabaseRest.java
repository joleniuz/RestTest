
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
    @Path("test")
    public String helloWorld(){
        return "Ni kan ju det här!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(){
        List<ActorDTO> actors = new ActorDAO().getActors();
        return Response.ok(actors).build();    
    }
    
    //exempel: http://localhost:8080/rest-service-test/mynewdatabase/actors/1
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id") int actorId){
        ActorDTO actor = new ActorDAO().getActorById(actorId);
        return Response.ok(actor).build();
    }
    
    //exempel: http://localhost:8080/rest-service-test/mynewdatabase/actors/query?id=1
    @Path("/query")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorByQueryParam(@QueryParam("id") int actorId){
        ActorDTO actor = new ActorDAO().getActorById(actorId);
        return Response.ok(actor).build();
    }
    
}
