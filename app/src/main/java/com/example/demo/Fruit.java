package com.example.demo;

public class Fruit {

    int id;
    String name;
    int count;

    public Fruit(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Fruit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
