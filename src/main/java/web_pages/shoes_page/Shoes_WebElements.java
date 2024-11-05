package web_pages.shoes_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Shoes_WebElements extends Page_Base {

    /*****************************************CONSTRUCTORS**************************************************/
    public Shoes_WebElements(WebDriver driver) {
        super(driver);
    }
    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(xpath = "//select[@title='Sort By'][preceding::div[@class='toolbar']]")
    WebElement sort_By_DDL;

    @FindBy(xpath = "//select[@title='Sort By']/option[contains(text(), 'Price')][preceding::div[@class='toolbar']]")
    WebElement price_Opt;

    @FindBy(css = "a[href='https://ecommerce.tealiumdemo.com/accessories/shoes/hana-flat-charcoal-557.html']")
    WebElement hana_Shoes_Details_Page;

}
