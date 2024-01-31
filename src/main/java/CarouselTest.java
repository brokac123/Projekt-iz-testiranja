
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class CarouselTest {


    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void CarouselTestMethod () throws InterruptedException {

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        int i;
        WebElement nextButton=wait.until(ExpectedConditions.elementToBeClickable(By.className("owl-next")));
        WebElement prevButton=wait.until(ExpectedConditions.elementToBeClickable(By.className("owl-prev")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;


        for (i = 0; i < 6; i++) {
            //wait.until(ExpectedConditions.elementToBeClickable(By.className("owl-next"))).click();
            executor.executeScript("arguments[0].click();", nextButton);
            Thread.sleep(1000);
        }

// Click prevBtn using JavaScript,different way of doing the same task
        for (i = 0; i < 6; i++) {
            executor.executeScript("arguments[0].click();", prevButton);
            // wait.until(ExpectedConditions.elementToBeClickable(By.className("owl-prev"))).click();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
    }

    @AfterMethod

    public void teardownTest() {

        driver.quit();
    }
    }
