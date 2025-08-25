package logger;

import helpers.ElementHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoggerUtility {
    private static Logger logger = LogManager.getLogger();

    //start test
    public static void startTest(String testName){
        logger.info(Thread.currentThread().getName()+ "===== Execution started: "+testName+" =====");
    }
    //info step
    public static void infoLog(String message){
        logger.info(Thread.currentThread().getName()+" "+message);
    }
    //error step
    public static void errorLog(String message){
        logger.error(Thread.currentThread().getName()+" "+message);
    }
    //finish test
    public static void finishTest(String testName){
        logger.info(Thread.currentThread().getName()+ "===== Execution finished: "+testName+" =====");
    }
}
