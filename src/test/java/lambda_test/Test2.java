package lambda_test;

import com.sun.source.tree.Tree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.*;

public class Test2 {
    @Test()
    public void inputFormSubmit() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement tablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        tablePagination.click();

        WebElement rows = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(rows, "5000", "value");

        List<WebElement> allNames = driver.findElements((By.xpath("//td[2]")));
        List<WebElement> allEmails = driver.findElements(By.xpath("//td[3]"));

        Map<String, String> map = new TreeMap<>();
        for (int i = 0; i < allEmails.size(); i++) {
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
        }

        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair);
        }

    }

    @Test()
    public void inputFormSubmit2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement tablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        tablePagination.click();

        WebElement rows = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(rows, "5000", "value");

        List<WebElement> allNames = driver.findElements((By.xpath("//td[2]")));
        List<WebElement>allPhones = driver.findElements(By.xpath("//td[4]"));

        Map<String,Long>map = new HashMap<>();

        for (int i=0;i< allNames.size();i++){

             map.put(BrowserUtils.getText(allNames.get(i)),Long.parseLong(BrowserUtils.getText(allPhones.get(i)).replace("-","")));
        }
        System.out.println(map);
    }



}