package lambda_test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class Test1 {

  @Test()
   public void inputFormSubmit() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      driver.navigate().to("https://www.lambdatest.com/selenium-playground");
Thread.sleep(1000);
      WebElement inputFormSubmit = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
      inputFormSubmit.click();
      Thread.sleep(1000);
      WebElement name= driver.findElement(By.xpath("//input[@id='name']"));
      name.sendKeys("Nazar F");
      Thread.sleep(1000);
      WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
      email.sendKeys("nazar@gmail.com");
      Thread.sleep(1000);
      WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
      password.sendKeys("1234");
      Thread.sleep(1000);
      WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
      company.sendKeys("CodeFish");
      Thread.sleep(1000);
      WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
      website.sendKeys("https://demo.opencart.com/");
      Thread.sleep(1000);
      WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
      country.sendKeys("Albania");
      Thread.sleep(1000);
      WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
      city.sendKeys("Kiev");
      Thread.sleep(1000);
      WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
      address1.sendKeys("123 Devon Ave");
      Thread.sleep(1000);
      WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
      address2.sendKeys("apt 102");
      Thread.sleep(1000);
      WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
      state.sendKeys("IL");
      Thread.sleep(1000);
      WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
      zipCode.sendKeys("60101");
      Thread.sleep(1000);

      WebElement submitBtn = driver.findElement(By.xpath("//button[.='Submit']"));
      submitBtn.click();
      Thread.sleep(1000);

    String actualMessage = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
    String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";

      Assert.assertEquals(actualMessage,expectedMessage);
      Thread.sleep(1000);
      driver.quit();

      System.out.println("dasdasdasdas");
  }

}

