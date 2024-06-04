package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.cargarSitio("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        homePage.enterUsername("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.clickLoginButton();
        String corretMessage = homePage.getCorretLoginSuccessful();
        assertEquals("Products", corretMessage, "Producsdasdts");
    }
    @Test
    public void testLoginWithIncorrectPassword() {
        homePage.enterUsername("standard_user");
        homePage.enterPassword("incorrect_password");
        homePage.clickLoginButton();

        String errorMessage = homePage.getErrorMessage();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage, "El mensaje de error no es el esperado");
    }
}



