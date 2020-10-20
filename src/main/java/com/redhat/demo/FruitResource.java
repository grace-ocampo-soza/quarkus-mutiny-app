package com.redhat.demo;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fruit")
public class FruitResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> fruits() {
        return Fruit.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Fruit fruitFromRequest) {
        Fruit fruit = new Fruit();
        fruit.name = fruitFromRequest.name;
        fruit.description = fruitFromRequest.description;
        fruit.season = fruitFromRequest.season;
        fruit.persist();
        fruit.update();
        return Response.status(Response.Status.CREATED).entity(fruit).build();
    }

}