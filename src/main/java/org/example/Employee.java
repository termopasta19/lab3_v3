package org.example;

class Employee implements CloneableObject {
    private String name;
    private int hoursWorked;
    private String position;
    private double salary;

    public Employee(String name, int hoursWorked, String position, double salary) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String pos) {
        this.name = "Yaroslav";
        this.hoursWorked = 100500;
        this.position = pos;
        this.salary = 0;
    }

    public Employee() {
        this.name = "Yaroslav";
        this.hoursWorked = 0;
        this.position = "rab";
        this.salary = 0;
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

    public void setSalary(double sl) {
        this.salary = sl;
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

    public double getSalary() {
        return salary;
    }

    @Override
    public Employee clone()
    {
        String poss ="Sales Manager";
        Employee emp =new Employee(poss);
        return emp;

    }
}
