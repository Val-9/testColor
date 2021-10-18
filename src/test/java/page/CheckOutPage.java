package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckOutPage extends BasePage {

    @FindBy(css = "input[id='phone'][name = 'phone']")
    public WebElement senderPhoneInput;

    @FindBy(css = "input[id='name'][name = 'name']")
    public WebElement senderNameInput;

    @FindBy(css = "input[id='city'][name = 'city']")
    public WebElement senderCityInput;

    @FindBy(css = "input[id='email'][name = 'email']")
    public WebElement senderEmailInput;

    @FindBy(css = "#name")
    public WebElement recipientNameInput;

    @FindBy(css = "#phone")
    public WebElement recipientPhoneInput;

    @FindBy(css = "button[class='style_submit__3_bTq btnDefault']")
    public WebElement submitButton;

    @FindBy(css = "div[class='style_heading__1rckW heading']")
    public WebElement header; // Заголовок добавить получателя

    @FindBy(css = "div[class='style_heading__2AwXF heading']")
    public WebElement headerSuccessOrder; // Заголовок "Отлично все получилось"

    @FindBy(css = "button[class='style_addBtn__1a-1o linkBtn']")
    public WebElement addRecipient; // добавить получателя

    @FindBy(css = "div[id='payment']")
    public WebElement choosePayment; // Выбор оплаты

    @FindBy(css = "div[id='delivery']")
    public WebElement chooseDelivery; // Выбор оплаты

    @FindBy(css = "div[id='react-select-2-option-0']")
    public WebElement cash; // Оплата. Выпадающий список. Наличка

    @FindBy(css = "div[id='react-select-2-option-1']")
    public WebElement bankCard; // Оплата. Выпадающий список. Банковская карта

    @FindBy(css = "div[id='react-select-2-option-2']")
    public WebElement cod; // Оплата. Выпадающий список. Наложенный платеж

    @FindBy(css = "div[id='react-select-3-option-0']")
    public WebElement pickup; // Доставка. Выпадающий список. Самовывоз

    @FindBy(css = "div[id='react-select-3-option-1']")
    public WebElement novayaPochta; // Доставка. Выпадающий список. Новая почта

    @FindBy(css = "div[id='react-select-3-option-2']")
    public WebElement delivery; // Доставка. Выпадающий список. Деливери

    @FindBy(css = "div[id='react-select-3-option-3']")
    public WebElement courierInOdessa; // Доставка. Выпадающий список. Самовывоз

    @FindBy(css = "div[id='area']")
    public WebElement chooseRegion; // Выбор области

    @FindBy(css = "div[id='react-select-4-option-14']")
    public WebElement regionOdessa; // Одесская область

    @FindBy(css = "div[id='city']")
    public WebElement chooseCity; // Выбор города

    @FindBy(css = "#react-select-5-input")
    public WebElement inputCity; //

    @FindBy(css = "div[id='react-select-14-option-236']")
    public WebElement cityOdessa; // Город Одесса

    @FindBy(css = "div[id='warehouse']")
    public WebElement chooseWarehouse ; // Выбор отделения

    @FindBy(css = "div[id='react-select-6-option-56']")
    public WebElement warehouse57 ; // Отделение №57





    @FindBy(css = "button[class='style_confirmBtn__2P5-f btnDefault']")
    public WebElement confirmOrderButton; // Кнопка "заказ подтверждаю"


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    // Страница checkOut/user

    public CheckOutPage senderPhone(String data) {
        senderPhoneInput.click();
        senderPhoneInput.sendKeys(Keys.HOME, data);
        return this;
    }

    public CheckOutPage senderName(String data) {
        senderNameInput.sendKeys(data);
        return this;
    }

    public CheckOutPage senderCity(String data) {
        senderCityInput.sendKeys(data);
        return this;
    }

    public CheckOutPage senderEmail(String data) {
        senderEmailInput.sendKeys(data);
        return this;
    }

    public CheckOutPage clickSubmitButton() throws InterruptedException {
        submitButton.click();
        Thread.sleep(2000);
        return this;
    }


    // Страница checkOut . Добавить получателя

    public CheckOutPage addRecipient() {
        waitVisibility(By.cssSelector("button[class='style_addBtn__1a-1o linkBtn']"));
        addRecipient.click();
        return this;
    }

    public CheckOutPage recipientPhone(String data) {
        recipientPhoneInput.click();
        recipientPhoneInput.sendKeys(Keys.HOME, data);
        return this;
    }

    public CheckOutPage recipientName(String data) {
        recipientNameInput.click();
        recipientNameInput.sendKeys(data);
        return this;
    }

    public CheckOutPage chooseBankCard() throws InterruptedException {
        choosePayment.click();
        bankCard.click();
        return this;
    }

    public CheckOutPage chooseCash() {
        choosePayment.click();
        cash.click();
        return this;
    }

    public CheckOutPage chooseCOD() {
        choosePayment.click();
        cod.click();
        return this;
    }

    public CheckOutPage choosePayment(WebElement element) {
        choosePayment.click();
        element.click();
        return this;
    }

    public CheckOutPage chooseDelivery(WebElement element) {
        chooseDelivery.click();
        element.click();
        return this;
    }

    public CheckOutPage chooseRegion(WebElement element) {
        chooseRegion.click();
        element.click();
        return this;
    }

    public CheckOutPage chooseCity(String city) {
        inputCity.sendKeys(city, Keys.ENTER);
        return this;
    }

    public CheckOutPage chooseWarehouse(WebElement element) {
        chooseWarehouse.click();
        element.click();
        return this;
    }


    public CheckOutPage confirmOrderButton() {
        confirmOrderButton.click();
        return this;
    }

        public CheckOutPage verifySuccessMassage() throws InterruptedException {
        headerSuccessOrder.isDisplayed();
        Assert.assertEquals(headerSuccessOrder.getText(), "ОТЛИЧНО, ВСЕ ПОЛУЧИЛОСЬ!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://color-it.ua/checkout/success");
        Thread.sleep(3000);
        return this;

    }
}