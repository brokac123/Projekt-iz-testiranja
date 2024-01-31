
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortTest {

    private static void scrollDown(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000);");
        try {
            Thread.sleep(3000); // Adjust the sleep duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void SortTestMethod() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchBox=wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        searchBox.sendKeys("hlace");
        searchBox.submit();
        Thread.sleep(4000);

        WebElement sortButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("sorter")));
        sortButton.click();
        Thread.sleep(2000);

       WebElement cheapButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sorter\"]/option[3]")));
        cheapButton.click();
        Thread.sleep(2000);

        scrollDown(driver);

    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
    }


