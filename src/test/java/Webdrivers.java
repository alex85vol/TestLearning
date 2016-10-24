import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ovo on 19.10.2016.
 */
public class Webdrivers {

    public static WebDriver webDriverChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Install\\Selenium\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver =  new ChromeDriver();
        return driver;
    }
}
