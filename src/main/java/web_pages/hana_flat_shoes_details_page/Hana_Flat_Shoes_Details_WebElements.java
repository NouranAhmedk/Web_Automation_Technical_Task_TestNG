package web_pages.hana_flat_shoes_details_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_pages.Page_Base;

public class Hana_Flat_Shoes_Details_WebElements extends Page_Base {
    /*****************************************CONSTRUCTORS**************************************************/
    public Hana_Flat_Shoes_Details_WebElements(WebDriver driver) {
        super(driver);
    }

    /****************************************WEB-ELEMENTS*********************************************/
    /**
     * Names-Suffix Notes:
     * <li>1) Txt:TextBox; 2) Link:WebLink; 3) Btn:Button; 4) Li:ListItem;
     * <li>5) Msg:Message; 6) DDL:DropDownList; 7) Opt:Option; 8) Chbox:CheckBox;
     * <li>9) Rdo:RadioButton; 10) TxtArea:TextArea;
     */
    @FindBy(id = "swatch17")
    WebElement shoe_Color;

    @FindBy(id = "swatch102")
    WebElement shoe_Size_6;

    @FindBy(className = "add-to-cart-buttons")
    WebElement add_To_Cart_Btn;

    @FindBy(xpath = "//span[text()='Hana Flat, Charcoal was added to your shopping cart.']")
    WebElement add_To_Card_Msg;

}

