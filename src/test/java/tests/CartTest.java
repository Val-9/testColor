package tests;


import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
     public void verifyCartPage () throws InterruptedException {

         main.
                  goToMain()
                 .editQuantity("000") //1
                 .addToCart()
                 .goToCart();
        cartPage.
                 verifyCartPage()
                .checkMinAmountOrder();




    }




}
