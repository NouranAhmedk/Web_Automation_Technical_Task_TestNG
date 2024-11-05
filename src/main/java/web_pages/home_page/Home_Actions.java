package web_pages.home_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Home_Actions extends Home_WebElements{
    /****************************************CONSTRUCTORS*********************************************/
    public Home_Actions(WebDriver driver) {
        super(driver);
    }

    /******************************************ACTIONS**********************************************/
    @Step("Clicks Account DDL")
    public void click_Account_DDL()
    {
        clickWebElement(account_DDL);
    }

    @Step("Clicks Register list item")
    public void click_Register_Li()
    {
        clickWebElement(register_Li);
    }

    @Step("Clicks Login list item")
    public void click_Login_Li()
    {
        clickWebElement(login_Li);
    }

}
