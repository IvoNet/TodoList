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
        todos.add(new Todo(todo));
    }

    public List<Todo> getTodos() {
        return this.todos;
    }
}
