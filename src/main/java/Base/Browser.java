/**
 * @author: haiqing.teng
 * @since: 2021/5/7 11:31
 */
package Base;

import Util.PathUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;


public class Browser {
    protected static Logger logger = LogManager.getLogger();
    private static  String driverPath = PathUtil.getProjectPath()+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"webDriver";
    /**
     * 根据配置文件获取driver
     */
    public static WebDriver getBrowserDriver(){
//        System.setProperty("webdriver.chrome.driver",driverPath+File.separator+"chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",driverPath+File.separator+"chromedriver.exe");
        logger.info(driverPath+File.separator+"chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void main(String[] args) {
        getBrowserDriver();

    }
}
