import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NumberFormatException;
import java.lang.IndexOutOfBoundsException;

/**
 * Class representing the TodoApp application.
 * It is the main entry point for this program.
 */
public class App{

    private static Scanner in = new Scanner(System.in);
    private static final List<String> OPTIONS = Arrays.asList("list", "add", "mark", "archive", "exit");

    public static void main(String[] args) {

        TodoList todoList = new TodoList();
        String option = "";

        while(!option.equals("exit")){

            option = "";

            while (!OPTIONS.contains(option)) {
                option = getOption();
            }

            runFunction(option, todoList);
        }

    }

    private static String getOption() {

        System.out.print("Please specify a command [list, add, mark, archive, exit]: ");

        return in.nextLine();
    }

    private static void runFunction(String option, TodoList todoList) {

        if (option.equals("list")){
            todoList.listItems();
        } else if (option.equals("add")){
            createToDoItem(todoList);
        } else if (option.equals("mark")){
            markItem(todoList);
        } else if (option.equals("archive")){
            todoList.archiveItems();
        }
    }

    private static void createToDoItem(TodoList todoList) {

        TodoItem item = new TodoItem(getItemName());
        todoList.addToList(item);
    }

    private static String getItemName() {

        System.out.print("Enter todo task: ");

        return in.nextLine();
    }

    private static void markItem(TodoList todoList) {

        todoList.listItems();
        System.out.println("Choose item index: ");

        try{

            todoList.markItem(in.nextLine());

        } catch (NumberFormatException | IndexOutOfBoundsException ex) {

            System.out.println("\nThere isn't such index!\n");
        }
    }
}
