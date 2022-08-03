package common;

import basePage.baseSetup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;


public class generalCommands {
    AppiumDriver driver = baseSetup.driver;
    public void scrollVertical(String identifier,double stY,double edY) throws InterruptedException {
        Thread.sleep(5000);
        WebElement ele = driver.findElement(AppiumBy.className(identifier));

        int centerX = ele.getRect().x + (ele.getSize().width / 2);

        double startY = ele.getRect().y + (ele.getSize().height * stY);

        double endY = ele.getRect().y + (ele.getSize().height * edY);
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), centerX, (int) endY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        driver.perform(Arrays.asList(swipe));
    }
}
