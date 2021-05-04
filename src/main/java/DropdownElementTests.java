import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DropdownElementTests {

    private WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void checkAllElementsFromDropdown() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        java.util.List<WebElement> options = select.getOptions();
        for (WebElement item : options) {
            System.out.println("Dropdown value are " + item.getText());
        }
        //Find, get and print to console all values from dropdown menu
        //System.out.println(options.size());
        int expectedCountOfOptions = 3;
        Assert.assertEquals(options.size(), expectedCountOfOptions);
        //Compare num of options
    }

    @Test
    public void selectTheFirstElementAndCheckIsSelected() {
        Select dropdownValue1 = new Select(driver.findElement(By.id("dropdown")));
        dropdownValue1.selectByIndex(1);
        //select the first option from dropdown
        String selectedValue1 = dropdownValue1.getFirstSelectedOption().getText();
        System.out.println(selectedValue1);
        String expectedResult1 = "Option 1";
        Assert.assertEquals(selectedValue1, expectedResult1);
        //compare selected option with expected result
    }

    @Test
    public void selectTheSecondElementAndCheckIsSelected() {
        Select dropdownValue2 = new Select(driver.findElement(By.id("dropdown")));
        dropdownValue2.selectByIndex(2);
        //select the second option from dropdown menu
        String selectedValue2 = dropdownValue2.getFirstSelectedOption().getText();
        System.out.println(selectedValue2);
        String expectedResult2 = "Option 2";
        Assert.assertEquals(selectedValue2, expectedResult2);
        //compare selected option with expected result
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        //This block of code closes browser after test
    }
}