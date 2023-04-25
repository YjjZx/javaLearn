package Thread;

public class Main {
    public static void main(String[] args) {
        //自定义的 MyThread 类来继承 Thread 类并重写 run() 方法
        Thread thread1 = new Thread(new MyThread("Hello"));
        Thread thread2 = new Thread(new MyThread("World"));
        Thread thread3 = new Thread(new MyThread("yjj"));
        Thread thread4 = new Thread(new MyThread("zx"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
