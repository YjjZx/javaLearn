package Factory_Model;

public class ComputerFactory {
    public static Computer CreateComputer(String type) throws IllegalAccessException {
        if (type == "bijiben") {
            return new biJiBenComputer();
        } else if (type == "taishi") {
            return new taiShiComputer();
        } else if (type == "pingban") {
            return new pingBanComputer();
        } else {
            throw new IllegalAccessException("无效的电脑类型：" + type);
        }
    }
}
