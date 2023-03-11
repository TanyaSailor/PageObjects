package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement transferHead =$(byText("Пополнение карты"));
    private SelenideElement amountInput =$("[data-test-id=amount] input");
    private SelenideElement fromInput =$("[data-test-id=from] input");
    private SelenideElement transferButton =$("[data-test-id=action-transfer]");
    private SelenideElement errorMassage =$("[data-test-id=error-notification]");

    public TransferPage(){
        transferHead.shouldBe(Condition.visible);
    }

public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
}

public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
}
 public void findErrorMessage(String expectedText) {
        errorMassage.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(15)).shouldBe(Condition.visible);
 }

}
