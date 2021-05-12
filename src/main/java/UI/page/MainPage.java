/**
 * @author: haiqing.teng
 * @since: 2021/5/7 17:20
 */
package UI.page;

import Base.WebLibBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends WebLibBase {
    public MainPage(WebDriver driver){
        super(driver);
    }
    public WebElement loginBtn(){
        return findAndWaitElement(By.id("js-signin-btn"));
    }
}
