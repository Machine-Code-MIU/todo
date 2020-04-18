package com.machinecode;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final List<Todo> todoList;//association one to many
    Scanner scanner = new Scanner(System.in);
    int countId;

    private Main() {
        todoList = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("======Welcome to the Machine Code Todo application=====");
        Main main = new Main();
    ;
        while (true) {
            main.init();
        }
    }

    private void init() {
        int option = getOption();
        // based on option call appropriate method, eg, using switch case
        switch (option){
            case 1:
                try {
                    viewTodo();
                }catch(Exception ArithmeticException){
                    System.out.println(ArithmeticException.getMessage());
                }
                break;
            case 2:
                addTodo();
                break;
            case 3:
                try {
                    editTodo();
                }
                catch (Exception artimetic){
                    System.out.println(artimetic.getMessage());
                }
                break;
            default:
                try{
                    deleteTodo();
                }
               catch (Exception artimetic){
                   System.out.println(artimetic.getMessage());
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
     */}
    private int getOption() {
            System.out.println("Please choose todo:"+"\n 1) View todos" + "\n 2) Add todos" + "\n 3) Edit todos"+"\n 4) Delete todos");
int chooseOption=scanner.nextInt();
return chooseOption;
        }



    /**
     * *Implement*
     * Print list of todos for user in a nice way
     */
    private void viewTodo ()throws ArithmeticException{
        // make sure to show appropriate message if there are no todos

        if (todoList.size()==0){
            throw new ArithmeticException("There are no todo to show");




        }else {
            System.out.println(todoList);
        }
    }

    /**
     * *Implement*
     * Create a new todo and add to list of todos
     */
    private void addTodo(){
        // Request user for todo title/name
        // make sure title is not an empty string
        // create new todo and add to list of tods
        System.out.print("Please add name of todo:");
        String items=scanner.next();
//        int id=scanner.nextInt();
//        if(items==null){
//            throw new ArithmeticException("Invalid todo name please add again");
//        }
//            try{
//                Todo newTodo=new Todo(scanner.nextInt(),items);
//            todoList.add(newTodo);
//            System.out.println(todoList.add(newTodo));
//               }
//               catch (Exception e){
//                   System.out.println("Invalid todo name please add again");
//               }
        if(items==null){
            throw new ArithmeticException("Invalid todo name please add again");

        }
else {     Todo newTodo = new Todo(countId, items);

            todoList.add(newTodo);

            countId++;

        }

    }

    /**
     * *Implement*
     * Edit a todo
     */
    private void editTodo() throws ArithmeticException{
        // request for id of todo user wants to edit
        // if id does not exit show appropriate error message
        // request for new name for the todo
        System.out.println("Please enter id");
//input from the user is less than zero or greater than size of arraylist-1
        int changeId=scanner.nextInt();
        if((changeId<0 )|| (todoList.size()<=changeId)||(todoList.isEmpty())){
            throw new ArithmeticException("Id doesn't exist");
        }
        else{
//         int newId=   todoList.get(changeId);
         String newTodo=scanner.next();
//         Todo newTodoType= new Todo(changeId,newTodo);
            System.out.println("Please enter the new todo name");
//        Todo updateTode= todoList.set(changeId,newTodoType);
        Todo td= todoList.get(changeId);
        td.setTitle(newTodo);
//            get new value to enter and assign the value to
//                    arrayList.set(index or ifd, value)
        }




       /*  for (int i=0;i<todoList.size();i++) {
            if(i==changeId){
                System.out.println("please enter the new todo name ");
                String newTodo=scanner.next();

                Todo updateTodo=new Todo(changeId,newTodo);

            }
/

        }

  */  }

    /**
     * *Implement*
     * Delete a todo
     */
    private void deleteTodo() throws ArithmeticException{
        // request for id of todo user wants to delete
        // if id does not exit show appropriate error message
        // delete todo from todoList


        if(todoList.isEmpty()){

            throw new ArithmeticException("There is no todo to delete");
        }
        else{
            System.out.println("Please enter the id you want to delete");
        int unwantedTodo=scanner.nextInt();
        for(int i=0;i<todoList.size();i++){
            if(i==unwantedTodo){
                todoList.remove(unwantedTodo);
            }}
        }
    }
}


/** How to improve code?
 * Can you use exceptions for the error checking?
 * Make sure to reuse code
 */
