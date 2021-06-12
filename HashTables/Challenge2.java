/*

Challenge:

Remove duplicate items from a Linked List using a HashMap

*/

import java.util.*;

public class Challenge2 {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        // use a HashMap as a solution
        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        // create an iterator to traverse the list
        ListIterator<Employee> iterator = employees.listIterator();
        // create another list to avoid an exception getting thrown when changing the list (cannot change the list while still iterating over the list)
        List<Employee> removeList = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            // if there already is an id in the hash table then we know we have a duplicate to remove
            if(employeeTable.containsKey(employee.getId())) {
                removeList.add(employee); // add employee to the list to be removed
            }
            else {
                // else add the new employee
                employeeTable.put(employee.getId(), employee);
            }
        }

        // actually remove the employee from the list
        for(Employee employee : removeList) {
            employees.remove(employee);
        }

        System.out.println("--------------------------");

        employees.forEach(e -> System.out.println(e));

//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }

}
