package Pages;

import bots.ActionsBot;
import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CartPage {
    private ActionsBot bot;

    // 1. Locators
    private final By goToCartFromOverlayButton = By.id("sw-gtc");
    private final By proceedToCheckoutButton = By.name("proceedToRetailCheckout");
    private final By CheckoutText = By.id("nav-checkout-title-header-text");
    private final By cartCount = By.id("nav-cart-count");
    private final By addToCartButton = By.id("add-to-cart-button");
    private final By quantityDropdownTrigger = By.cssSelector("span[data-action='a-dropdown-button']");
    private final By regularPriceOption = By.xpath("//div[contains(@class, 'accordion-row')]//span[contains(text(), 'السعر العادي') or contains(text(), 'Regular Price')]");
    private final By TotalproductPrice = By.id("sc-subtotal-label-buybox");
    private final By deleteProductButton = By.cssSelector("input[data-action='delete-active']");
    private final By decrementQuantityButton = By.cssSelector("span[data-a-selector='decrement-icon']");
    private final By incrementQuantityButton = By.cssSelector("span[data-a-selector='increment-icon']");


    // 2.Test Constants

    public static final int initialQuantity = 2;
    public static final int decreaseQuantity = 1;
    public static final int increaseQuantity = 1;
    public static final int expectedCount = initialQuantity - decreaseQuantity + increaseQuantity;

    // 3.Constructors

    public CartPage() {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }

    public CartPage(WebDriver driver) {
        this.bot = new ActionsBot(WebDriverFactory.getDriver());
    }

    // 4.Methods



    public CartPage selectRegularPriceIfPresent() {
        try {
            WebDriver driver = WebDriverFactory.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (!driver.findElements(regularPriceOption).isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(regularPriceOption));
                bot.click(regularPriceOption);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Regular price option not found/applicable.");
        }
        return this;
    }

    public int getCartCount() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5));
            WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));
            return Integer.parseInt(countElement.getText().trim());
        } catch (Exception e) {
            return 0;
        }
    }

    public CartPage selectQuantity(int quantity) {
        selectRegularPriceIfPresent();
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(quantityDropdownTrigger));
            bot.click(quantityDropdownTrigger);
            Thread.sleep(1000);

            By quantityOption = By.xpath("//ul[@role='listbox']//a[contains(@class, 'a-dropdown-link') and (normalize-space()='" + quantity + "' or contains(normalize-space(), '" + quantity + "'))]");
            wait.until(ExpectedConditions.elementToBeClickable(quantityOption));
            bot.click(quantityOption);
            Thread.sleep(2000);

            clickAddToCart();
        } catch (Exception e) {
            System.err.println("Select Quantity failed: " + e.getMessage());
        }
        return this;
    }


    public CartPage clickAddToCart() {
        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", btn);
            wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartFromOverlayButton));
        } catch (Exception e) {
            System.err.println("Add to Cart failed: " + e.getMessage());
        }
        return this;
    }


    public CartPage clickProceedToCheckout() {
        bot.click(proceedToCheckoutButton);
        return this;
    }

    public String getTotalProductPrice() {
        return bot.getText(TotalproductPrice).trim();
    }

    public boolean isTotalProductPriceVisible() {
        try {
            return WebDriverFactory.getDriver().findElement(TotalproductPrice).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProceedToCheckoutButtonVisible() {
        try {
            return WebDriverFactory.getDriver().findElement(CheckoutText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CartPage clickoncountCart() {
        bot.click(cartCount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CartPage ClickonDeleteProduct() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15));
        WebElement deleteBtnElement = wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton));
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
        js.executeScript("arguments[0].click();", deleteBtnElement);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CartPage decreaseQuantity(int times) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));
        for (int i = 0; i < times; i++) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(decrementQuantityButton));
                JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
                js.executeScript("arguments[0].click();", btn);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.err.println("Can't decrease quantity on iteration " + (i + 1));
                break;
            }
        }
        return this;
    }

    public CartPage increaseQuantity(int times) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));
        for (int i = 0; i < times; i++) {
            try {
                WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(incrementQuantityButton));
                JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
                js.executeScript("arguments[0].click();", btn);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.err.println("Can't increase quantity on iteration " + (i + 1));
                break;
            }
        }
        return this;
    }

    public CartPage clearCart() {
        try {
            clickoncountCart();
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5));

            while (getCartCount() > 0) {
                try {
                    WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton));
                    JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
                    js.executeScript("arguments[0].click();", deleteBtn);

                    // انتظار التحديث بعد الحذف
                    Thread.sleep(3000);
                } catch (Exception e) {
                    break;
                }
            }
            System.out.println("Cart Count is Cleared successfully");
        } catch (Exception e) {
            System.out.println("Cart Count is Empty");
        }
        return this;
    }

}
