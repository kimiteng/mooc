/**
 * @author: haiqing.teng
 * @since: 2021/5/7 11:31
 */
package Base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLibBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = LogManager.getLogger();
    public WebLibBase(){};
    public WebLibBase(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    /**
     * 指定时间内查找元素，默认60秒
     * @param by
     * @return
     */
    public WebElement findAndWaitElement(By by){
        return wait.until((ExpectedCondition<WebElement>) d->d.findElement(by));
    }

    public boolean waitElementAttributeEqualsText(WebElement element,String attribute,String text){
        boolean flag;
        try {
            flag = wait.until((ExpectedCondition<Boolean>) d -> element.getAttribute(attribute).equals(text));
        } catch (Exception e) {
            logger.error(String.format("属性值[%s]与期望值[%s]不符",element.getAttribute(attribute),text));
            throw e;
        }
        return flag;
    }

    /*
    *指定时间内是否显示元素
    * */
    public boolean waitElementDisplayed(WebElement element){
        return wait.until((ExpectedCondition<Boolean>) d-> element.isDisplayed());

    }
}
