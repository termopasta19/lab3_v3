package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TeamGrouper implements EmployeeDataProcessor {
    @Override
    public void processData(List<Employee> employees) {
        Map<String, List<Employee>> groupedEmployees = new HashMap<>();
        for (Employee employee : employees) {
            groupedEmployees.computeIfAbsent(employee.getPosition(), k -> new ArrayList<>()).add(employee);
        }
        System.out.println("Группировка сотрудников по командам:");
        groupedEmployees.forEach((key, value) -> {
            System.out.println(key + ":");
            for (Employee employee : value) {
                System.out.println(" - " + employee.getName());
            }
        });
    }
}
