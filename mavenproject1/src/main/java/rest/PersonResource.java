
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import Entity.Person;
import Facade.PersonFacade;
import Utility.JsonConverter;
import java.util.List;
import javax.ws.rs.DELETE;

@Path("person")
public class PersonResource {

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    @GET
    //@Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        JsonConverter jc = new JsonConverter();
        List<Person> persons = new PersonFacade().getPersons();

        //return jc.getJSONFromPerson(persons);
        return gson.toJson(persons);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id) {
        PersonFacade pf = new PersonFacade();
        Person p = pf.getPerson(id);
        return gson.toJson(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateQuote(String quoteAsJson) {
        
        PersonFacade pf = new PersonFacade();
        Person p = pf.editPerson(gson.fromJson(quoteAsJson, Person.class));
        return gson.toJson(p);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String deleteJson(@PathParam("id") int id) {
        PersonFacade pf = new PersonFacade();
        Person person = pf.deletePerson(id);
        return gson.toJson(person);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertQuote(String quoteAsJson) {

        PersonFacade pf = new PersonFacade();
        Person q = gson.fromJson(quoteAsJson, Person.class);
        pf.addPerson(q);
        return gson.toJson(q);
    }

  



}
