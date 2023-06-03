package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
    public void SlidersPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement dragDrop = driver.findElement(By.linkText("Drag & Drop Sliders"));
        dragDrop.click();

        List<WebElement>allSliders = driver.findElements(By.xpath("//input[@type='range']"));

        List<WebElement> allRanges = driver.findElements(By.tagName("output"));

        String expRange = "50";

        for (int i=0;i<allSliders.size();i++){

            while (!BrowserUtils.getText(allRanges.get(i)).equals(expRange)){
                        if (BrowserUtils.getText(allRanges.get(i)).equals(expRange)){
                            break;
                        }else{
                            allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
                        }
            }
        }


    }
}
