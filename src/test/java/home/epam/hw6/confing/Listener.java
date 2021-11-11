package home.epam.hw6.confing;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult itestResult) {
        WebDriver driver = (WebDriver) itestResult.getTestContext().getAttribute("driver");
        attachScreenshot(driver);
        System.out.println("screen");
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
