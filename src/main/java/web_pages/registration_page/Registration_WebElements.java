package web_pages.registration_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Registration_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS*******************************************/
    public Registration_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(id = "firstname")
    WebElement firstName_Txt;

    @FindBy(id = "middlename")
    WebElement middleName_Txt;

    @FindBy(id = "lastname")
    WebElement lastName_Txt;

    @FindBy(id = "email_address")
    WebElement email_Address_Txt;

    @FindBy(id = "password")
    WebElement password_Txt;

    @FindBy(id = "confirmation")
    WebElement confirm_Password_Txt;

    @FindBy(xpath = "//span[text()='Register']")
    WebElement registration_Btn;

    @FindBy(xpath = "//span[text()='Thank you for registering with Tealium Ecommerce.']")
    WebElement registration_Success_Msg;

    @FindBy(id = "advice-required-entry-firstname")
    WebElement advice_Required_FirstName_Txt;

    @FindBy(id = "advice-required-entry-lastname")
    WebElement advice_Required_LastName_Txt;

    @FindBy(id = "advice-required-entry-email_address")
    WebElement advice_Required_Email_Txt;

    @FindBy(id = "advice-required-entry-password")
    WebElement advice_Required_Password_Txt;

    @FindBy(id = "advice-required-entry-confirmation")
    WebElement advice_Required_Confirm_Password_Txt;

    @FindBy(id = "advice-validate-password-password")
    WebElement advice_Valid_Password_Character_Length_Txt;

    @FindBy(id ="advice-validate-cpassword-confirmation")
    WebElement advice_Valid_Confirm_Password_Txt;
}
