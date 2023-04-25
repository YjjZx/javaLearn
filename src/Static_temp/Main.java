package Static_temp;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.increment();
        c1.increment();

        c2.increment();

        System.out.println("c1 count: " + c1.getCount()); // 输出 2
        System.out.println("c2 count: " + c2.getCount()); // 输出 1
        System.out.println("static count: " + Counter.getStaticCount()); // 输出 3
    }

}

