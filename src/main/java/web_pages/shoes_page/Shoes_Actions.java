package web_pages.shoes_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Shoes_Actions extends Shoes_WebElements {

    /*****************************************CONSTRUCTORS**************************************************/
    public Shoes_Actions(WebDriver driver) {
        super(driver);
    }
    /*****************************************ACTIONS***********************************************/
    @Step("Clicks Sort By dropdown")
    public void click_Sort_By_DDL(){
        clickWebElement(sort_By_DDL);
    }

    @Step("Select price option")
    public void select_Price_Option(){
        clickWebElement(price_Opt);
    }

    @Step("Clicks Hana Flat shoes details page")
    public void click_Hana_Flat_Shoes_Details_Page(){
        clickWebElement(hana_Shoes_Details_Page);
    }

    /******************************************ASSERTIONS*********************************************/
    public void assert_Ascending_Order_Price() {
        assert_Ascending_Order_For_Items(before_Filter_Items_Price,after_Filter_Items_Price,"Invalid Ascending order");
    }
}
