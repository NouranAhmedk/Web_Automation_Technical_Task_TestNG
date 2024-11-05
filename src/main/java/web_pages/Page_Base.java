    package web_pages;

    import lombok.SneakyThrows;
    import org.openqa.selenium.*;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.io.FileHandler;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;

    import java.io.File;
    import java.time.Duration;

    /**
     * @author Nouran_Ahmed
     * <li>1) This class is where I declare an object (WebDriver data-type) that will have the same value of the object created in the TestBase.
     * <li>2) This class will have all the common web-elements that can be displayed between all webpages such as nav-menu.
     * <li>3) This class will have all the common methods that can be used by all other classes in pagesActions package.
     */

    public class Page_Base {
        /*****************************************OBJECTS_DECLARATIONS******************************************/
        protected WebDriver driver;
        private Actions action;
        private JavascriptExecutor js;
        private WebDriverWait wait;

        /*****************************************CONSTRUCTORS**************************************************/
        public Page_Base(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        /*****************************************USER_ACTIONS**************************************************/
        /**
         * @author Nouran_Ahmed
         * <li>1) This method keeps checking for the element visibility for 5 seconds.
         * <li>2) If visible, the webpage will be scrolled to the target webElement, and will have background-color as green &
         * borders as black.
         * <li>3) try code; click on the element exactly as shown on the UI (if there's overlay, won't be clicked).
         * <li>4) catch code; Click on the element from the DOM, thus even if the element is covered by an overlay but already
         * exists in the DOM, then it will be clicked.
         *
         * @param ele the target WebElement
         */
        protected void clickWebElement(WebElement ele) {
            try {
                wait_Element_Visibility(15, ele);
            } catch (Exception e) {
                wait_Invisible_Element(2, ele);
                System.out.println(ele.getAccessibleName() + ": is invisible ");
            }
            scrollTo_Highlight(ele, "green");

            try {
                ele.click();
            } catch (Exception e) {
                js_Click(ele);
                System.out.println("JS click has been used on: " + ele.getAccessibleName());
            }
        }

        /**
         * <li>1) This method keeps checking for the element visibility for 5 seconds.
         * <li>2) If visible, the webpage will be scrolled to the target webElement, and will have background-color as yellow &
         * borders as black.
         * <li>3) Send text to the Target WebElement.
         *
         * @param ele  the target WebElement
         * @param text the text that shall be written in the target webElement
         */
        protected void writeText(WebElement ele, String text) {
            wait_Element_Visibility(5, ele);
            scrollTo_Highlight(ele, "yellow");
            ele.sendKeys(text);
        }

        protected String getText(WebElement ele)
        {
            wait_Element_Visibility(10, ele);
            scrollTo_Highlight(ele,"yellow");
            return ele.getText();
        }
        /*****************************************LOCATING_ELEMENTS******************************************/
        /**
         * It's better using locators as parameters with ExpectedCondition class to wait upon,
         * they are more stable than web-elements, and in this method you can send locators extracted
         * by different selectors to this method
         * @param locator it must have "By" data-type because it carries value of By.Selector(xpath,cssSelect,id,etc..)
         * @return web-element object of data-type "WebElement" to interact with.
         */
        protected WebElement find_Element(By locator)
        {
            return driver.findElement(wait_Locator_Visibility(locator));
        }

        /*****************************************ASSISTIVE_METHODS**************************************************/
        protected void scrollTo_Highlight(WebElement ele, String color) {
            js_Scroll_View_Element_Center_With_Window(ele);
            js_Highlight_Element(ele, color);
        }

        /*****************************************ACTIONS_CLASS_METHODS***********************************************/
       @SneakyThrows
        protected void hover_WebElement(WebElement ele) {
           Thread.sleep(500);
            action = new Actions(driver);
            action.moveToElement(ele).perform();
        }

        protected void double_Click(WebElement ele) {
            action = new Actions(driver);
            action.doubleClick(ele).perform();
        }

        /*****************************************JS_INJECTION**************************************************/
        protected void js_Click(WebElement ele) {
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].focus()", ele);
            js.executeScript("arguments[0].click()", ele);
        }

        protected void js_Highlight_Element(WebElement ele, String color) {
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.background = '" + color + "'", ele);
            js.executeScript("arguments[0].style.border='2px solid red'", ele);
        }

        protected void js_Scroll_View_Element_Center_With_Window(WebElement ele) {
            js = (JavascriptExecutor) driver;

            Point coordinates = ele.getLocation();
            int x = coordinates.getX();
            int y = coordinates.getY();

            Dimension dims = driver.manage().window().getSize();
            int windowWidth = dims.getWidth();
            int windowHeight = dims.getHeight();

            js.executeScript("window.scrollTo(" + (x - windowWidth / 2) + "," + (y - windowHeight / 2) + ");");
        }


        /*****************************************EXPLICIT_WAIT**************************************************/
        protected void wait_Element_Visibility(int seconds, WebElement ele) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(ele));
        }

        protected void wait_Invisible_Element(int seconds, WebElement ele) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }

        protected void wait_Element_Clickable(int seconds, WebElement ele) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }

        protected By wait_Locator_Visibility(By locator)
        {
            wait = new WebDriverWait(driver,Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return locator;
        }

        /***********************************************COMMON_ASSERTIONS*****************************************/
        protected void assert_Actual_Text_Contains_Expected_Text(WebElement ele1, WebElement ele2, String assertion_Message)
        {
            String expected_Result = getText(ele1);
            String actual_Result = getText(ele2);
            Assert.assertTrue(actual_Result.contains(expected_Result),assertion_Message);
        }
        protected void assert_Actual_Text_Contains_Expected_Text(String text, WebElement ele, String assertion_Message)
        {
            String actual_Result = getText(ele);
            Assert.assertTrue(actual_Result.contains(text),assertion_Message);
        }
        protected void assert_Actual_Text_contains_Expected_Text(By locator1, By locator2, String assertion_Message)
        {
            String expected_Result = getText(find_Element(locator1));
            String actual_Result = getText(find_Element(locator2));
            Assert.assertTrue(actual_Result.contains(expected_Result),assertion_Message);
        }
        protected void assert_Actual_Text_Contains_Expected_Text(String text, By locator, String assertion_Message)
        {
            String actual_Result = getText(find_Element(locator));
            Assert.assertTrue(actual_Result.contains(text),assertion_Message);
        }
        protected void assert_WebElement_Is_Displayed(WebElement ele, String assertion_Message)
        {
            wait_Element_Visibility(5,ele);
            Assert.assertTrue(ele.isDisplayed(),assertion_Message);
        }

        @SneakyThrows
        protected void assert_Redirection_To_Correct_Page(String expected_Result, String assertion_Message)
        {
            Thread.sleep(500);
            String actual_Result = driver.getCurrentUrl();
            Assert.assertEquals(actual_Result,expected_Result,assertion_Message);
        }

        /*****************************************SCREENSHOTS_INTERFACE***********************************************/
        /**
         * <p>This method is designed to capture a screenshot of the current state of a web page [Pass/Fail]
         * and save it to a specified directory.</p>
         * <li> This method is not needed as We handled Screenshot in  ITestListener_Listener class </li>
         */
        @SneakyThrows
        public void capture_Screenshot(String pass_Or_Fail_Dir) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File("Screenshots/"+ pass_Or_Fail_Dir +".png");
            FileHandler.copy(source, destination);
        }

    }