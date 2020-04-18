package com.machinecode;

public class Todo {
    private final int id; // why did i make this final? TO PROTECT OF CHANGING
    private String title;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // why is there no setter for method for id? BECAUSE IT IS FINAL

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "{id=" + id +", title=" + title+"}";
    }
}
