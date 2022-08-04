import basePage.baseSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.function;
import pageObjects.loginPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class testClass {
    @BeforeClass
    public void setup() throws MalformedURLException {
        baseSetup bs = new baseSetup();
        bs.driverSetup();
    }

    @Test
    public void launchApp() throws InterruptedException, IOException {
        function go = new function();
        //go.PostAd();
        go.postAd2();
    }
}
