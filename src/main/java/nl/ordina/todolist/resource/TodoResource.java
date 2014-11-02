package nl.ordina.todolist.resource;

import nl.ordina.todolist.io.TodoListReader;
import nl.ordina.todolist.io.TodoListWriter;
import nl.ordina.todolist.model.TodoList;

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
    private TodoListReader reader;

    @Inject
    private TodoListWriter writer;

    @GET
    @Produces(APPLICATION_JSON)
    public TodoList all() {
        this.logger.info("all todos retrieved");
        return reader.read();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public TodoList post(final TodoList todoList) {
        this.logger.info("All todos recieved.");
        writer.write(todoList);
        return todoList;
    }

}
