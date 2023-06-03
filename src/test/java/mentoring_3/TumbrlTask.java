package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class TumbrlTask {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.tumblr.com/");

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();
Thread.sleep(1000);

        WebElement continueEmail = driver.findElement(By.xpath("//button[contains(text(),'email')]"));
        continueEmail.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailField.sendKeys("sfjnsdjfncjdnjcf3211@gmail.com");
        WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next']//span[.='Next']"));
        nextBtn.click();
        Thread.sleep(1000);

        WebElement setPassword = driver.findElement(By.xpath("//input[@placeholder='Set a password']"));
        setPassword.sendKeys("123");
        Thread.sleep(1000);
        WebElement repeatPassword = driver.findElement(By.xpath("//input[@placeholder='Repeat password']"));
        repeatPassword.sendKeys("123");
        nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next']//span[.='Next']"));
        nextBtn.click();
        Thread.sleep(1000);

        WebElement errorMsg = driver.findElement(By.cssSelector(".a0A37.hAkP2"));
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(errorMsg),"The password must be at least 8 characters long.");

    }
}
