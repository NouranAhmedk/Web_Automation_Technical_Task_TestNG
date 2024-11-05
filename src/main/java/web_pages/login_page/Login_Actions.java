package web_pages.login_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Actions extends Login_WebElements {
    /*****************************************CONSTRUCTORS*************************************************/
    public Login_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS*****************************************************/
    @Step("Enter email address")
    public void enter_Email(String email_address) {
        writeText(email_Address_Txt, email_address);
    }

    @Step("Enter password")
    public void enter_Password(String password) {
        writeText(password_Txt, password);
    }

    @Step("Clicks login button")
    public void click_Login_btn() {
        clickWebElement(login_btn);
    }

    /******************************************ASSERTIONS*********************************************/
    public void validate_Correct_Redirect_Dashboard(String expected_URL) {
        assert_Redirection_To_Correct_Page(expected_URL,
                "The correct redirect to dashboard page validation");
    }

    public void validate_Successful_Login() {
        assert_WebElement_Is_Displayed(my_dashboard_header,
                "The display of the header which indicate redirect to dashboard page, confirming validation");
    }

    public void validate_Failed_Login() {
        assert_WebElement_Is_Displayed(login_Failed_Msg,
                "The invalid message for Failed Login validation");
    }
}
