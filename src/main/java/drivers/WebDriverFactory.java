package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static AbstractDriver getDriver(String browser) {

        return switch (browser) {

            case "chrome" -> new chromeFactory();

            case "edge" -> new EdgeFactory();

            default -> throw new IllegalArgumentException(
                    "Browser not supported " + browser);
        };
    }

    public static WebDriver initDriver(String browser) {

        WebDriver driver = ThreadGuard.protect(
                getDriver(browser).createDriver()
        );

        WebDriverFactory.driver.set(driver);

        return WebDriverFactory.driver.get();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}