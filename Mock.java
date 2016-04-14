package selenium;

 /**
 * Created by Ievgen.Korsun on 4/14/2016.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;


public class Mock {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.seleniumframework.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHomeWork1() throws Exception {
        driver.get(baseUrl + "/Practiceform/");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test1");
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).clear();
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).sendKeys("aaaaa@gmail.com");
        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).sendKeys("12345678");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys("GL");
        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys("HelloTest");
        driver.findElement(By.linkText("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div[1]/div")).getText(), "Feedback has been sent to the administrator");
        System.out.println("MESSAGE1:" + driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div[1]/div")).getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testHomeWork2() throws Exception {
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test2");
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).clear();
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).sendKeys("gmail.com");
        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).sendKeys("12345678");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys("GL");
        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys("HelloTest");
        driver.findElement(By.linkText("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div/span[2]/div/div[1]")).getText(), "* Invalid email address");
        System.out.println("MESSAGE2:" + driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div/span[2]/div/div[1]")).getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testHomeWork3() throws Exception {
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test3");
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).clear();
        driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).sendKeys("aaaaa@gmail.com");
        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys("GL");
        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys("HelloTest");
        driver.findElement(By.linkText("Submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div/span[3]/div/div[1]")).getText(), "* This field is required\n" +
                "* Invalid phone number");
        System.out.println("MESSAGE2:" + driver.findElement(By.xpath(".//*[@id='presscore-contact-form-widget-3']/form/div/span[3]/div/div[1]")).getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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


