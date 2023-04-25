package Static_temp;

public class Counter {
    private int count;//实例私有
    private static int staticCount;//属于类层次，只会加载一次。实例共有

    public Counter() {
        count = 0;
        staticCount = 0;
    }

    public void increment() {
        count++;
        staticCount++;
    }

    public int getCount() {
        return count;
    }

    public static int getStaticCount() {
        return staticCount;
    }

}
