/*✅ Problem 1: Employee Management System (Easy Level)
Description:
Write a Java program to implement an ArrayList that stores employee details (ID, Name, and Salary). The program should allow users to:

Add a new employee
Update an existing employee
Remove an employee
Search for an employee by ID
Example Input:
Add Employee
Update Employee
Remove Employee
Search Employee
Display All Employees Enter your choice: 1 Enter Employee ID: 101 Enter Name: John Doe Enter Salary: 50000
Example Output:
Employee added successfully! */

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class employSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public employSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new Name: ");
                emp.name = scanner.nextLine();
                System.out.print("Enter new Salary: ");
                emp.salary = scanner.nextDouble();
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                employees.remove(emp);
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Employee found: ID: " + emp.id + ", Name: " + emp.name + ", Salary: " + emp.salary);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.id + ", Name: " + emp.name + ", Salary: " + emp.salary);
        }
    }

    public static void main(String[] args) {
        employSystem system = new employSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.updateEmployee();
                    break;
                case 3:
                    system.removeEmployee();
                    break;
                case 4:
                    system.searchEmployee();
                    break;
                case 5:
                    system.displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
