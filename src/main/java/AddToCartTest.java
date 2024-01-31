
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
public class AddToCartTest {
    public WebDriver driver;
    public String testURL = "https://ferivisport.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void AddToCartTestMethod() throws InterruptedException {

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

        WebElement wishListButton=wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"html-body\"]/div[1]/header/div/div[3]")));
        wishListButton.click();
        Thread.sleep(1000);

        WebElement barcaJersey=wait.until(ExpectedConditions.elementToBeClickable(By.id("item_24209")));
        barcaJersey.click();
        Thread.sleep(1000);

        WebElement sizeButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("option-label-ferivi_velicina-136-item-41")));
        sizeButton.click();
        Thread.sleep(2000);

       // WebElement addToCartButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        WebElement addToCartButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-addtocart-button\"]")));
        addToCartButton.click();
        Thread.sleep(2000);

        WebElement shoppingCart=wait.until
                (ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"html-body\"]/div[1]/header/div/div[1]")));
        shoppingCart.click();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
