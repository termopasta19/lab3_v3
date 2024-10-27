package org.example;

public abstract class Worker {
    private String name;
    private int hoursWorked;
    private String position;

    public Worker(String name, int hoursWorked, String position) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursWorked(int hrs) {
        this.hoursWorked = hrs;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }


    public String getName() {
        return name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public String getPosition() {
        return position;
    }
}
