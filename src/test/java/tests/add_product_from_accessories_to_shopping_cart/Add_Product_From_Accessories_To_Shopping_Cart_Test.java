package tests.add_product_from_accessories_to_shopping_cart;

import data_reader.Load_Properties;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import listeners.ITestListener_Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_base.Add_Product_From_Accessories_To_Shopping_Cart_Test_Base;
import web_pages.dashboard_page.Dashboard_Actions;
import web_pages.hana_flat_shoes_details_page.Hana_Flat_Shoes_Details_Actions;
import web_pages.home_page.Home_Actions;
import web_pages.login_page.Login_Actions;
import web_pages.shoes_page.Shoes_Actions;

@Listeners(ITestListener_Listener.class)
public class Add_Product_From_Accessories_To_Shopping_Cart_Test extends Add_Product_From_Accessories_To_Shopping_Cart_Test_Base {
    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*******************************************/
    private Home_Actions ha;
    private Login_Actions la;
    private Dashboard_Actions da;
    private Shoes_Actions sa;
    private Hana_Flat_Shoes_Details_Actions hfsda;

    /***********************************************TEST_DATA**********************************************************/

    private final String email_address = Load_Properties.login_Data.getProperty("Email_Address");
    private final String password = Load_Properties.login_Data.getProperty("Password");
    private final String dashboard_URL = Load_Properties.environment_Data.getProperty("Dashboard_URL");

    /************************************************TEST_CASES********************************************************/
    @Owner("Nouran Ahmed")
    @Link(name = "Home_Login_Dashboard_Shoes_Card : Verify that the user can add a shoe product from the accessories to the shopping cart")
    @Test(groups = {"Regression"})
    public void add_Product_From_Accessories_To_Shopping_Cart() {

        ha = new Home_Actions(driver);
        la = new Login_Actions(driver);
        da = new Dashboard_Actions(driver);
        sa = new Shoes_Actions(driver);
        hfsda = new Hana_Flat_Shoes_Details_Actions(driver);
        ITestListener_Listener.driver = driver;

        ha.click_Account_DDL();
        ha.click_Login_Li();
        la.enter_Email(email_address);
        la.enter_Password(password);
        la.click_Login_btn();
        da.validate_Correct_Redirect_Dashboard(dashboard_URL);
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
