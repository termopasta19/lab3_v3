package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main
{
    public static void main(String[] args) {
         List<Employee> employees = new ArrayList<>();
        class BookXMLHandler  extends DefaultHandler implements EmployeeDataStorage {
            private String name, hoursWorked, position, salary;

            @Override
            public List<Employee> getEmployees() {
                return employees;
            }
            public void push(Employee b) {
                employees.add(b);
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Employee b : employees) {
                    sb.append(b.toString());
                }
                return sb.toString();
            }

            String currentCharacters;
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equalsIgnoreCase("employee")) {

                    String name=attributes.getValue("name");
                    int hoursWorked=Integer.parseInt(attributes.getValue("hoursWorked"));
                    String position=attributes.getValue("position");
                    double salary=Double.parseDouble(attributes.getValue("salary"));
                    employees.add(new Employee(name, hoursWorked, position, salary));}
            }

            @Override
            public void characters(char ch[], int start, int length ) {
                currentCharacters = new String(ch, start, length);
                String currentCharacters = new String(ch, start, length);

            }
        }
        String path = new File("D:\\Study\\RIS\\lab3_v3\\src\\main\\java\\org\\example\\employees").getAbsolutePath();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            BookXMLHandler handler = new BookXMLHandler();
            parser.parse(new File(path), handler);
            for (Employee employee : employees)
                System.out.println(String.format("Имя сотрудника: %s, его hours of working %s, ego position %s, ego salary %s", employee.getName(), employee.getHoursWorked(), employee.getPosition(), employee.getSalary()));
        } catch (IOException x) {
            System.err.println(x);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        EmployeeDataProcessor teamGrouper = new TeamGrouper();
        EmployeeDataProcessor teamCrosser = new TeamCrosser();
        EmployeeDataProcessor hoursSalaryCorrelationCounter = new HoursSalaryCorrelationCounter();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1 - Группировка сотрудников по командам");
            System.out.println("2 - Скрещивание данных о сотрудниках и командах");
            System.out.println("3 - Подсчёт корреляции между часами работы и зарплатой");
            System.out.println("4 - Вывод всех сотрудников");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("\nГруппировка сотрудников по командам:");
                    teamGrouper.processData(employees);
                    break;
                case 2:
                    System.out.println("\nСкрещивание данных о сотрудниках и командах:");
                    teamCrosser.processData(employees);
                    break;
                case 3:
                    System.out.println("\nПодсчёт корреляции между часами работы и зарплатой:");
                    hoursSalaryCorrelationCounter.processData(employees);
                    break;
                case 4:
                    System.out.println("\nВсе сотрудники:");
                    for (Employee employee : employees) {
                        System.out.println(" - " + employee.getName() + " (" + employee.getPosition() + ", " + employee.getSalary() + " руб.)");
                    }
                    break;
                case 5:
                    System.out.println("\nДобавить менеджера по продажам:");
                    Employee emp=new Employee();
                    Employee clone=emp.clone();
                    employees.add(clone);
                break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}





