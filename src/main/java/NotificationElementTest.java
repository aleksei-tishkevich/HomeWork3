import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationElementTest {
    private WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void notificationTest() throws InterruptedException {
        WebElement link = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
        link.click();
        Thread.sleep(3000);
        WebElement notification = driver.findElement(By.xpath("//*[@id='flash']"));
        String messageText = notification.getText();
        System.out.println(messageText);
        assertTrue(messageText.contains("Action successful"));
    }

    private void assertTrue(boolean condition) {
        while (true) {
            if (!condition) {
                WebElement link = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
                link.click();
                WebElement notification = driver.findElement(By.xpath("//*[@id='flash']"));
                String messageText = notification.getText();
                System.out.println(messageText);
                assertTrue(messageText.contains("Action successful"));
            }
            break;
        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
