public class TestDequeue {
    public static void main(String[] args) {
        Dequeue<String> sDequeue = new Dequeue<String>();

        System.out.printf("Is queue empty: %s%n", sDequeue.isEmpty());
        sDequeue.addFront("First");
        sDequeue.addFront("Second");
        sDequeue.addFront("Third");
        sDequeue.addBack("Fourth");
        System.out.printf("Is queue empty: %s%n", sDequeue.isEmpty());

        while (!sDequeue.isEmpty())
            System.out.printf("%s ", sDequeue.removeFront());

        System.out.printf("%nCurrent size: %s", sDequeue.size());
        sDequeue.addFront("Front");
        sDequeue.addBack("Middle");
        sDequeue.addBack("Back");
        System.out.printf("%n%s %s%nNew size: %s%n", sDequeue.peekFront(), sDequeue.peekBack(), sDequeue.size());

        Dequeue<Integer> iDequeue = new Dequeue<Integer>();

        System.out.printf("%nIs queue empty: %s", iDequeue.isEmpty());
        iDequeue.addFront(1);
        iDequeue.addFront(2);
        iDequeue.addBack(3);
        iDequeue.addBack(4);
        System.out.printf("%nIs queue empty: %s%n", iDequeue.isEmpty());

        while (!iDequeue.isEmpty())
            System.out.printf("%s ", iDequeue.removeFront());

        System.out.printf("%nCurrent size: %s%n", iDequeue.size());
        iDequeue.addFront(1);
        iDequeue.addBack(2);
        iDequeue.addBack(3);
        System.out.printf("%s %s%nNew Size: %s", iDequeue.peekFront(), iDequeue.peekBack(), iDequeue.size());
    }
}