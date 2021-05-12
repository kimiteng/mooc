/**
 * @author: haiqing.teng
 * @since: 2021/5/7 17:31
 */
package UI.page;

import Base.WebLibBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginController extends WebLibBase {
    public LoginController(WebDriver driver){
        super(driver);
    }

    public WebElement usernameTxt(){
        return findAndWaitElement(By.name("email"));
    }
    public WebElement passwordTxt(){
        return findAndWaitElement(By.name("password"));
    }

    public WebElement loginBtn(){
        return findAndWaitElement(By.xpath("//form[@id='signup-form']//div[@class='rlf-group clearfix']//input"));
    }

    public String errorMsgTxt(){
        return findAndWaitElement(By.id("signin-globle-error")).getText();
    }

    public void login(String username,String password){
        logger.info("执行登录操作，用户名["+username+"]"+",密码["+password+"]");
        waitElementDisplayed(usernameTxt());
        usernameTxt().clear();
        usernameTxt().sendKeys(username);
        waitElementAttributeEqualsText(usernameTxt(),"value",username);
        waitElementDisplayed(passwordTxt());
        passwordTxt().clear();
        passwordTxt().sendKeys(password);
        waitElementDisplayed(loginBtn());
        loginBtn().click();

    }
}
