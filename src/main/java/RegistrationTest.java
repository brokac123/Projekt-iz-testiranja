
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class RegistrationTest {

    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/customer/account/create";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void RegistrationTestMethod () throws InterruptedException
    {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(1000);

        WebElement nameInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
        nameInput.sendKeys("Damir");
        Thread.sleep(1000);

        WebElement surnameInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
        surnameInput.sendKeys("Bakula");
        Thread.sleep(1000);

        WebElement birthDateInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dob")));
        birthDateInput.sendKeys("09.11.1972");
        Thread.sleep(1000);

        WebElement emailInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address")));
        emailInput.sendKeys("Baki@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        passwordInput.sendKeys("0okju76tfd!");
        Thread.sleep(1000);

        WebElement password2Input=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation")));
        password2Input.sendKeys("0okju76tfd!");
        Thread.sleep(2000);




    }
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}

















