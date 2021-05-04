import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsHoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void testHoverOnGetName1() {
        Actions action = new Actions(driver);
        WebElement firstUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        action.moveToElement(firstUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement panelFromFirstUser = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5"));
        //Find element which displayed after action
        String actualNameUser1 = panelFromFirstUser.getText();
        String expectedResult = "name: user1";
        Assert.assertEquals(expectedResult, actualNameUser1);
    }

    @Test
    public void testLinkViewProfileUser1() {
        Actions action = new Actions(driver);
        WebElement firstUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        action.moveToElement(firstUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement link = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/a"));
        //Find element which displayed after action
        link.click();
        WebElement textFromPage = driver.findElement(By.xpath("/html/body/h1"));
        String valueTextFromPage = textFromPage.getText();
        Assert.assertEquals(valueTextFromPage, "Not Found");
    }

    @Test
    public void getUserNameFromUser2() {
        Actions hoverOnUserIcon = new Actions(driver);
        WebElement secondUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        hoverOnUserIcon.moveToElement(secondUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement panelFromSecondUser = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5"));
        //Find element which displayed after action
        String actualUserName = panelFromSecondUser.getText();
        Assert.assertEquals(actualUserName, "name: user2");
    }

    @Test
    public void viewProfileTestFromUser2() {
        Actions hoverOnTheSecondUserIcon = new Actions(driver);
        WebElement theSecondUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        hoverOnTheSecondUserIcon.moveToElement(theSecondUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement link = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/a"));
        //Find element which displayed after action
        link.click();
        WebElement textFromPage = driver.findElement(By.xpath("/html/body/h1"));
        String valueTextFromSecondPage = textFromPage.getText();
        String expectedResult = "Not Found";
        Assert.assertEquals(valueTextFromSecondPage, expectedResult);
    }

    @Test
    public void getUserNameFromTheThirdUser() {
        Actions hoverOnTheThridUserIcon = new Actions(driver);
        WebElement theThirdUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
        hoverOnTheThridUserIcon.moveToElement(theThirdUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement panelFromTheTrirdUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5"));
        //Find element which displayed after action
        String actualNameFromTheThirdUser = panelFromTheTrirdUserIcon.getText();
        System.out.println(actualNameFromTheThirdUser);
        Assert.assertTrue(actualNameFromTheThirdUser.contains("3"));
    }

    @Test
    public void linkViewProfileFromUser3() {
        Actions hoverOnTheThirdUserIcon = new Actions(driver);
        WebElement theThirdUserIcon = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
        hoverOnTheThirdUserIcon.moveToElement(theThirdUserIcon).build().perform();
        //To find a hidden element we use the "action" method "move to element" method
        WebElement link = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/a"));
        //Find element which displayed after action
        link.click();
        WebElement textFromPage = driver.findElement(By.xpath("/html/body/h1"));
        String valueTextFromSecondPage = textFromPage.getText();
        Assert.assertTrue(valueTextFromSecondPage.contains("Not"));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        //This block of code closes browser after test
    }
}
