package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertsPractice {
    @Test
    public void testName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement jsAlerts = driver.findElement(By.linkText("Javascript Alerts"));
        jsAlerts.click();

            WebElement jsAlertBtn = driver.findElement(By.xpath("//p[contains(text(),'Alert')]//button[@type='button']"));
            jsAlertBtn.click();
        Thread.sleep(700);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(700);
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//p[contains(text(),'Confirm')]//button[@type='button']"));
        confirmAlertBtn.click();
        alert.dismiss();

 Thread.sleep(700);
        WebElement confirmMsg = driver.findElement(By.cssSelector("#confirm-demo"));
        Assert.assertEquals(BrowserUtils.getText(confirmMsg),"You pressed Cancel!");
        Thread.sleep(700);
        WebElement promptAlertBtn = driver.findElement(By.xpath("//p[contains(text(),'Prompt')]//button[@type='button']"));
        promptAlertBtn.click();
        Thread.sleep(700);
        alert.sendKeys("Nazar");
        Thread.sleep(700);
        alert.accept();
        Thread.sleep(700);

        WebElement promptText = driver.findElement(By.cssSelector("#prompt-demo"));
        Thread.sleep(700);
        Assert.assertEquals(BrowserUtils.getText(promptText),"You have entered 'Nazar' !");

    }
}
