package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Pages.CartPage.*;


public class CartTest extends BaseTest {

    @Test
    public void TC01_UnRegisteredUserCanAddProductToCart() {
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2);
        Assert.assertTrue(cart.getCartCount() > 0, "Cart count is not greater than 0");
    }

    @Test
    public void TC02_UnRegisteredUserCanDeleteProductFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .ClickonDeleteProduct();
        Assert.assertEquals(cart.getCartCount(), 0, "Cart count is not equal to 0");
    }

    @Test
    public void TC03_UnRegisteredUserCanUpdateProductByDecreasingQuantityFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .decreaseQuantity(1);
        Assert.assertEquals(cart.getCartCount(), 1, "Cart count is not equal to 1");
    }

    @Test
    public void TC04_UnRegisteredUserCanUpdateProductByincreasingQuantityFromCart(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(initialQuantity)
                .clickoncountCart()
                .decreaseQuantity(decreaseQuantity)
                .increaseQuantity(increaseQuantity);

        Assert.assertEquals(cart.getCartCount(), expectedCount);
    }

    @Test
    public void TC05_UnRegisteredUserCanClickOnProceedToCheckout(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart()
                .clickProceedToCheckout();
        Assert.assertFalse(cart.isProceedToCheckoutButtonVisible());
    }

    @Test
    public void TC06_UnRegisteredUserCanSeeHisTotalSelectedProductPrice(){
        CartPage cart = loginAndPrepareProduct("pen");
        cart.selectQuantity(2)
                .clickoncountCart();
        Assert.assertTrue(cart.isTotalProductPriceVisible());
    }
}