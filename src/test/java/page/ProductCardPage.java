package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductCardPage extends BasePage  {

    public String BaseUrl;

    public ProductCardPage(WebDriver driver) {

        super(driver);
    }


    public ProductCardPage goCardPage() {
        waitVisibility(By.cssSelector(".style_row__1cT8x > div:nth-child(5) > a:nth-child(1) > span:nth-child(2)"));
        String cardName = driver.findElement(By.cssSelector(".style_row__1cT8x > div:nth-child(5) > a:nth-child(1) > span:nth-child(2)")).getText();
        System.out.println(cardName);
        WebElement card = driver.findElement(By.cssSelector(".style_row__1cT8x > div:nth-child(5) > a:nth-child(1)"));
        card.click();
        waitVisibility(By.cssSelector(".style_row__1cT8x > div:nth-child(5) > a:nth-child(1)"));
        String cardName2 = driver.findElement(By.cssSelector(".style_row__1cT8x > div:nth-child(5) > a:nth-child(1)")).getText();
        Assert.assertEquals(cardName, cardName2);
        return this;
    }

    public ProductCardPage verifyProductCard() {
        return this;

    }

     public ProductCardPage addToCartFromProductCard (){
        return this;
}
}