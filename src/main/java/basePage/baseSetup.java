package basePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class baseSetup {
    public static AppiumDriver driver;

    public AppiumDriver driverSetup() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        /*
        String currentPath = System.getProperty("user.dir");
        System.out.print(1111111111);
        System.out.print(currentPath);

         */

        cap.setCapability("appium:deviceName","emulator-5554");
        cap.setCapability("appium:platformName","Android");
      //  cap.setCapability("app","/../build/app/outputs/flutter-apk/app-prod-debug.apk");
        cap.setCapability("appium:appPackage","com.ebay.kijiji.ca");
        cap.setCapability("appium:appActivity","com.ebay.app.common.startup.SplashScreenActivity");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AppiumDriver(url,cap);
        return driver;
    }
}
