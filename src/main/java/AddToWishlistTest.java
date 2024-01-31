import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToWishlistTest {


    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void AddToWishlistMethod () throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBox=wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        searchBox.sendKeys("Barcelona");
        searchBox.submit();
        Thread.sleep(4000);

        WebElement barcelonaJersey=wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li[1]/div/a/span/span/picture/img")));
        barcelonaJersey.click();
        Thread.sleep(2000);

        WebElement sizeButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("option-label-ferivi_velicina-136-item-41")));
        sizeButton.click();
        Thread.sleep(2000);

        WebElement wishListButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div/div[2]/div[2]/a")));
        wishListButton.click();
        Thread.sleep(2000);

        WebElement emailInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailInput.sendKeys("Baki@gmail.com");
        Thread.sleep(1000);

        WebElement passwordInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passwordInput.sendKeys("0okju76tfd!");
        Thread.sleep(1000);

        WebElement loginButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
        loginButton.click();
        Thread.sleep(5000);

    }
    @AfterMethod

    public void teardownTest() {

        driver.quit();
    }
}
