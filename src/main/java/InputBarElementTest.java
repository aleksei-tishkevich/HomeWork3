import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputBarElementTest {
    WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void inputValuesTestPositiveNumbers() {
        WebElement inputBar = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        //find element
        Actions action = new Actions(this.driver);
        action.contextClick(inputBar).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
        //click to the input bar and two times click to the button UP using keyboard
        WebElement inputBarAfterTwoClick = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        String actualResultString = inputBarAfterTwoClick.getAttribute("value");
        //get value from input bar after actions
        //System.out.println(actualResultString);
        int actualResult = Integer.parseInt(actualResultString);
        Assert.assertEquals(actualResult, 2);
        //compare value from input bar with expected result
        //inputBarAfterTwoClick.clear();
        //clear the input bar (I had used this method before I got knowledge about annotation Method)
    }

    @Test
    public void inputValuesTestNegativeNumbers() {
        WebElement inputBar = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        Actions action = new Actions(this.driver);
        action.contextClick(inputBar).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
        //click to the input bar and tree times click to the button DOWN using keyboard
        WebElement inputBarAfterTreeClick = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        String actualResultString = inputBarAfterTreeClick.getAttribute("value");
        //get value from input bar after actions
        System.out.println(actualResultString);
        int actualResult = Integer.parseInt(actualResultString);
        Assert.assertEquals(actualResult, -3);
        //compare value from input bar with expected result
    }

    @Test
    public void inputUsingKeyboardsNumbers() {
        WebElement inputBar = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        inputBar.sendKeys("123");
        WebElement inputBarAfterTreeClick = this.driver.findElement(By.xpath("//*[@id='content']/div/div/div/input"));
        String actualResultString = inputBarAfterTreeClick.getAttribute("value");
        System.out.println(actualResultString);
        int actualResult = Integer.parseInt(actualResultString);
        Assert.assertEquals(actualResult, 123);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
