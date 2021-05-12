/**
 * @author: haiqing.teng
 * @since: 2021/5/7 15:38
 */
package Base;

import Util.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CaseBase extends WebLibBase{
    public CaseBase(){};
    public CaseBase(WebDriver driver) {
        super(driver);
    }
    protected Map<String,Object> paramMap = new HashMap<>();

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = Browser.getBrowserDriver();
        logger.info("已经拿到driver");
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.imooc.com");
        findAndWaitElement(By.id("js-signin-btn")).click();
    }

    /**
     * case中执行入口
     */
    public void run(){
        //读取文件
        String fileName = Reporter.getCurrentTestResult().getMethod().getMethodName()+"_p.xls";
        List<Map<String,Object>> paramList = new ArrayList<>();
        try {
            paramList = ExcelUtil.getParameter(fileName);
        } catch (IOException e) {
            System.out.println("获取配置文件出错");
        }
        for(int i = 0;i<paramList.size();i++){
            try{
                paramMap = paramList.get(i);
                System.out.println("执行第"+(i+1)+"行数据。。。。。。。。。。。。。。。。。。。。。。。。。");
                body();
            }catch (Exception e){
                System.out.println("运行出错");
            }finally {
                if(i<paramList.size()-1){
                    teardown();
                    setup();
                }
            }

        }

    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }

    protected abstract void body()throws Exception;
}
