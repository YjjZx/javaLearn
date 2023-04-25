package Factory_Model;

public class taiShiComputer implements Computer {
    @Override
    public void showInfo() {
        System.out.println("这是个台式机电脑");
    }
}
