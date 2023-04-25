package SigleModel;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        //程序开始
        logger.saveLogMessage("程序开始");

        for (int i = 0; i < 10; i++) {
            logger.saveLogMessage("程序执行:" + i);
        }

        //
        logger.saveLogMessage("程序结束");
    }
}
