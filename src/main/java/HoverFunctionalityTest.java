
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverFunctionalityTest {


    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void HoverFunctionalityTestMethod() throws InterruptedException {

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementToHover = wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-id-1\"]/li[2]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(2000);

        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-46")));
        dropdownElement.click();
        Thread.sleep(2000);
    }



    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}

