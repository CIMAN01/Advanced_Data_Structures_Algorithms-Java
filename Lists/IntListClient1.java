// Building Java Programs

public class IntListClient1 {

    public static void main(String[] args) {
        LinkedIntList list2 = new LinkedIntList();
        list2.add(18);
        list2.add(27);
        list2.add(93);
        System.out.println(list2);
        list2.remove(1);
        System.out.println(list2);
    }

}