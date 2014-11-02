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

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 * @author Ivo Woltring
 */
@Stateless

@Path("todos")
public class TodoResource {

    @Inject
    private TodoList todoList;

    @GET
    @Produces(APPLICATION_JSON)
    public TodoList all() {
        return this.todoList;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public TodoList post(final TodoList todoList) {
        this.todoList = todoList;
        return this.todoList;
    }

    //Just for test
    @PostConstruct
    public void postConstruct() {
        this.todoList.add("prepare this demo", true);
        this.todoList.add("Make a demo");
        this.todoList.add("live coding example");
        this.todoList.add("Tell the people that I don't know why it does not work");
        this.todoList.add("finish up and get lots of tips");
    }

}
