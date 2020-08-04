import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirbnbExperience {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ru.airbnb.com/");
        Thread.sleep(2000);
    }

    @Test
    public void FindExperience() throws InterruptedException {

        driver.findElement(By.xpath("/html/body[@class='with-new-header']/div[4]/div/div/div/div[@class='_16grqhk']/div[@class='_siy8gh']//form[@role='search']//div[@role='tablist']/label[3]/span[@class='_117efr5b']")).click();
        driver.findElement(By.xpath("//*[@id=\"bigsearch-query-detached-query\"]")).sendKeys("Токио");
        Thread.sleep(2000);
        System.out.println("Указали город");

        driver.findElement(By.xpath("/html/body[@class='with-new-header']/div[4]/div/div/div/div[@class='_16grqhk']/div[@class='_siy8gh']/div[@class='_1gw6tte']//form[@role='search']/div[@class='_1rrb221v']//button[@class='_1mzhry13']//span[@class='_m9v25n']")).click();
        Thread.sleep(2000);
        System.out.println("Нажали искать");

        Assert.assertNotNull( driver.findElement(By.linkText("Следующая страница")) );
        System.out.println("Тест выполнен");
    }


    @After
    public void quit(){
        driver.quit();
    }
}
