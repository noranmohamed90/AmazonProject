package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Pages.CartPage.*;


public class CartTest extends BaseTest {

    @Test
    public void TC01_RegisterUserCanAddProductToCart() {
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2);
        Assert.assertTrue(cart.getCartCount() > 0, "Cart count is not greater than 0");
    }

    @Test
    public void TC02_RegisterUserCanDeleteProductFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .ClickonDeleteProduct();
        Assert.assertEquals(cart.getCartCount(), 0, "Cart count is not equal to 0");
    }

    @Test
    public void TC03_RegisterUserCanUpdateProductByDecreasingQuantityFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .decreaseQuantity(1);
        Assert.assertEquals(cart.getCartCount(), 1, "Cart count is not equal to 1");
    }

    @Test
    public void TC04_RegisterUserCanUpdateProductByincreasingQuantityFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(initialQuantity)
                .clickoncountCart()
                .decreaseQuantity(decreaseQuantity)
                .increaseQuantity(increaseQuantity);

        Assert.assertEquals(cart.getCartCount(), expectedCount);
    }

    @Test
    public void TC05_RegisterUserCanClickOnProceedToCheckout(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .clickProceedToCheckout();
        Assert.assertFalse(cart.isProceedToCheckoutButtonVisible());
    }

    @Test
    public void TC06_RegisterUserCanSeeHisTotalSelectedProductPrice(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart();
        Assert.assertTrue(cart.isTotalProductPriceVisible());
    }
}