package hospitalstaffmanager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.util.Random;
/**
 *
 * @author maryl
 */
public class RandomDataGenerator {
    
    private static final String[] FIRST_NAMES = {
        "John", "Emma", "Liam", "Olivia", "Noah", "Ava",
        "Elijah", "Sophia", "William", "Mia",
        "James", "Charlotte", "Lucas", "Isabella", "Henry", "Evelyn"
    };
    //Ramdom names
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Brown", "Taylor", "Anderson",
        "White", "Martin", "Lee", "Walker", "Hall"
    };

    public static void generate(List<Employee> employees) {
        Random rand = new Random();
        int count = 10; // How many random employees to add

        for (int i = 0; i < count; i++) {
            String fullName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)] + " " +
                              LAST_NAMES[rand.nextInt(LAST_NAMES.length)];

            ManagerType managerType = ManagerType.values()[rand.nextInt(ManagerType.values().length)];
            Department department = Department.values()[rand.nextInt(Department.values().length)];

            employees.add(new Employee(fullName, managerType, department));
        }
    }
}


