package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CartPage extends BasePage {

    @FindBy(css = "div[class='style_heading__1pFPz heading']")
    WebElement h1;

    @FindBy(css = "a[class='style_name__btju7 linkDefault']")
    public WebElement productName;


    @FindBy(css = "div[class='style_price__1FAPS']")
    public WebElement totalAmountInCart;

    @FindBy(css = "div[class='style_optlimit__22z9R']")
    public WebElement minAmountNotification;

    @FindBy(css = "button[class='style_btn__2I-5X btnDefault']")
    public WebElement checkOutButton;

    @FindBy(css = "div[class='style_heading__3jKOc heading']")
    WebElement h1CheckOut;

    public CartPage(WebDriver driver) {

        super(driver);
    }


        public CartPage verifyCartPage() {
        h1.isDisplayed();
        productName.isDisplayed();
        Assert.assertEquals(h1.getText(), "Корзина");
        return this;

    }

    public CartPage checkMinAmountOrder() throws InterruptedException {

        String stringAmount = totalAmountInCart.getText(); // беру строку
        String stringAmountOnlyInt = stringAmount.replace("грн", "");  // обрезаю грн
        float intAmount = Float.parseFloat(stringAmountOnlyInt); // преобразую в число с точкой
        // если сумма больше 1500, на чек-аут
            if (intAmount>1500) {
            checkOutButton.click();
            Assert.assertEquals(h1CheckOut.getText(), "Оформление заказа");
        }   // если меньше , то жмем на кнопку и проверем что есть сообщение о минимальном заказе и остаесмся в корзине
            else if (intAmount<1500) {
            minAmountNotification.isDisplayed();
            checkOutButton.click();
            Thread.sleep(5000);
            Assert.assertEquals(driver.getTitle(), "Корзина");
            System.out.println(driver.getTitle());
        }
            return this;
        }





    }


