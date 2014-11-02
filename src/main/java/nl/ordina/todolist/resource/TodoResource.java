package nl.ordina.todolist.resource;

import nl.ordina.todolist.model.TodoList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ivo Woltring
 */
@Stateless
//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("todos")
public class TodoResource {

    @Inject @SessionScoped
    private TodoList todoList;


    @GET
    public Response all() {
        return Response.ok(this.todoList)
                       .build();
    }


    @POST
    public Response post(final TodoList todoList) {
        this.todoList = todoList;
        return Response.status(Response.Status.CREATED).build();
    }


    //Just for test
    @PostConstruct
    public void postConstruct() {
        this.todoList.add("Make a demo");
        this.todoList.add("live coding example");
        this.todoList.add("Tell the people that I don't know why it does not work");
        this.todoList.add("finish up and get lots of tips");
    }

}
