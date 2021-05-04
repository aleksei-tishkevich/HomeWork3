import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ButtonElemensTest {
    private WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void add3ElementsDeleteElementCheckCountAllButtons() throws InterruptedException {
        WebElement addButton = driver.findElement(By.xpath("//*[@id='content']/div/button"));
        for (int i = 0; i < 3; i++) {
            addButton.click();
        }
        //Find an item and press three times with the cycle
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id='elements']/button"));
        List<WebElement> objects;
        objects = driver.findElements(By.xpath("//*[@id='elements']/button"));
        deleteButton.click();
        int actualCount = objects.size();
        int expectedCount = 3;
        Assert.assertEquals(actualCount, expectedCount);
        // This test checks count of elements type "Button" after some actions (add/delete elements)
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        //This block of code closes browser after test
    }
}
