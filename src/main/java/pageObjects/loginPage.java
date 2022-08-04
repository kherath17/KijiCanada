package pageObjects;

import basePage.baseSetup;
import common.excelReader;
import common.generalCommands;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class loginPage {
    AppiumDriver driver = baseSetup.driver;
    excelReader read = new excelReader();

    public void clkLocationOff() throws InterruptedException {
        //Thread.sleep(15000);
        Thread.sleep(5000);
        List<WebElement> ele = driver.findElements(AppiumBy.xpath("//android.view.ViewGroup/android.widget.Button"));
        ele.get(0).click();
    }


    public void login() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"My Kijiji\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/user_profile_sign_in_button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/android.widget.Button[2]")).click();
        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/new_login_fragment_email")).click();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/new_login_fragment_email")).clear();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/new_login_fragment_email")).sendKeys("walkinwonders1@gmail.com");
        //Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/new_login_fragment_password")).sendKeys("KTest123#");
       // Thread.sleep(1500);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/new_login_fragment_continue")).click();
        Thread.sleep(5000);

    }

    public void verifyLoggedIn() throws InterruptedException {
        Thread.sleep(10000);
        String loggedInTxt = driver.findElement(AppiumBy.accessibilityId("Listings")).getAttribute("content-desc");
        System.out.println(loggedInTxt);
        //driver.navigate().refresh();
    }

    public void delExisitngAds() throws InterruptedException {
        Thread.sleep(10000);

        generalCommands gem = new generalCommands();
       // gem.scrollVertical("android.widget.LinearLayout",0.7,0.2); //b4 framelayout

        //driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='com.ebay.kijiji.ca:id/ad_list_card']/android.view.ViewGroup")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/DeleteAd")).click();
        Thread.sleep(5000);
        List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.widget.CompoundButton"));
        ele2.get(2).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/delete_ad_btn_container")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/delete_ad_complete_left_cta_button")).click();
        Thread.sleep(2800);
        gem.scrollVertical("android.widget.FrameLayout",0.2,0.5);
        /*
        List<WebElement> ele = driver.findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.ebay.kijiji.ca:id/adRecyclerView']/android.widget.FrameLayout"));
        System.out.println("No of Ads are "+ele.size());

        while(ele.size()>=1) {
            for (int i = 0; i < ele.size(); i++) {
                Thread.sleep(5000);
                driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='com.ebay.kijiji.ca:id/ad_list_card']/android.view.ViewGroup")).click();
                Thread.sleep(5000);
                driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/DeleteAd")).click();
                Thread.sleep(5000);

                List<WebElement> ele2 = driver.findElements(AppiumBy.className("android.widget.CompoundButton"));
                ele2.get(2).click();
                Thread.sleep(5000);
                driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/delete_ad_btn_container")).click();
                Thread.sleep(3000);
                driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/delete_ad_complete_left_cta_button")).click();
                Thread.sleep(2800);
                gem.scrollVertical("android.widget.FrameLayout",0.2,0.5);
            }
        }

         */
    }

    public boolean titleFound(int row) throws InterruptedException, IOException {
        generalCommands gem = new generalCommands();
        gem.scrollVertical("android.widget.LinearLayout",0.7,0.2); //b4 framelayout

        excelReader ex = new excelReader();

        List<WebElement> ele = driver.findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.ebay.kijiji.ca:id/adRecyclerView']/android.widget.FrameLayout"));
        System.out.println("No of Ads are "+ele.size());
        boolean elemFound=false;
        //System.out.println("Text of 1st elem is "+driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.ebay.kijiji.ca:id/ad_title'])["+i+"]")).getAttribute("text"));
        //while(ele.size()>=1) {
            L1:for (int i = 1; i <=ele.size(); i++) {
                if(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.ebay.kijiji.ca:id/ad_title'])["+i+"]")).getAttribute("text").contentEquals(ex.readData(row,0))){

                    elemFound=true;
                    ele.get(i-1).click();
                }else{
                    continue L1;
                }

                }
        //}
return elemFound;
    }

    public void postAd_AddImage() throws InterruptedException {
        try{
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/post")).click();
            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            Thread.sleep(1000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_capture")).click();
            Thread.sleep(1000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_save")).click();
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_next")).click();
        }catch(Exception e){
           // driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/post")).click();
            Thread.sleep(5000);
            //driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            //Thread.sleep(2000);
          //  driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
           // Thread.sleep(1000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_capture")).click();
            Thread.sleep(1000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_save")).click();
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/btn_next")).click();
        }

    }

    public void postAdDesc_Ttl2Prc() throws InterruptedException, IOException {

        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/titleEditText")).click();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/titleEditText")).clear();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/titleEditText")).sendKeys(read.readData(1,0));
        driver.navigate().back();

        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/descriptionEditText")).click();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/descriptionEditText")).clear();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/descriptionEditText")).sendKeys(read.readData(1,1));
        driver.navigate().back();

        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Category\"]/android.view.ViewGroup/android.widget.EditText")).click();
        Thread.sleep(5000);

        List<WebElement> ele1 = driver.findElements(AppiumBy.xpath("//android.widget.ListView/android.widget.LinearLayout"));
        System.out.println("Num is "+Integer.parseInt(read.readData(1,2).substring(0,1)));

        ele1.get(Integer.parseInt(read.readData(1,2).substring(0,1))).click();
        Thread.sleep(5000);

        //Scrolling due to suggestion area popped up
        generalCommands gem = new generalCommands();
        gem.scrollVertical("android.widget.ListView",0.8,0.2);


        List<WebElement> ele2 = driver.findElements(AppiumBy.xpath("//android.widget.ListView/android.widget.LinearLayout"));
        ele2.get(Integer.parseInt(read.readData(1,3).substring(0,1))).click();
        Thread.sleep(5000);


        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/done")).click();
       // Thread.sleep(10000);

    }

    public void postAd_addTagsNPrce() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Tags\"]/android.view.ViewGroup/android.widget.EditText")).click();


        //Thread.sleep(5000);
        for(int i=0;i<3;i++){
            Thread.sleep(1500);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/addTagsEditText")).click();
          //  Thread.sleep(1500);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/addTagsEditText")).sendKeys(read.readData(1,4+i));
          //  Thread.sleep(1500);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/addTagsButton")).click();
        }
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/save")).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/price_text")).click();
        //Thread.sleep(5000);
        Actions at2 = new Actions(driver);

        at2.sendKeys(read.readData(1,7));
        Thread.sleep(2500);
        at2.build().perform();
        System.out.println("Price is "+read.readData(1,7));

        Thread.sleep(2000);

        driver.navigate().back();
    }

    public void postAdDesc_LoctnNContac() throws InterruptedException, IOException {
        try{
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/post_ad_location_contact_spoke")).click();

            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            Thread.sleep(5000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/universal_address_clear")).click();
            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/universal_address_entry")).sendKeys(read.readData(1,8));

            Thread.sleep(25000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/action_button_apply")).click();

            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/action_button_apply")).click();
        }catch (Exception e) {
/*

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/post_ad_location_contact_spoke")).click();

            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();

 */
            Thread.sleep(5000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/universal_address_clear")).click();
            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/universal_address_entry")).sendKeys(read.readData(1, 8));

            Thread.sleep(25000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/action_button_apply")).click();

            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/action_button_apply")).click();
        }

        //Thread.sleep(5000);

        generalCommands gem = new generalCommands();
        gem.scrollVertical("android.widget.ScrollView", 0.8, 0.2);
        gem.scrollVertical("android.widget.ScrollView", 0.8, 0.2);

        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/phoneEditText")).click();
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/phoneEditText")).sendKeys(read.readData(1,9));
        driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/post_ad_button")).click();


    }

    public void postAdDesc_Apply() throws InterruptedException {
        try{
            Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/dialog_button_positive")).click();
            Thread.sleep(7000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/skip")).click();
            Thread.sleep(2000);
            String sucessAd = driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/success")).getAttribute("text");
            System.out.println(sucessAd);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/close")).click();
        }catch(Exception e){
            // Thread.sleep(15000);
       /*     Thread.sleep(5000);
            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/dialog_button_positive")).click();

        */
            Thread.sleep(7000);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/skip")).click();
            Thread.sleep(2000);
            String sucessAd = driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/success")).getAttribute("text");
            System.out.println(sucessAd);

            driver.findElement(AppiumBy.id("com.ebay.kijiji.ca:id/close")).click();
        }

    }
}
