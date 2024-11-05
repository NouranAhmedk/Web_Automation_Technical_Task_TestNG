package web_pages.registration_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Registration_Actions extends Registration_WebElements {

    /*****************************************CONSTRUCTORS*******************************************/
    public Registration_Actions(WebDriver driver) {
        super(driver);
    }

    /*****************************************ACTIONS***********************************************/
    @Step("Enter First Name")
    public void enter_First_Name(String firstName) {
        writeText(firstName_Txt, firstName);
    }

    @Step("Enters Middle Name")
    public void enter_Middle_Name(String middleName) {
        writeText(middleName_Txt, middleName);
    }

    @Step("Enter Last Name")
    public void enter_Last_Name(String lastName) {
        writeText(lastName_Txt, lastName);
    }

    @Step("Enter Email Address")
    public void enter_email(String email_Address) {
        writeText(email_Address_Txt, email_Address);
    }

    @Step("Enter Password")
    public void enter_password(String password) {
        writeText(password_Txt, password);
    }

    @Step("Enter Confirm Password")
    public void enter_confirm_password(String confirm_password) {
        writeText(confirm_Password_Txt, confirm_password);
    }

    @Step("Clicks Register button")
    public void click_Register_Btn() {
        clickWebElement(registration_Btn);
    }

    /******************************************ASSERTIONS*********************************************/
    public void validate_Successful_Registration_Msg() {
        assert_WebElement_Is_Displayed(registration_Success_Msg,
                "The success message for registration appears, confirming validation");
    }

    public void validate_Failed_Registration() {
        assert_WebElement_Is_Displayed(advice_Required_FirstName_Txt,
                "The required 'First Name' msg appears");

        assert_WebElement_Is_Displayed(advice_Required_LastName_Txt,
                "The required 'Last Name' msg appears");

        assert_WebElement_Is_Displayed(advice_Required_Email_Txt,
                "The required 'Email Address' msg appears");

        assert_WebElement_Is_Displayed(advice_Required_Password_Txt,
                "The required 'Password' msg appears");

        assert_WebElement_Is_Displayed(advice_Required_Confirm_Password_Txt,
                "The required 'Confirm Password' msg appears");
    }

    public void validate_Password_Length(){
        assert_WebElement_Is_Displayed(advice_Valid_Password_Character_Length_Txt,
                "'Enter more characters or clean leading or trailing spaces' msg appears");
    }

}
