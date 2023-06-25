package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificateCheckPage {
    @FindBy(name = "certificate")
    private WebElement certificateNumberField;

    @FindBy(id = "certificateCheckForm")
    private WebElement checkFormMessage;

    private WebDriver driver;

    public CertificateCheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendCertificateNumber(String certificateNumber) {
        certificateNumberField.sendKeys(certificateNumber);
        certificateNumberField.sendKeys(Keys.ENTER);
    }

    private boolean isCertificateViewPage() {
        return driver.getCurrentUrl().contains("view");
    }

    public boolean checkCertificateCheckForm() throws Exception {
        System.out.println(checkFormMessage.getAttribute("class"));

        int i = 0;
        boolean result = false;

        while (true) {
            if (isCertificateViewPage()) {
                result = true;
                break;
            }
            if (checkFormMessage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Час очікування на перевірку сертифіката вичерпано");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}