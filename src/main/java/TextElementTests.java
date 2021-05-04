import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextElementTests {
    private WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void getAndCompareTheFirstPartOfTheText() {
        String expectedResult = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        WebElement text1 = driver.findElement(By.xpath("//*[@id='content']/div/p[1]"));
        String actualResult = text1.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTheSecondPartOfTheTextAndFindContainedText() {
        String expectedResult = "won't.";
        WebElement text2 = driver.findElement(By.xpath("//*[@id='content']/div/p[2]"));
        String actualResult = text2.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
