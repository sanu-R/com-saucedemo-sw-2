package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser();

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “standard_user” username
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Verify the text “PRODUCTS”
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("PRODUCTS text not found.", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Verify that six products are displayed on the  page
        List<WebElement> productNumber = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
        System.out.println("Total products on the page is : " + productNumber.size());


    }

    @After
    public void closeDown() {
        closeBrowser();
    }

}
