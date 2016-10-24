import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Demon on 23.10.2016.
 */
public class HTAjax {
    WebDriver driver;
    WebDriverWait wait;
    String mainPage;
    String logoXPath;
    String labelXPath;
    String textBeforeXPath;
    String[] textAfterXPath;
    String buttonXPath;

    String textBefore;
    String[] textAfter;


    @BeforeSuite
    public void warmUp() {
        mainPage = "http://www.w3schools.com/xml/ajax_intro.asp";
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to(mainPage);
    }

    @Test
    public void verifyOpenPage() {
        logoXPath = "//a[@class='w3schools-logo']";
        labelXPath = "//div[@class='w3-example']/h3";
        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoXPath)));
        Assert.assertEquals("w3schools.com", logo.getText());
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(labelXPath)));
        Assert.assertEquals("AJAX Example", label.getText());

    }

    @Test
    public void verifyTextChanges() {
        int i;
        textBefore = "Let AJAX change this text";
        textAfter = new String[]{"AJAX is not a programming language.", "AJAX is a technique for accesing web servers from a web page.", "AJAX stands for Asyncronous JavaScript And XML."};
        textBeforeXPath = "//div[@id='demo']/h2";
        textAfterXPath = new String[]{"//div[@id='demo']/p[1]", "//div[@id='demo']/p[2]", "//div[@id='demo']/p[3]"};
        buttonXPath = "//div[@id='demo']/button";
        WebElement textBeforeChanges = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textBeforeXPath)));
        Assert.assertEquals(textBefore, textBeforeChanges.getText());
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXPath)));
        button.click();
        for (i = 0; i < 3; i++) {
            WebElement textAfterChanges = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textAfterXPath[i])));
            Assert.assertEquals(textAfter[i], textAfterChanges.getText());
            // These print outs for verification checking process through the loop
            System.out.println("Expected text: " + textAfter[i]);
            System.out.println("Actual text: " + textAfterChanges.getText());
        }


    }


    @AfterSuite
    public void tearDown() {
        driver.close();
    }

}
