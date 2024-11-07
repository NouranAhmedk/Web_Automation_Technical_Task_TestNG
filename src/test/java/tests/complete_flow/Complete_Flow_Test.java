package tests.complete_flow;

import com.github.javafaker.Faker;
import data_reader.Load_Properties;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import listeners.ITestListener_Listener;
import org.testng.annotations.Test;
import test_base.Complete_Flow_Test_Base;
import web_pages.dashboard_page.Dashboard_Actions;
import web_pages.hana_flat_shoes_details_page.Hana_Flat_Shoes_Details_Actions;
import web_pages.home_page.Home_Actions;
import web_pages.login_page.Login_Actions;
import web_pages.registration_page.Registration_Actions;
import web_pages.shoes_page.Shoes_Actions;

import static data_writer.TestData_Writer.write_Generated_Data;

public class Complete_Flow_Test extends Complete_Flow_Test_Base {
    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*******************************************/
    private Home_Actions ha;
    private Registration_Actions ra;
    private Dashboard_Actions da;
    private Login_Actions la;
    private Shoes_Actions sa;
    private Hana_Flat_Shoes_Details_Actions hfsda;
    private Faker fake_Data = new Faker();

    /***********************************************TEST_DATA**********************************************************/

    private final String firstName = fake_Data.name().firstName();
    private final String middleName = fake_Data.name().name();
    private final String lastName = fake_Data.name().lastName();
    private final String email_Address = write_Generated_Data("src/test/resources/Properties/Login.properties",
            "Email_Address", String.valueOf(fake_Data.internet().emailAddress()));
    private final String password = write_Generated_Data("src/test/resources/Properties/Login.properties",
            "Password", fake_Data.numerify("#######"));
    private final String dashboard_Redirect = Load_Properties.environment_Data.getProperty("Successful_Registration_Dashboard_URL");
    private final String load_Email_Address = Load_Properties.login_Data.getProperty("Email_Address");
    private final String load_Password = Load_Properties.login_Data.getProperty("Password");
    private final String logout_Redirect = Load_Properties.environment_Data.getProperty("Successful_Logout_URL");
    private final String home_Redirect = Load_Properties.environment_Data.getProperty("URL");

    /************************************************TEST_CASES********************************************************/
    @Owner("Nouran Ahmed")
    @Link(name = "Home_Register_Login_Dashboard_Shoes_Card :  Verify that the user can register, then log out, and then log in." +
            "and add a shoe product from the accessories to the shopping cart")
    @Test(groups = {"Regression","Smoke"})
    public void validate_Complete_FLow() {

        ha = new Home_Actions(driver);
        ra = new Registration_Actions(driver);
        da = new Dashboard_Actions(driver);
        la = new Login_Actions(driver);
        sa = new Shoes_Actions(driver);
        hfsda = new Hana_Flat_Shoes_Details_Actions(driver);
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

        ha.click_Account_DDL();
        da.click_Logout_Li();
        da.validate_Correct_Redirect_Logout(logout_Redirect);
        da.validate_Correct_Redirect_Home(home_Redirect);

        ha.click_Account_DDL();
        ha.click_Login_Li();
        la.enter_Email(load_Email_Address);
        la.enter_Password(load_Password);
        la.click_Login_btn();
        da.validate_Successful_Login();

        da.hover_On_Accessories_DDl();
        da.click_Shoes_Li();
        sa.click_Sort_By_DDL();
        sa.select_Price_Option();
        sa.assert_Ascending_Order_Price();
        sa.click_Hana_Flat_Shoes_Details_Page();
        hfsda.choose_Shoe_Color();
        hfsda.select_Shoe_Size();
        hfsda.click_Add_To_Card();
        hfsda.validate_Add_To_Card_Msg();

    }
}
