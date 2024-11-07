package tests.login;

import com.github.javafaker.Faker;
import data_reader.Load_Properties;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import listeners.ITestListener_Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_base.Login_Test_Base;
import web_pages.dashboard_page.Dashboard_Actions;
import web_pages.home_page.Home_Actions;
import web_pages.login_page.Login_Actions;

@Listeners(ITestListener_Listener.class)
public class Login_Test extends Login_Test_Base {
    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*******************************************/
    private Home_Actions ha;
    private Login_Actions la;
    private Dashboard_Actions da;
    private Faker fake_Data = new Faker();

    /***********************************************TEST_DATA**********************************************************/

    private final String email_address = Load_Properties.login_Data.getProperty("Email_Address");
    private final String invalid_Email_address = String.valueOf(fake_Data.internet().emailAddress());
    private final String password = Load_Properties.login_Data.getProperty("Password");
    private final String dashboard_URL = Load_Properties.environment_Data.getProperty("Dashboard_URL");

    /************************************************TEST_CASES********************************************************/
    @Owner("Nouran Ahmed")
    @Link(name = "Home_Login : Verify that the user can login by entering valid credentials")
    @Test(groups ={"Regression","Smoke"})
    public void login_With_Valid_Data() {

        ha = new Home_Actions(driver);
        la = new Login_Actions(driver);
        da = new Dashboard_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Login_Li();
        la.enter_Email(email_address);
        la.enter_Password(password);
        la.click_Login_btn();
        da.validate_Correct_Redirect_Dashboard(dashboard_URL);
        da.validate_Successful_Login();
    }

    @Owner("Nouran Ahmed")
    @Test(testName = "Home_Login : Verify that the user can not login by entering invalid credentials", groups = "Smoke")
    public void login_With_Invalid_Data() {

        ha = new Home_Actions(driver);
        la = new Login_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Login_Li();
        la.enter_Email(invalid_Email_address);
        la.enter_Password(password);
        la.click_Login_btn();
        la.validate_Failed_Login();
    }
}
