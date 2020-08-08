import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SkyscannerLogin {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.skyscanner.com/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[@id='authentication-link']")).click();
        Thread.sleep(10000);
    }

    @Test
    public void SuccessfulLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='LoginButtons_LoginButtons__primaryButtons__2SMV6']/button[1]")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("email")).sendKeys("jenkrafft@gmail.com");
        driver.findElement(By.xpath("//section[@id='login-modal']//div[@class='App_App__3R8s-']//section[@class='AccountDetection_AccountDetection__2GvWA']/form[@class='AccountDetection_AccountDetection__formContainer__3dabz']//button[@type='submit']")).click();
        driver.findElement(By.id("password")).sendKeys("170988kR");
        Thread.sleep(10000);
        driver.findElement(By.xpath("section[@id='login-modal']/div/div[@class='App_App__3R8s-']//div[@class='EmailLogin_EmailLogin__1syV3']//form[@class='EmailLogin_EmailLogin__formContainer__1LRZh']//button[@type='submit']")).click();
        Thread.sleep(10000);
        System.out.println("Ввели логин пароль");
        driver.findElement(By.className("login")).click();
        Thread.sleep(10000);
        System.out.println("Кликнули Account");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Hi there"));
        System.out.println("Тест выполнен");
    }

    @Test
    public void WrongEmail() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='LoginButtons_LoginButtons__primaryButtons__2SMV6']/button[1]")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("email")).sendKeys("jenkrafft@gmail.com");
        driver.findElement(By.xpath("//section[@id='login-modal']//div[@class='App_App__3R8s-']//section[@class='AccountDetection_AccountDetection__2GvWA']/form[@class='AccountDetection_AccountDetection__formContainer__3dabz']//button[@type='submit']")).click();
        driver.findElement(By.id("password")).sendKeys("170988");
        Thread.sleep(10000);
        driver.findElement(By.xpath("section[@id='login-modal']/div/div[@class='App_App__3R8s-']//div[@class='EmailLogin_EmailLogin__1syV3']//form[@class='EmailLogin_EmailLogin__formContainer__1LRZh']//button[@type='submit']")).click();
        Thread.sleep(10000);
        Assert.assertNotNull( driver.findElement(By.xpath("//div[@class='App_App__3R8s-']//div[@class='EmailLogin_EmailLogin__1syV3']//section/header[@role='alert']/span[@class='BpkBannerAlert_bpk-banner-alert__message__2adQM']")));
        System.out.println("Тест выполнен");
    }


    @After
    public void quit(){
        driver.quit();
    }
}
