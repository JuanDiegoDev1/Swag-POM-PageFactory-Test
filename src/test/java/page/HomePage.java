package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;
public class HomePage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    // para las validaciones de correct sesion e incorrect
    @FindBy(xpath = "//h3")
    private WebElement errorMessage;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement corretMessage;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    //validaciones para confirmar si entra a las paginas o sale lo esperado
    public String getCorretLoginSuccessful() {
        return corretMessage.getText();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
