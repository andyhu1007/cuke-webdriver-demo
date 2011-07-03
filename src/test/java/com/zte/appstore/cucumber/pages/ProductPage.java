package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.PageAction;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ProductPage extends BasePage {

    @FindBy(css = "a.quick-down-load")
    private WebElement quickDownloadButton;

    public ProductPage(PageAction pageAction) {
        super(pageAction);
    }

    @I18n.ZH_CN.那么("^我可以看到快速下载按钮$")
    public void seeQuickDownloadButton() {
        assertTrue(quickDownloadButton.isEnabled());
    }

    @I18n.ZH_CN.当("^我点击产品页面快速下载按钮$")
    public void clickQuickDownloadButton() {
        quickDownloadButton.click();
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("沃商店，精彩随心选", page.getTitle());
    }
}
