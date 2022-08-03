package pageFunctions;

import pageObjects.loginPage;

import java.io.IOException;

public class function {
    loginPage lop = new loginPage();



    public void PostAd() throws InterruptedException, IOException {
        lop.clkLocationOff();
        lop.login();
        lop.verifyLoggedIn();
        lop.postAd_AddImage();
        lop.postAdDesc_Ttl2Prc();
        lop.postAd_addTagsNPrce();
        lop.postAdDesc_LoctnNContac();
        lop.postAdDesc_Apply();
    }
}
