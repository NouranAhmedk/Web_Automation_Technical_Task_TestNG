package web_pages.dashboard_page;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class Dashboard_Actions extends Dashboard_WebElements {
    /*****************************************CONSTRUCTORS**************************************************/
    public Dashboard_Actions(WebDriver driver) {
        super(driver);
    }
    /******************************************ACTIONS*****************************************************/
    @Step("Hover on \"Accessories\" DDl")
    public void hover_On_Accessories_DDl()
    {
        hover_WebElement(accessories_DDl);
    }

    @Step("Clicks \"Shoes\" list item")
    public void click_Shoes_Li()
    {
        clickWebElement(shoes_Li);
    }

    @Step("Clicks \"Logout\" list item")
    public void click_Logout_Li()
    {
        clickWebElement(logout_Li);
    }

    /******************************************ASSERTIONS*********************************************/
    public void validate_Successful_Login() {
        assert_WebElement_Is_Displayed(my_dashboard_header,
                "The display of the header which indicate redirect to dashboard page, confirming validation");
    }

    public void validate_Successful_Registration_Msg() {
        assert_WebElement_Is_Displayed(registration_Success_Msg,
                "The success message for registration appears, confirming validation");
    }

    public void validate_Correct_Redirect_Dashboard(String expected_URL) {
        assert_Redirection_To_Correct_Page(expected_URL, "The correct redirect to dashboard page validation");

    }

    public void validate_Correct_Redirect_Logout(String expected_URL) {
        assert_Redirection_To_Correct_Page(expected_URL,
                "The correct redirect to Logout page validation");
    }

    public void validate_Correct_Redirect_Home(String expected_URL) {
        assert_Redirection_To_Correct_Page(expected_URL,
                "The correct redirect to home page validation");
    }

}
