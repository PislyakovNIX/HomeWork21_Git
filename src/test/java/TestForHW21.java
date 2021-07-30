import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestForHW21 {

    @Test
    public void test_1(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://idemo.bspb.ru");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[@class='icon-email']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mark all as read']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New message']")).click();

        Select select = new Select(driver.findElement(By.xpath("//select[@name='message.topicName']")));
        select.selectByVisibleText("Bug report");

        driver.findElement(By.xpath("//textarea[@name='message.text']")).sendKeys("Test message");
        driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();
        driver.quit();

        System.out.println("Code for new commit");
    }
}
