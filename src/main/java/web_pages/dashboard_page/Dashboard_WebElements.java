package web_pages.dashboard_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Dashboard_WebElements extends Page_Base {
    /*****************************************CONSTRUCTORS**************************************************/
    public Dashboard_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(xpath = "//ol/li/a[text()='Accessories']")
    WebElement accessories_DDl;

    @FindBy(css = "a[href='https://ecommerce.tealiumdemo.com/accessories/shoes.html']")
    WebElement shoes_Li;

    @FindBy(xpath = "//h1['My Dashboard']")
    public WebElement my_dashboard_header;

    @FindBy(xpath = "//span[text()='Thank you for registering with Tealium Ecommerce.']")
    WebElement registration_Success_Msg;
}
