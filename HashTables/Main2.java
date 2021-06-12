

public class Main2 {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ChainedHashtable hashtable = new ChainedHashtable();
        hashtable.put("Jones", janeJones);
        hashtable.put("Doe", johnDoe);
        hashtable.put("Wilson", mikeWilson);
        hashtable.put("Smith", marySmith);

        hashtable.printHashtable();

        System.out.println("Retrieve key Smith: " + hashtable.get("Smith"));

        hashtable.remove("Doe");
        hashtable.remove("Jones");
        hashtable.printHashtable();


    }
}
