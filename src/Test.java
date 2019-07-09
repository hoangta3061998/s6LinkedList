public class Test {
    public static void main(String[] args) {
        MyList test = new MyList();
        test.addFirst(5);
        test.add(6);
        test.add(7);
        test.addFirst(1);
        test.remove(2);
        Object j = test.get(2);
        Object a = test.getFirst();
        Object b = test.getLast();
        int n = test.indexOf(1);
        boolean z = test.contains(1);
        test.add(1,9);
        test.print();
        System.out.println(j + "," + a + "," + b);
        System.out.println(n);
        System.out.println(z);
    }
}
