import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareDataFromTables {

    WebDriver driver;

    @BeforeMethod
    public void openWebSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
        Thread.sleep(2000);
        //This block of code opens the desired site and waits for 2 seconds
    }

    @Test
    public void getAndCompareFieldWithField() {
        WebElement table1 = driver.findElement(By.xpath("//*[@id='table1']"));
        WebElement table2 = driver.findElement(By.xpath("//*[@id='table2']"));
        WebElement string2FromTable1 = table1.findElement(By.xpath(".//tr[2]"));
        WebElement string2FromTable2 = table2.findElement(By.xpath(".//tr[2]"));
        WebElement valueFromFirstTable = string2FromTable1.findElement(By.xpath(".//td[1]"));
        WebElement valueFromSecondTable = string2FromTable2.findElement(By.xpath(".//td[1]"));
        String finalValueFromFirstTable = valueFromFirstTable.getText();
        String finalValueFromSecondTable = valueFromSecondTable.getText();
        Assert.assertEquals(finalValueFromFirstTable, finalValueFromSecondTable);
    }

    @Test
    public void getAndCompareStringWithStringFromTables() {
        WebElement table1 = driver.findElement(By.xpath("//*[@id='table1']"));
        WebElement table2 = driver.findElement(By.xpath("//*[@id='table2']"));
        WebElement string2FromTable1 = table1.findElement(By.xpath(".//tr[2]"));
        WebElement string2FromTable2 = table2.findElement(By.xpath(".//tr[2]"));
        String string2ResultFromTable1 = string2FromTable1.getText();
        String string2ResultFromTable2 = string2FromTable2.getText();
        System.out.println(string2ResultFromTable1);
        Assert.assertEquals(string2ResultFromTable1, string2ResultFromTable2);
    }

    @Test
    public void getAndCompareTheSecondElementsFromTheThirdStringFromTables() {
        WebElement valueFromFirstTable = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[2]"));
        WebElement valueFromSecondTable = driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[3]/td[2]"));
        String finalValueFromFirstTable = valueFromFirstTable.getText();
        String finalValueFromSecondTable = valueFromSecondTable.getText();
        System.out.println(finalValueFromFirstTable);
        Assert.assertEquals(finalValueFromFirstTable, finalValueFromSecondTable);
    }

    @AfterMethod
    public void closeWebSite() {
        driver.quit();
        //This block of code closes browser after test
    }
}