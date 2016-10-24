import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovo on 19.10.2016.
 */
public class TestLearn {

    Webdrivers webdrivers;

    @BeforeTest
    public void warmUp() throws Exception {
        webdrivers.webDriverChrome().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webdrivers.webDriverChrome().get("https://www.habrahabr.ru");
    }
    @Test
    public void test01() throws Exception{
        webdrivers.webDriverChrome().wait(2000);

    }

    @AfterTest
    public void tearDown() throws Exception {
        webdrivers.webDriverChrome().close();
    }









}
