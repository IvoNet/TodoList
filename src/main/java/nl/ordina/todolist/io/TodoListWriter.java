package nl.ordina.todolist.io;

import nl.ordina.todolist.config.MyTodoList;
import nl.ordina.todolist.model.TodoList;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author Ivo Woltring
 */
public class TodoListWriter {

    @Inject
    @MyTodoList
    private String todolist;

    @Inject
    private Logger logger;

    public void write(final TodoList todoList) {

        final StringBuilder todos = new StringBuilder();

        todoList.getTodos()
                .stream()
                .forEach(todo -> {
                    if (todo.isDone()) {
                        todos.append("* ");
                    } else {
                        todos.append("- ");
                    }
                    todos.append(todo.getTodo());
                    todos.append('\n');
                });

        try {
            Files.write(Paths.get(todolist), todos.toString()
                                                  .getBytes());
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }

    }

}
