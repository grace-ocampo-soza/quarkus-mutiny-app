package com.redhat.demo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> people(@QueryParam("name") String name) {
        if (name != null) {
            List<Person> result = new ArrayList<>();
            result.add(Person.findByName(name));
            return result;
        }
        return Person.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newPerson(Person personFromRequest) {
        Person person = new Person();
        person.name = personFromRequest.name;
        person.lastName = personFromRequest.lastName;
        person.status = personFromRequest.status;
        person.persist();
        person.update();
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

}