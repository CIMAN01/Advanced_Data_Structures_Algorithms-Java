// Building Java Programs

public class IntListClient2 {


    public static void main(String[] args) {
//        LinkedIntList list2 = new LinkedIntList();
//        processList(list2);
        IntList list2 = new LinkedIntList();
        processList(list2);
    }

    public static void processList(IntList list) {
        list.add(18);
        list.add(27);
        list.add(93);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

}