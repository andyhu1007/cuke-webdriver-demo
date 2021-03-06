package com.cuke.demo.pages;

import com.cuke.demo.PageActionFacade;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ProductPage extends BasePage {

    @FindBy(css = "a.quick-down-load")
    private WebElement quickDownloadButton;

    public ProductPage(PageActionFacade facade) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        super(facade);
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
        assertThat(page.getTitle(), containsString("沃商店，精彩随心选"));
    }
}
