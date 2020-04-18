package com.machinecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private List<Todo> todoList;
    Scanner scanner = new Scanner(System.in);

    private Main() {
        todoList = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("======Welcome to the Machine Code Todo application=====");
        Main main = new Main();
        while (true) {
            try {
                System.out.println();
                main.init();
            } catch (IllegalStateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void init() {
        int option = getOption();
        // based on option call appropriate method, eg, using switch case
        switch (option) {
            case 1:
                viewTodo();
                break;
            case 2:
                addTodo();
                break;
            case 3:
                editTodo();
                break;
            case 4:
                deleteTodo();
                break;
            default:
                throw new IllegalStateException("Did not provide a valid option");
        }
    }

    /**
     * *Implement*
     * Get the users initial options:
     * Ask the user to choose between
     * 1. View todos
     * 2. Add todos
     * 3. Edit todos
     * 4. Delete todos
     * @return an integer corresponding to the option user entered
     */
    private int getOption() {
        System.out.println("\nSelect one of these options: \n (1) View Todo \n (2) Add Todo \n (3) Edit Todo \n (4) Delete Todo");
        System.out.print("Enter option here: ");
        return scanner.nextInt();
    }

    /**
     * *Implement*
     * Print list of todos for user in a nice way
     */
    private void viewTodo(){
        // make sure to show appropriate message if there are no todos
        if(todoList.size() < 1) throw new IllegalStateException("There are no todos to show");
        todoList.forEach(System.out::println);
    }

    /**
     * *Implement*
     * Create a new todo and add to list of todos
     */
    private void addTodo(){
        // Request user for todo title/name
        System.out.println();
        System.out.print("Enter title of todo: ");
        String title = scanner.next();
        if(title == null || title.length() < 1) throw new IllegalStateException("Todo must have a title");
        // make sure title is not an empty string
        // create new todo and add to todoList
        int id = todoList.size() + 1;
        Todo todo = new Todo(id, title);
        todoList.add(todo);
    }

    /**
     * *Implement*
     * Edit a todo
     */
    private void editTodo(){
        // request for id of todo user wants to edit
        int id = getId("Enter id of todo to edit: ");
        // if id does not exit show appropriate error message
        // request for new name for the todo
        System.out.println();
        System.out.print("Enter new title of todo: ");
        String newName = scanner.next();
        todoList = todoList.stream().peek(t -> {
            if(t.getId() == id) {
                t.setTitle(newName);
            }
        }).collect(Collectors.toList());
    }

    /**
     * *Implement*
     * Delete a todo
     */
    private void deleteTodo(){
        // request for id of todo user wants to delete
        // if id does not exit show appropriate error message
        // delete todo from todoList
        int id = getId("Enter id of todo to delete: ");
        todoList = todoList.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
    }

    /**
     * Helper function to retrieve id for a todo
     */
    private int getId(String message) {
        System.out.println();
        System.out.print(message);
        int id = scanner.nextInt();
        Optional<Todo> todo = todoList.stream().filter(t -> t.getId() == id).findFirst();
        if(todo.isEmpty()) throw new IllegalStateException("No todo with id found");
        return id;
    }
}


/** How to improve code?
 * Can you use exceptions for the error checking?
 * Make sure to reuse code
 */
