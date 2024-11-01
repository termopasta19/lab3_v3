package org.example;

class Employee extends Worker implements CloneableObject {
    private String name;
    private int hoursWorked;
    private String position;
    private double salary;

    public Employee(String name, int hoursWorked, String position, double salary) {
        super(name, hoursWorked, position);
        this.salary = salary;
    }

    public Employee(String pos) {
        super("Yaroslav", 1002000, pos);
        this.salary = 0;
    }

    public Employee() {
        super("Anton", 0, "rab");
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
