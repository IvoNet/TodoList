package nl.ordina.todolist.resource;

import nl.ordina.todolist.model.TodoList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ivo Woltring
 */
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Path("todos")
public class TodoResource {

    @Inject
    private TodoList todoList;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TodoList all() {
        return this.todoList;
    }
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response all() {
//        return Response.ok(this.todoList)
//                       .build();
//    }

    @POST
    public TodoList post(final TodoList todoList) {
        this.todoList = todoList;
        return this.todoList;
    }
//    @POST
//    public Response post(final TodoList todoList) {
//        this.todoList = todoList;
//        System.out.println("todoList = " + todoList);
//        return Response.status(Response.Status.CREATED).build();
//    }


    //Just for test
    @PostConstruct
    public void postConstruct() {
        this.todoList.add("Make a demo");
        this.todoList.add("live coding example");
        this.todoList.add("Tell the people that I don't know why it does not work");
        this.todoList.add("finish up and get lots of tips");
    }

}
