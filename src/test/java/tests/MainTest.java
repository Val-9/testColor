package tests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;



public class MainTest extends BaseTest {
    @Step("тест")
    @Test(groups = {"smoke"})

    public void MainPageTest() {

        main
                .goToMain()
                .verifyMainPage();
    }

    @Test (groups = {"smoke"})
    public void SearchTest() throws InterruptedException {
        main
                .goToMain()
                .searchProduct("Краска")
                .verifySearch("Краска")
                .clearSearchInput()
                .searchProduct("Ручка")
                .verifySearch("Ручка");

    }

    @Test
    public void addToCartAfterSearch () {
        main
                .goToMain()
                .searchProduct("Ручка")
                .verifySearch("Ручка")
                .addToCart()
                .verifyButtonInCart();
    }


    @Test
    public void addToCart () throws InterruptedException {
        main
                .goToMain()
                .editQuantity("00")
                .addToCart()
                .goToCart(); // перейти в корзину и проверить что товар есть в корзине.

}

    }
