package nl.ordina.todolist.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivo Woltring
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TodoList {

    private final List<Todo> todos;

    public TodoList() {
        this.todos = new ArrayList<>();
    }


    public void add(final String todo) {
        this.todos.add(new Todo(todo));
    }

    public void add(final String todo, final boolean done) {
        this.todos.add(new Todo(todo, done));

    }

    public List<Todo> getTodos() {
        return this.todos;
    }
}
