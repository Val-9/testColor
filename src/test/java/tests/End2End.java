package tests;

import org.testng.annotations.Test;

public class End2End extends BaseTest{

        @Test
        public void end2end () throws InterruptedException {

            main.
                    goToMain()
                    .editQuantity("000") //1
                    .addToCart()
                    .goToCart();
            cartPage.
                    verifyCartPage()
                    .checkMinAmountOrder();
            checkOutPage.
                    senderPhone("1111111111")
                    .senderName("Тестовое имя отправителя")
                    .senderCity("Тестовый город отправителя")
                    .senderEmail("test@sender.test")
                    .clickSubmitButton()
                    .addRecipient()
                    .recipientName("Тестовое Имя Получателя")
                    .recipientPhone("2222222222")
                    .choosePayment(checkOutPage.bankCard)
                    .chooseDelivery(checkOutPage.novayaPochta)
                    .chooseRegion(checkOutPage.regionOdessa)
                    .chooseCity("Одесса")
                    .chooseWarehouse(checkOutPage.warehouse57)
                    .clickSubmitButton()
                    .confirmOrderButton()
                    .verifySuccessMassage();
        }
    }

