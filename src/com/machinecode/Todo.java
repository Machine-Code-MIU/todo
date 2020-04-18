package com.machinecode;

public class Todo {
    private final int id; // why did i make this final?
    private String title;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // why is there no setter for method for id?

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
