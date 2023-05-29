package app.base;

import app.driver.AppiumManager;
//import app.driver.DriverSingletonMobile;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class BaseTest {
    public String url = "http://localhost:4723/wd/hub";
    public String url2 = "http://localhost:4723";


    private By countyMenu = By.id("com.androidsample.generalstore:id/spinnerCountry");
    private By countryChoise = By.xpath("(//android.widget.TextView)[6]");
    private By countryResult = By.id("android:id/text1");
    private By name = By.id("com.androidsample.generalstore:id/nameField");
    private By feamleOption = By.id("com.androidsample.generalstore:id/radioFemale");
    private By letShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    private By productName = By.id("com.androidsample.generalstore:id/productName");
    private By addToCart = By.id("com.androidsample.generalstore:id/productAddCart");

    AppiumManager appiumManager = AppiumManager.getInstance();
    AppiumDriver driver ;

    @BeforeMethod
    @Test
    public void setup2() throws InterruptedException, MalformedURLException {
        appiumManager.setup(true);
        driver = appiumManager.getDriver();
Thread.sleep(2000);
        System.out.println("ahmed");
        loginIn();
    }

    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setDeviceName("sdk_gphone64_x86_64");
        options.setDeviceName("sdk_gphone64_x86_64");
        //options.setPlatformName("Android");

        //to make chrome work in mobile

        options.setChromedriverExecutable("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\resources\\chromedriver.exe");
        options.setPlatformVersion("12");
        // options.setAutomationName("Appium");
        options.setApp("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\appLocation\\General-Store.apk");
        //options.setApp(System.getProperty("C:\\Users\\20112\\IdeaProjects\\appium\\src\\test\\resources\\ApiDemos-debug.apk"));
        //  driver2 = new AppiumDriver(new URL(url),options);
        driver = new AndroidDriver(new URL(url2), options);
        /*different locator appium surrport
         * ID -Name -Class Name - Accessibility ID - Xpath - ccs clestor -UIAUtomator */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void loginIn() throws InterruptedException {
        System.out.println("ziko");
        driver.findElement(name).sendKeys("Aya");
        driver.findElement(feamleOption).click();
        driver.findElement(countyMenu).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));")).click();
        driver.findElement(letShop).click();
        //    WebDriverWait wiat = new WebDriverWait(driver, Duration.ofSeconds(6));

    }

    public WebElement findElements(By locater) {

        return driver.findElement(locater);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /*
     * to scroll to end of page
     * */

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }


    /*
     * to scroll to specific element
     *
     * */
    public void addSpecficElementToCartByScrolling(String element) throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"));")).click();

        /*
         * beascue we have more than one element have same i use for loop git the text and index of
         * element to compare it with the required text if match get the index to pass it to click on it
         * */
        int productCount = (driver.findElements(productName)).size();
        for (int i = 0; i < productCount; i++) {

            String product = driver.findElements(productName).get(i).getText();
            if (product.equals(element)) {
                driver.findElements(addToCart).get(i).click();
            }

        }
        Thread.sleep(2000);

    }

    public Double getFormatAmount(String amount) {

        Double price = Double.parseDouble(amount.substring(1));

        return price;
    }

    public void preesLongTouch(By locator) {
        TouchAction touch = new TouchAction((PerformsTouchActions) driver);
        touch.longPress(longPressOptions().withElement(element(driver.findElement(locator))).withDuration(ofSeconds(3))).release().perform();

    }
}

