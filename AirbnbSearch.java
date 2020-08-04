import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirbnbSearch {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ru.airbnb.com/");
        Thread.sleep(2000);
    }

    @Test
    public void findApartment() throws InterruptedException {

        driver.findElement(By.xpath("//input[@id='bigsearch-query-detached-query']")).clear();
        driver.findElement(By.xpath("//input[@id='bigsearch-query-detached-query']")).sendKeys("Токио");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='Koan-query__listbox']//ul[@role='listbox']/li[1]/div[@class='_1825a1k']")).click();
        Thread.sleep(2000);
        System.out.println("Указали город");

        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div/div[1]/div[5]/button/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"stepper-adults\"]/button[2]")).click();
        Thread.sleep(2000);
        System.out.println("Указали количество гостей");

        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/div[1]/div/header/div/div[2]/div[2]/div/div/div/form/div/div[2]/button")).click();
        Thread.sleep(2000);
        System.out.println("Нажали искать");



        Assert.assertNotNull( driver.findElement(By.xpath("//*[@id=\"ExploreLayoutController\"]/div/div[2]/div/div/div[1]/nav/ul")) );
        System.out.println("Тест выполнен");
    }


    @After
    public void quit(){
        driver.quit();
    }
}
