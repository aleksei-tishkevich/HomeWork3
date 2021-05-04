import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxElementsTests {

    private WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void theFirstCheckboxUncheckedTest() {
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        Assert.assertFalse(checkbox1.isSelected());
        //This test checks that checkbox unchecked
    }

    @Test
    public void theFirstCheckboxCheckAndTest() {
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        boolean isSelected = checkbox1.isSelected();
        if (!isSelected) {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        //This test checks that checkbox checked after click
    }

    @Test
    public void theSecondCheckboxCheckedTest() {
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        Assert.assertTrue(checkbox2.isSelected());
        //This test checks that checkbox checked

    }

    @Test
    public void theSecondCheckboxUncheckAndTest() {
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        boolean isSelected2 = checkbox2.isSelected();
        if (isSelected2) {
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected());
        //This test checks that checkbox unchecked after click

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        //This block of code closes browser
    }
}