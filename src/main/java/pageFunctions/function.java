package pageFunctions;

import basePage.baseSetup;
import common.excelReader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pageObjects.loginPage;

import java.io.IOException;

public class function extends excelReader {
    loginPage lop = new loginPage();
    excelReader ex = new excelReader();
    AppiumDriver driver = baseSetup.driver;


    public void PostAd() throws InterruptedException, IOException {
        lop.clkLocationOff();
        lop.login();
        lop.verifyLoggedIn();
        lop.delExisitngAds();
        lop.postAd_AddImage();
        lop.postAdDesc_Ttl2Prc();
        lop.postAd_addTagsNPrce();
        lop.postAdDesc_LoctnNContac();
        lop.postAdDesc_Apply();
    }


    public void postAd2() throws InterruptedException, IOException {
        lop.clkLocationOff();
        lop.login();
        lop.verifyLoggedIn();
        System.out.println("Row Count is " + new excelReader().row);
//        System.out.println(ex.readData(new excelReader().row,1));
        System.out.println(ex.readData(1, 0));
        Thread.sleep(2000);
        //lop.titleFound();
        // System.out.println("Text of ad is "+driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.ebay.kijiji.ca:id/ad_title']")).getAttribute("text"));
        for (int i = 1; i <= new excelReader().row; i++) {
            Thread.sleep(2500);
            //if(ex.readData(i,0).contentEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.ebay.kijiji.ca:id/ad_title']")).getAttribute("text"))){
            if (lop.titleFound(i) == true) {
                lop.delExisitngAds();
            } //else {
                lop.postAd_AddImage();
                lop.postAdDesc_Ttl2Prc();
                lop.postAd_addTagsNPrce();
                lop.postAdDesc_LoctnNContac();
                lop.postAdDesc_Apply();

                //}
            //}

        }
    }
}
