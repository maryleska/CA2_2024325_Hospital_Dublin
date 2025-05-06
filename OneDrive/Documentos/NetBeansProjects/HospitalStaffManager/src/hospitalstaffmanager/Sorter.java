/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalstaffmanager;
 import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maryl
 */
public class Sorter {
   
    public static List<Employee> mergeSort(List<Employee> employees) {
        if (employees.size() <= 1) {
            return employees;
        }

        int mid = employees.size() / 2;
        List<Employee> left = mergeSort(employees.subList(0, mid));
        List<Employee> right = mergeSort(employees.subList(mid, employees.size()));

        return merge(left, right);
    }

    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}


