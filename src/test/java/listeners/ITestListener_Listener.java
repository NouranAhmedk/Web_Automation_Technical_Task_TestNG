package listeners;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ITestListener_Listener implements ITestListener {

    /********************************OBJECTS_DECLARATIONS/INSTANTIATIONS*************************************/
    public static WebDriver driver;


    /******************************METHODS_USED_IN_LISTENER_IMPLEMENTATIONS**********************************/
    @SneakyThrows
    private void takeScreenShot(String pass_Or_Fail_Dir_Path, String TC_Name, String ss_Extension) {

        LocalDateTime local_Date_Time = LocalDateTime.now();
        DateTimeFormatter date_Format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS");
        String date = date_Format.format(local_Date_Time);
        TakesScreenshot ss = (TakesScreenshot) driver;
        File sourceFile = ss.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("Screenshots/"+ pass_Or_Fail_Dir_Path +""+ TC_Name+ date + ss_Extension);
        FileUtils.copyFile(sourceFile,targetFile);
    }

    /********************************LISTENER_IMPLEMENTATIONS************************************************/
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test case has started");
    }
    @Override
    @SneakyThrows
    public void onTestSuccess(ITestResult result)
    {
        Thread.sleep(7000);
        takeScreenShot("PassedScreenshots/", result.getName(), ".png");
    }
    @Override
    @SneakyThrows
    public void onTestFailure(ITestResult result)
    {
        Thread.sleep(7000);
        takeScreenShot("FailedScreenshots/", result.getName(), ".png");
    }

}