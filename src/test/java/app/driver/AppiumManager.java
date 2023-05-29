package app.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumManager {
    private static AppiumManager instance = null;
    private AppiumDriver driver;
    public boolean androidPlatform = true;
    public String url2 = "http://localhost:4723";

    private AppiumManager() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static AppiumManager getInstance() {
        if (instance == null) {
            instance = new AppiumManager();
        }
        return instance;
    }

    public void setup(boolean isAndroid) throws MalformedURLException {
        if (driver == null) {
            if (isAndroid) {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName("sdk_gphone64_x86_64");
                options.setChromedriverExecutable("C:\\Users\\20112\\IdeaProjects\\appiumEcommerce\\src\\test\\resources\\chromedriver.exe");
                options.setPlatformVersion("");
                driver = new AndroidDriver(new URL(url2), options);
            } else {
                XCUITestOptions options = new XCUITestOptions();
                options.setCapability("platformName", "iOS");
                driver = new IOSDriver(new URL(url2), options);
            }
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}