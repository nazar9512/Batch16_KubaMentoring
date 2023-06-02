package lambda_test;

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
import java.util.Arrays;
import java.util.List;

public class HomeWork3 {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(),"Web Orders");
        Thread.sleep(1000);
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of All Orders");
        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(1000);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[contains(text(),'all products')]"));
        viewAllProducts.click();
        Thread.sleep(1000);

                //Validate "View akk products" is selected:
        WebElement productsIsSelected = driver.findElement(By.xpath("//a[contains(text(),'all products')]/.."));
        Assert.assertEquals(productsIsSelected.getAttribute("class"),"selected");

                // Validate header :
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");

                // Validate url has "Product" keyword:
        Assert.assertTrue(driver.getCurrentUrl().contains("Product"));
        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(1000);

            // Find links and validate their href are equals to "Default.aspx", "Products.aspx", "Process.aspx" :

        List<WebElement> links = driver.findElements(By.xpath("//li//a"));
        List<String>linksValues = Arrays.asList("Default.aspx","Products.aspx","Process.aspx");

            for (int i=0;i<links.size();i++){
                Assert.assertTrue( links.get(i).getAttribute("href").contains(linksValues.get(i)));
            }
        driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginBtn.click();
        Thread.sleep(1000);

            WebElement orderBtn = driver.findElement(By.linkText("Order"));
            orderBtn.click();
        Thread.sleep(500);
            WebElement product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
            BrowserUtils.selectBy(product,"ScreenSaver","text");
        Thread.sleep(500);
            WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
            quantity.clear();
        Thread.sleep(500);
            quantity.sendKeys("5");
        Thread.sleep(500);
            WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
            customerName.sendKeys("CodeFish IT School");
        Thread.sleep(500);
            WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
            street.sendKeys("2200 E Devon");
        Thread.sleep(500);
            WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
            city.sendKeys("Des Plaines");
        Thread.sleep(500);
            WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
            state.sendKeys("Illinois");
        Thread.sleep(500);
            WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
            zip.sendKeys("60018");
        Thread.sleep(500);
            WebElement masterCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
            masterCard.click();
        Thread.sleep(500);
            WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
            cardNumber.sendKeys("444993876233");
        Thread.sleep(500);
            WebElement expDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
            expDate.sendKeys("03/24");
        Thread.sleep(500);
            WebElement processBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
            processBtn.click();
        Thread.sleep(500);
            WebElement successMsg = driver.findElement(By.tagName("strong"));
            Assert.assertTrue(successMsg.isDisplayed());

            WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
            viewAllOrders.click();
        Thread.sleep(500);

                // Validate new order is added:
        WebElement newOrder = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        Assert.assertTrue(newOrder.isDisplayed());
        Thread.sleep(500);

                // Validate all inputs are matching with new order:
        List<WebElement>newInputs = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedInputs = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E Devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");
        Thread.sleep(500);

        for ( int i = 1; i< newInputs.size()-1; i++){
                Assert.assertEquals(BrowserUtils.getText(newInputs.get(i)),expectedInputs.get(i-1));
        }
        driver.quit();
    }
}
