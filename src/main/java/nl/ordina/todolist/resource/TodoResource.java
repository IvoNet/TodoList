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

import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Ivo Woltring
 */
@Stateless
@Path("todos")
public class TodoResource {

    @Inject
    private Logger logger;

    @Inject
    private TodoList todoList;

    @GET
    @Produces(APPLICATION_JSON)
    public TodoList all() {
        this.logger.info("all todos retrieved");
        return this.todoList;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public TodoList post(final TodoList todoList) {
        this.logger.info("All todos recieved.");
        this.todoList = todoList;
        return this.todoList;
    }

    @PostConstruct
    public void postConstruct() {
        this.logger.info("PostConstruct");
        this.todoList.add("Prepare this demo", true);
        this.todoList.add("Tell about AngularJs and Java EE7");
        this.todoList.add("live coding example");
        this.todoList.add("fix the mistakes you make.");
        this.todoList.add("Questions");
    }

}
