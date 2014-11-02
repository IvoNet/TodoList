package nl.ordina.todolist.config;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Ivo Woltring
 */
public class TodoFileExposer {



    @Produces
    @MyTodoList
    public String todolist() {
        //FIXME This string should point to an existing file!
        return "/Users/ivonet/dev/junk/todos.txt";
    }
}
