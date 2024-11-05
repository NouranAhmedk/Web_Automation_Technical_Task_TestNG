package web_pages.hana_flat_shoes_details_page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Hana_Flat_Shoes_Details_Actions extends Hana_Flat_Shoes_Details_WebElements {

    /*****************************************CONSTRUCTORS**************************************************/
    public Hana_Flat_Shoes_Details_Actions(WebDriver driver) {
        super(driver);
    }
    /*****************************************ACTIONS***********************************************/
    @Step("Choose shoe color")
    public void choose_Shoe_Color() {
        clickWebElement(shoe_Color);
    }

    @Step("Select shoe size : 6")
    public void select_Shoe_Size() {
        clickWebElement(shoe_Size_6);
    }

    @Step("click add to card")
    public void click_Add_To_Card() {
        clickWebElement(add_To_Cart_Btn);
    }

    /******************************************ASSERTIONS*********************************************/
    public void validate_Add_To_Card_Msg() {
        assert_WebElement_Is_Displayed(add_To_Card_Msg,
                "The success message for add to card appears, confirming validation");
    }
}
