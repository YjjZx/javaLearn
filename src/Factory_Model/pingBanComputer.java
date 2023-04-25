package Factory_Model;

public class pingBanComputer implements Computer {
    @Override
    public void showInfo() {
        System.out.println("这是个平板电脑");
    }
}
