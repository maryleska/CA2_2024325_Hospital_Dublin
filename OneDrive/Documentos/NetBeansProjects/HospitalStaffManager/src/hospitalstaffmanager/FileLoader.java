/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalstaffmanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
/**
 *
 * @author maryl
 */
public class FileLoader {
    
    public static void loadFromFile(String filename, List<Employee> employees) {
        Random rand = new Random();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 9) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String fullName = parts[0].trim() + " " + parts[1].trim();
                String deptStr = parts[5].trim().toUpperCase();

                Department dept = null;
                try {
                    dept = Department.valueOf(deptStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid department: " + deptStr + " on line: " + line);
                    continue;
                }

                ManagerType manager = ManagerType.values()[rand.nextInt(ManagerType.values().length)];

                Employee emp = new Employee(fullName, manager, dept);
                employees.add(emp);
            }

            System.out.println("Applicants loaded successfully from " + filename);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}


