package org.example;

public class Trainee extends Worker implements CloneableObject {

    private String name;
    private int hoursWorked;
    private String position;

    public Trainee(String name, int hoursWorked, String position) {
        super(name, hoursWorked, position);
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

    @Override
    public Employee clone()
    {
        String poss ="Sales Manager";
        Employee emp =new Employee(poss);
        return emp;

    }
}
