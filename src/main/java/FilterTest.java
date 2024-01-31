


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
public class FilterTest {


    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void FilterTestMethod() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement outletButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-id-146\"]")));
        outletButton.click();
        Thread.sleep(2000);

        WebElement menButton=wait.
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/dd/form/ul/li[2]/a")));
        menButton.click();
        Thread.sleep(4000);


        WebElement sportsButton=wait.
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/dd/form/ul/li[4]/a")));
        sportsButton.click();
        Thread.sleep(3000);

        WebElement removeSportsButton=wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"am-shopby-container\"]/ol/li[2]/a")));
        removeSportsButton.click();
        Thread.sleep(3000);
    }

@AfterMethod
public void teardownTest() {
    driver.quit();
}}



