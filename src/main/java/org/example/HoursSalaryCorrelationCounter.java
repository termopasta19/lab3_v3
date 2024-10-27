package org.example;

import java.util.List;

class HoursSalaryCorrelationCounter implements EmployeeDataProcessor {
    @Override
    public void processData(List<Employee> employees)
    {
        double meanHours = 0.0;
        double meanSalary = 0.0;
        for (Employee employee : employees)
        {
            meanHours += employee.getHoursWorked();
            meanSalary += employee.getSalary();
        }
        meanHours /= employees.size();
        meanSalary /= employees.size();

        double numerator = 0.0;
        double denominator1 = 0.0;
        double denominator2 = 0.0;
        for (Employee employee : employees)
        {
            double diffHours = employee.getHoursWorked() - meanHours;
            double diffSalary = employee.getSalary() - meanSalary;
            numerator += diffHours * diffSalary;
            denominator1 += diffHours * diffHours;
            denominator2 += diffSalary * diffSalary;
        }

        double correlation = numerator / (Math.sqrt(denominator1) * Math.sqrt(denominator2));
        System.out.println("Корреляция между часами работы и зарплатой: " + correlation);
    }
}
