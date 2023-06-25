package steps;

import configuration.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class CertificateCheckSteps extends BaseClass {
    @FindBy(name = "certificate")
    private WebElement certificateNumberField;

    @FindBy(id = "certificateCheckForm")
    private WebElement checkFormMessage;

    public CertificateCheckSteps() {
        PageFactory.initElements(getDriver(), this);
    }

    @Given("I open the certificate check page")
    public void openCertificateCheckPage() {
        getDriver().navigate().to("https://certificate.ithillel.ua/");
    }

    @When("I enter the certificate number {string}")
    public void enterCertificateNumber(String certificateNumber) {
        certificateNumberField.sendKeys(certificateNumber);
        certificateNumberField.sendKeys(Keys.ENTER);
    }


    @Then("I should see the message {string}")
    public void verifyMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Задайте максимальний час очікування (в секундах)

        // Використовуйте WebDriverWait для очікування, доки елемент з вказаним текстом не з'явиться на сторінці
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + expectedMessage + "')]")));

        String actualMessage = messageElement.getText();
        assertEquals(expectedMessage, actualMessage);
    }

    @When("I send certificate number {string}")
    public void sendCertificateNumber(String certificateNumber) {
        enterCertificateNumber(certificateNumber);
    }

    @Then("Verification certificate {string}")
    public void verifyCertificate(String expectedMessage) {
        verifyMessage(expectedMessage);
    }
}