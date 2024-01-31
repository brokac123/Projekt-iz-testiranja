import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginLogoutTest {

    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void LoginLogoutTestMethod () throws InterruptedException
    {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(1000);
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"html-body\"]/div[1]/header/div/div[2]/div/div[1]")));

        profileButton.click();
        Thread.sleep(1000);

        WebElement emailInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailInput.sendKeys("Baki@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passwordInput.sendKeys("0okju76tfd!");
        Thread.sleep(1000);

        WebElement loginButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
        loginButton.click();
        Thread.sleep(1000);

        driver.get("https://ferivisport.hr/");
        Thread.sleep(2000);

        WebElement myAccBtn=wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"html-body\"]/div[1]/header/div/div[2]/div/div[1]/div[1]")));
        myAccBtn.click();
        Thread.sleep(2000);

        WebElement logOutBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-id-187\"]/ul/li[4]/a")));
        logOutBtn.click();
        Thread.sleep(7000);

    }
        @AfterMethod

        public void teardownTest() {

             driver.quit();
        }
    }
