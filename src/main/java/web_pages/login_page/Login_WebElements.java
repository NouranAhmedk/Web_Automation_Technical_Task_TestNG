package web_pages.login_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Login_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS**************************************************/
    public Login_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(id = "email")
    public WebElement email_Address_Txt;

    @FindBy(id = "pass")
    public WebElement password_Txt;

    @FindBy(id = "send2")
    public WebElement login_btn;

    @FindBy(xpath = "//h1['My Dashboard']")
    public WebElement my_dashboard_header;

    @FindBy(xpath = "//span[text()='Invalid login or password.']")
    WebElement login_Failed_Msg;
}
