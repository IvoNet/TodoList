package nl.ordina.todolist.io;

import nl.ordina.todolist.config.MyTodoList;
import nl.ordina.todolist.model.TodoList;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ivo Woltring
 */
public class TodoListReader {

    @Inject
    @MyTodoList
    private String todolist;

    public TodoList read() {

        try (final InputStreamReader in = new InputStreamReader(new FileInputStream(todolist));
             final BufferedReader br = new BufferedReader(in)) {

            final TodoList todoList = new TodoList();

            br.lines()
              .filter(p -> !(p.isEmpty() || "\n\r\t".contains(p)))
              .forEach(new TodoListReader.StringConsumer(todoList)::convert);

            return todoList;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class StringConsumer {
        private final TodoList todolist;

        public StringConsumer(final TodoList todoList) {
            this.todolist = todoList;
        }

        public void convert(final String line) {
            if (line.startsWith("* ")) {
                this.todolist.add(line.replace("* ", ""), true);
            } else {
                this.todolist.add(line.replace("- ", ""));
            }

        }
    }
}
