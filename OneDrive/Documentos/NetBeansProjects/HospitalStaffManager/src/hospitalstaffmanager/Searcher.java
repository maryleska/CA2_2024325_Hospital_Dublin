/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalstaffmanager;
 import java.util.List;
/**
 *
 * @author maryl
 */
public class Searcher {
   
    public static int binarySearchRecursive(List<Employee> list, String key, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        String midName = list.get(mid).getName();

        int compare = midName.compareToIgnoreCase(key);

        if (compare == 0) {
            return mid;
        } else if (compare > 0) {
            return binarySearchRecursive(list, key, start, mid - 1);
        } else {
            return binarySearchRecursive(list, key, mid + 1, end);
        }
    }

    public static int binarySearchNonRecursive(List<Employee> list, String key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            String midName = list.get(mid).getName();

            int compare = midName.compareToIgnoreCase(key);

            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}


