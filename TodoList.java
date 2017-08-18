import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */
public class TodoList{

    private ArrayList<TodoItem> toDoItems = new ArrayList<TodoItem>();

    public void addToList(TodoItem item){

        toDoItems.add(item);
    }

    public void listItems(){

        int counter = 1;

        System.out.print("\n");

        for (TodoItem item: toDoItems){

            System.out.println(counter++ + ". " + item);
        }
    }

    public void markItem(String index){

        int intIndex = Integer.valueOf(index);

        toDoItems.get(intIndex - 1).markAsDone();
    }

    public void archiveItems(){

        Iterator<TodoItem> iter = this.toDoItems.iterator();

        while(iter.hasNext()) {
            TodoItem item = iter.next();

            if(item.getIsDone()) {
                iter.remove();
            }
        }
    }

}
