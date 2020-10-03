package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preencheu o email")
    public void keysEmail(String mail) {
        email.sendKeys(mail);
    }

    @Step("Preencheu a senha")
    public void keysPassword(String passwd) {
        password.sendKeys(passwd);
    }

    @Step("Clicou em Sing In")
    public void clickBtnSubmit() {
        clickSubmit.click();
    }
}
