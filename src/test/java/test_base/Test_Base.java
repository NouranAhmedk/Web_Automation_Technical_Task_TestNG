package test_base;

import data_reader.Load_Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public abstract class Test_Base {

    /************************************OBJECTS_DECLARATIONS/INSTANTIATIONS*****************************/
    protected WebDriver driver;

    /*****************************************ENVIRONMENT_DATA***********************************************/
    private final String url = Load_Properties.environment_Data.getProperty("URL");
    private final String browser = Load_Properties.environment_Data.getProperty("browser");

    /***********************************************METHODS**************************************************/

    @Parameters({"browser"})
    @BeforeMethod(groups = {"Regression","Smoke"})
    public void setUp_Environment()
    {
        switch (browser)
        {
            case "chrome" : driver = new ChromeDriver();break;
            case "firefox" : driver = new FirefoxDriver();break;
            case "edge" : driver = new EdgeDriver();break;
            default : driver = new ChromeDriver(); break;
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod(groups = {"Regression","Smoke"})
    public void clearUp_Environment()
    {
        driver.quit();
    }
}
