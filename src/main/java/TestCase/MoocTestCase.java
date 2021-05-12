/**
 * @author: haiqing.teng
 * @since: 2021/5/7 15:44
 */
package TestCase;

import Base.CaseBase;
import UI.page.LoginController;
import UI.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoocTestCase extends CaseBase {
    @Test
    public void moocTestCase() throws InterruptedException {
        run();
    }

    @Override
    protected void body() throws Exception{
        String username = (String) paramMap.get("用户名");
        String password = (String) paramMap.get("密码");
        MainPage mainPage = new MainPage(driver);
        mainPage.loginBtn().click();
        LoginController loginController = new LoginController(driver);
        loginController.login(username,password);
    }
}
