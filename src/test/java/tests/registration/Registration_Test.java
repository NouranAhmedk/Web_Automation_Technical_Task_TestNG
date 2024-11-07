package tests.registration;


import com.github.javafaker.Faker;
import data_reader.Load_Properties;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import listeners.ITestListener_Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_base.Registration_Test_Base;
import web_pages.dashboard_page.Dashboard_Actions;
import web_pages.home_page.Home_Actions;
import web_pages.registration_page.Registration_Actions;

import static data_writer.TestData_Writer.write_Generated_Data;

@Listeners(ITestListener_Listener.class)
public class Registration_Test extends Registration_Test_Base {

    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*******************************************/
    private Home_Actions ha;
    private Registration_Actions ra;
    private Dashboard_Actions da;
    private Faker fake_Data = new Faker();

    /***********************************************TEST_DATA**********************************************************/

    private final String firstName = fake_Data.name().firstName();
    private final String middleName = fake_Data.name().name();
    private final String lastName = fake_Data.name().lastName();
    private final String email_Address = write_Generated_Data("src/test/resources/Properties/Login.properties",
            "Email_Address", String.valueOf(fake_Data.internet().emailAddress()));
    private final String password =  write_Generated_Data("src/test/resources/Properties/Login.properties",
            "Password",fake_Data.numerify("#######"));
    private final String invalid_Password = fake_Data.numerify("#####");
    private final String dashboard_Redirect = Load_Properties.environment_Data.getProperty("Successful_Registration_Dashboard_URL");

    /************************************************TEST_CASES********************************************************/
    @Owner("Nouran Ahmed")
    @Link(name = "Home_Register : Verify that the user can register successfully by entering valid data")
    @Test(groups = {"Regression","Smoke"})
    public void registration_With_Valid_Data() {

        ha = new Home_Actions(driver);
        ra = new Registration_Actions(driver);
        da = new Dashboard_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Register_Li();
        ra.enter_First_Name(firstName);
        ra.enter_Middle_Name(middleName);
        ra.enter_Last_Name(lastName);
        ra.enter_email(email_Address);
        ra.enter_password(password);
        ra.enter_confirm_password(password);
        ra.click_Register_Btn();
        da.validate_Correct_Redirect_Dashboard(dashboard_Redirect);
        da.validate_Successful_Registration_Msg();
    }

    @Owner("Nouran Ahmed")
    @Test( testName = "Home_Register : Verify that the user can not register by entering invalid data",
            groups = "Smoke")
    public void registration_With_Invalid_Data() {

        ha = new Home_Actions(driver);
        ra = new Registration_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Register_Li();
        ra.click_Register_Btn();
        ra.validate_Failed_Registration();
    }

    @Owner("Nouran Ahmed")
    @Test(testName = "Home_Register: Verify that a validation message appears when the user enters a password that is less than 7 characters long."
            ,groups = "Smoke")
    public void registration_With_Invalid_Password_Length() {

        ha = new Home_Actions(driver);
        ra = new Registration_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Register_Li();
        ra.enter_First_Name(firstName);
        ra.enter_Middle_Name(middleName);
        ra.enter_Last_Name(lastName);
        ra.enter_email(email_Address);
        ra.enter_password(invalid_Password);
        ra.enter_confirm_password(invalid_Password);
        ra.click_Register_Btn();
        ra.validate_Password_Length();
    }


}
