// Data Structures and Algorithms Deep Dive Using Java

public class EmployeeMain {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        EmployeeDoublyLinkedList list2 = new EmployeeDoublyLinkedList();

        list2.addToFront(janeJones);
        list2.addToFront(johnDoe);
        list2.addToFront(marySmith);
        list2.addToFront(mikeWilson);

        list2.printList();
        System.out.println(list2.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list2.addToEnd(billEnd);
        list2.printList();
        System.out.println(list2.getSize());
        list2.removeFromFront();
        list2.printList();
        System.out.println(list2.getSize());
        list2.removeFromEnd();
        list2.printList();
        System.out.println(list2.getSize());

    }

}
