package com.machinecode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final List<Todo> todoList;

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
        return -1;
    }

    /**
     * *Implement*
     * Print list of todos for user in a nice way
     */
    private void viewTodo(){
        // make sure to show appropriate message if there are no todos
    }

    /**
     * *Implement*
     * Create a new todo and add to list of todos
     */
    private void addTodo(){
        // Request user for todo title/name
        // make sure title is not an empty string
        // create new todo and add to list of tods
    }

    /**
     * *Implement*
     * Edit a todo
     */
    private void editTodo(){
        // request for id of todo user wants to edit
        // if id does not exit show appropriate error message
        // request for new name for the todo
    }

    /**
     * *Implement*
     * Delete a todo
     */
    private void deleteTodo(){
        // request for id of todo user wants to delete
        // if id does not exit show appropriate error message
        // delete todo from todoList
    }
}


/** How to improve code?
 * Can you use exceptions for the error checking?
 * Make sure to reuse code
 */
