package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TeamCrosser implements EmployeeDataProcessor {
    @Override
    public void processData(List<Employee> employees) {
        Set<String> teams = new HashSet<>();
        for (Employee employee : employees) {
            teams.add(employee.getPosition());
        }
        System.out.println("Скрещивание данных о сотрудниках и командах:");
        for (String team : teams) {
            System.out.println("Команда: " + team);
            for (Employee employee : employees) {
                if (employee.getPosition().equals(team)) {
                    System.out.println(" - " + employee.getName() + " (" + employee.getHoursWorked() + " часов, " + employee.getSalary() + " руб.)");
                }
            }
        }
    }
}
