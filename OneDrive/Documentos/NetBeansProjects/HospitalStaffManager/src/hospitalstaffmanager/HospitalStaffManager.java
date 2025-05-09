/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalstaffmanager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author maryl
 */
public class HospitalStaffManager {
 static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Welcome to the Hospital Staff Manager!");

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ", 1, MenuOption.values().length);
            MenuOption selectedOption = MenuOption.values()[choice - 1];

            switch (selectedOption) {
                case ADD_RECORDS:
                    addEmployee();
                    break;
                case SORT:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to sort!");
                    } else {
                        employees = Sorter.mergeSort(employees);
                        System.out.println("Employees sorted alphabetically! First 20:");
                        for (int i = 0; i < Math.min(20, employees.size()); i++) {
                            System.out.println((i + 1) + ". " + employees.get(i));
                        }
                    }
                    break;
                    
                case SEARCH:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to search!");
                    } else {
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter the name to search: ");
                        String searchName = scanner.nextLine().trim();

                        // list must be sorted for binary search!
                        employees = Sorter.mergeSort(employees);

                        long start = System.nanoTime();
                        int index = Searcher.binarySearchRecursive(employees, searchName, 0, employees.size() - 1);
                        long end = System.nanoTime();

                        System.out.println("Search took " + (end - start) + " ns");

                        if (index != -1) {
                            System.out.println("Employee found: " + employees.get(index));
                        } else {
                            System.out.println("Employee not found.");
                        }
                    }
                    break;
                case GENERATE_RANDOM:
                    
                    RandomDataGenerator.generate(employees);
                    System.out.println("Random hospital employees generated!");
                    break;
                case LOAD_FROM_FILE:
                    System.out.print("Enter the filename to load (e.g., Applicants_Form.txt): ");
                    scanner.nextLine(); // consume newline
                    String fileName = scanner.nextLine().trim();
                    FileLoader.loadFromFile(fileName, employees);
                    employees = Sorter.mergeSort(employees); // 👈 Automatically sort after loading!
                    break;
    
                    


                case EXIT:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("This option will be added soon!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        for (int i = 0; i < MenuOption.values().length; i++) {
            System.out.println((i + 1) + ". " + MenuOption.values()[i]);
        }
    }

    private static int getIntInput(String message, int min, int max) {
        int input;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Try again: ");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }

    private static void addEmployee() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Select Manager Type:");
        for (int i = 0; i < ManagerType.values().length; i++) {
            System.out.println((i + 1) + ". " + ManagerType.values()[i]);
        }
        int managerChoice = getIntInput("Choice: ", 1, ManagerType.values().length);
        ManagerType managerType = ManagerType.values()[managerChoice - 1];

        System.out.println("Select Department:");
        for (int i = 0; i < Department.values().length; i++) {
            System.out.println((i + 1) + ". " + Department.values()[i]);
        }
        int deptChoice = getIntInput("Choice: ", 1, Department.values().length);
        Department department = Department.values()[deptChoice - 1];

        Employee newEmp = new Employee(name, managerType, department);
        employees.add(newEmp);

        System.out.println("\n" + name + " has been added as " + managerType + " in the " + department + " department.");
    }
}

    
    

