/*
package app.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSingletonMobile {
  public String url2 = "http://localhost:4723";

  public boolean androidPatform =true;
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }
    private DriverSingletonMobile(){
    if (androidPatform){

      setAndroidDriver();

    }else {
      setIOSDriver();
    }
    }
    public static  DriverSingletonMobile getDriverSingletonMobile(){
      if (driverSingletonMobile == null){
        driverSingletonMobile = new DriverSingletonMobile();

      }
      return driverSingletonMobile;
    }
    public void setAndroidDriver()  {
      try {


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
      */
/*different locator appium surrport
       * ID -Name -Class Name - Accessibility ID - Xpath - ccs clestor -UIAUtomator *//*

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      } catch (IOException e){
        e.printStackTrace();
      }
    }
  public void setIOSDriver()  {
      try {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
        options.setApp("/Users/rahulshetty/Desktop/UIKitCatalog.app");
        //	options.setApp("//Users//rahulshetty//workingcode//Appium//src//test//java//resources//TestApp 3.app");
        options.setPlatformVersion("15.5");
        //Appium- Webdriver Agent -> IOS Apps.
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      }
      catch (IOException A){
        A.printStackTrace();
      }

    }

  }
*/
