package web_pages.home_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Home_WebElements extends Page_Base {
    /****************************************CONSTRUCTORS*********************************************/
    public Home_WebElements(WebDriver driver) {
        super(driver);
    }
    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(xpath = "//a/span[text()=\"Account\"]")
    WebElement account_DDL;

    @FindBy(css= "a[title='Register']")
    WebElement register_Li;

    @FindBy(css= "a[title='Log In']")
    WebElement login_Li;

}
