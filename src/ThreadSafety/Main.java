package ThreadSafety;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        //使用了匿名内部类来实现 Runnable 接口
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        for (int i = 0; i < 100000; i++) {
        //            counter.increment();
        //        }
        //    }
        //})
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
// main 线程阻塞，等待t1 t2 线程执行完毕。

        t1.join();
        t2.join();

        System.out.println("Count: " + counter.getCount());
    }
}
