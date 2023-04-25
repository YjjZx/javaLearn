package Factory_Model;

public class Main {
    /**
     * 1. 创建电脑接口 ，定义抽象方法
     * 2. 实现电脑接口，并完成自己功能
     * 3. 创建工厂类，用来创建管理所有的***电脑
     * 4. 利用工厂类，创建Computer 对象
     * 5. 多态。 父类 实例名 = new 子类。
     *    Com1 com2 com3 都是Computer类型，同一种类型，但是在运行是调用.showInfo()有多种形态。
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalAccessException {
        Computer com1 = ComputerFactory.CreateComputer("bijiben");
        Computer com2 = ComputerFactory.CreateComputer("taishi");
        Computer com3 = ComputerFactory.CreateComputer("pingban");
        com1.showInfo();
        com2.showInfo();
        com3.showInfo();
    }
}
