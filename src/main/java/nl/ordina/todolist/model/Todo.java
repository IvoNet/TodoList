package nl.ordina.todolist.model;

/**
 *
 * @author Ivo Woltring
 */
public class Todo {
    private  String todo;
    private boolean done;


    public Todo() {
        this.todo = "";
        this.done = false;
    }

    public Todo(final String todo) {
        this.todo = todo;
        this.done = false;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return this.todo;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }
}
