package seleniumDesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    
    
    @BeforeTest
    public void setUpDriver(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\rohit.dalmia\\Videos\\geckodriver.exe");
        this.driver = new FirefoxDriver();
    }
    
    @AfterTest
    public void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
        
    }
}
