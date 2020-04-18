package com.machinecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<Todo> todoList;
    Scanner scanner = new Scanner(System.in);
    int count = 0;

    private Main() {
        todoList = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("======Welcome to the Machine Code Todo application=====");
        Main main = new Main();
        while (true) {
            main.init();
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
     *
     * @return an integer corresponding to the option user entered
     */
    private int getOption() {
        System.out.print("Select one of these options:" + "\n (1) View Todo \n (2) Add Todo \n (3) Edit todo \n (4) Delete todo\n Enter the option here \n");
        int choosenOption = scanner.nextInt();


        return choosenOption;
    }

    /**
     * *Implement*
     * Print list of todos for user in a nice way
     */
    private void viewTodo() {
        // make sure to show appropriate message if there are no todos
        if (todoList.size() == 0) {
            System.out.println("No todo now" + "\n");
        } else {
            System.out.println(todoList);
        }
    }

    /**
     * *Implement*
     * Create a new todo and add to list of todos
     */
    private void addTodo() {
        // Request user for todo title/name
        // make sure title is not an empty string
        // create new todo and add to list of tods

        System.out.print("Enter the name of todo \n");
        String nameInput = scanner.next();
        if (nameInput == null) {
            System.out.println("Name of todo empty. Please enter the name of todo");
        } else {

            Todo todo = new Todo(count, nameInput);
            todoList.add(todo);
            count++;
        }
    }

    /**
     * *Implement*
     * Edit a todo
     */
    private void editTodo() {
        // request for id of todo user wants to edit
        // if id does not exit show appropriate error message
        // request for new name for the todo
        System.out.print("Which #id todo you want to edit \n");
        int idEdit = scanner.nextInt();
        boolean found = false;
        for (Todo todo : todoList) {
            if (todo.getId() == idEdit) {
                found = true;
                System.out.println("Enter the new name of todo");
                String newName = scanner.next();
                todo.setTitle(newName);
            }
        }
        if (!found) {
            System.out.println("#ID does not exit");
        }
    }

    /**
     * *Implement*
     * Delete a todo
     */
    private void deleteTodo() {
        // request for id of todo user wants to delete
        // if id does not exit show appropriate error message
        // delete todo from todoList
        System.out.print("Which #id todo you want to delete \n");
        int idDelete = scanner.nextInt();
        boolean found = false;
        Todo removingTodo = null;
        for (Todo todo : todoList) {
            if (todo.getId() == idDelete) {
                found = true;
                removingTodo = todo;
            }
        }
        todoList.remove(removingTodo);
        if (!found) {
            System.out.println("#ID does not exist");
        }
    }
}


/**
 * How to improve code?
 * Can you use exceptions for the error checking?
 * Make sure to reuse code
 */
