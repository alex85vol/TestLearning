

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Habrahabr {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://habrahabr.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHabrahabr() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/a[2]")).click();
    assertTrue(isElementPresent(By.cssSelector("a.facebook")));
    assertTrue(isElementPresent(By.cssSelector("a.vkontakte")));
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test01@ood.com");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("test01");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test01");
    driver.findElement(By.name("password2")).clear();
    driver.findElement(By.name("password2")).sendKeys("test01");
    try {
      assertEquals(driver.findElement(By.cssSelector("div.s-error")).getText(), "Такой никнейм уже занят");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//form[@id='register_form']/div[5]/div[2]")).getText(), "Длина пароля не может быть меньше 8 символов");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//form[@id='register_form']/div[6]/div[2]")).getText(), "Длина пароля не может быть меньше 8 символов");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | undefined | ]]
    driver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=7amweana5sq8 | ]]
    driver.findElement(By.cssSelector("td.rc-imageselect-tileselected > div.rc-image-tile-target > div.rc-image-tile-wrapper > img.rc-image-tile-33")).click();
    driver.findElement(By.cssSelector("td.rc-imageselect-tileselected > div.rc-image-tile-target > div.rc-image-tile-wrapper > img.rc-image-tile-33")).click();
    driver.findElement(By.xpath("(//img[contains(@src,'https://www.google.com/recaptcha/api2/payload?c=03AHJ_VuvJGjsq7kfqXyMwwug5HhayeKaYzgyw7bHS_oCepzdTIRVpkZ3jHaUhqoBuUyjN1XhZZf31ux_Wum17fljvx1Nj_4c_dn8bJY5CswwHZXXiV-DhFP1SIjkaEjwruK85sAlcHcdSU8jIVkOY0uEbxXhEzTrLzUSBSaXCpodN5tYRcdG_AkF4QqX98fkyTE8MSKZLF0a7TtOyS-2_XUZBMvvdsT3RbOkVlWw5ukVoRqKJi_N_fSy5VYQpTeZUVC2e05zRSOwLzDu7X5K0AHFSCaXCcPdFAEatV4smR_1UntzZvoDycSnrYeWwn7IZEB-dmTOp4hYnOhAtK3cqBCDEoRyFkwxRa7xT74XFeLbmjWVNbe4yoHDmmuQR15y5IyodHRTGzqxjd8x0NE9CF6L0R8fcH6uxQJxYRR8LXdrLOPzPzZOFav7maDn6UCL6-hz4wyjfHa8LpXWAFJZQIEFthrpv8-hnm3WHAdEjRmSf9peih3Ke-gVyFLgL73kbgkFXwG8L2pZcEqK0xxi7Ukw2aKxuJuwCyC3aiSfLi5f8kKrTJlWk5mmuf9On0YsbgmWns3ZLk_GXBIaH64qqjuE2-ZPVaaAUMZzR-FuZlk5kXdwgibPkUSY78IMef6q74788zl1HwoA8d5YxtyuRboz-0FPDGIvfjD4dUkTW_e0xJi_V3QlgAZK7mRf-yXXbA5Z_3DMwreGr7v6tYtyYPWoBfZPxp9zc99_x1s_msNZbrJTpCuwZBBrIY6zMjs-c98J-uvwDd7vXyNzUE3gWWMPJ1sc5Omcf1sO6UJ3fdNDtrIeleXuk5iTzf7jOAQYZtnoMwtkM1pLctZUXd3zbidFHqKNPYnqRgVQiL0aPp83sdDFg2aVepdU&k=6LftHuoSAAAAAORONRXn_6xb2f_QCtXqfbRPfY2e')])[7]")).click();
    driver.findElement(By.xpath("(//img[contains(@src,'https://www.google.com/recaptcha/api2/payload?c=03AHJ_VuvJGjsq7kfqXyMwwug5HhayeKaYzgyw7bHS_oCepzdTIRVpkZ3jHaUhqoBuUyjN1XhZZf31ux_Wum17fljvx1Nj_4c_dn8bJY5CswwHZXXiV-DhFP1SIjkaEjwruK85sAlcHcdSU8jIVkOY0uEbxXhEzTrLzUSBSaXCpodN5tYRcdG_AkF4QqX98fkyTE8MSKZLF0a7TtOyS-2_XUZBMvvdsT3RbOkVlWw5ukVoRqKJi_N_fSy5VYQpTeZUVC2e05zRSOwLzDu7X5K0AHFSCaXCcPdFAEatV4smR_1UntzZvoDycSnrYeWwn7IZEB-dmTOp4hYnOhAtK3cqBCDEoRyFkwxRa7xT74XFeLbmjWVNbe4yoHDmmuQR15y5IyodHRTGzqxjd8x0NE9CF6L0R8fcH6uxQJxYRR8LXdrLOPzPzZOFav7maDn6UCL6-hz4wyjfHa8LpXWAFJZQIEFthrpv8-hnm3WHAdEjRmSf9peih3Ke-gVyFLgL73kbgkFXwG8L2pZcEqK0xxi7Ukw2aKxuJuwCyC3aiSfLi5f8kKrTJlWk5mmuf9On0YsbgmWns3ZLk_GXBIaH64qqjuE2-ZPVaaAUMZzR-FuZlk5kXdwgibPkUSY78IMef6q74788zl1HwoA8d5YxtyuRboz-0FPDGIvfjD4dUkTW_e0xJi_V3QlgAZK7mRf-yXXbA5Z_3DMwreGr7v6tYtyYPWoBfZPxp9zc99_x1s_msNZbrJTpCuwZBBrIY6zMjs-c98J-uvwDd7vXyNzUE3gWWMPJ1sc5Omcf1sO6UJ3fdNDtrIeleXuk5iTzf7jOAQYZtnoMwtkM1pLctZUXd3zbidFHqKNPYnqRgVQiL0aPp83sdDFg2aVepdU&k=6LftHuoSAAAAAORONRXn_6xb2f_QCtXqfbRPfY2e')])[6]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=58685 | ]]
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
