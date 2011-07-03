package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.PageAction;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.By;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {
    public static final String PATH = "WebPortal/indexPage_portalPage.do";
    private static final String productCssSelectorFormatter = "a[title='%s']";

    @FindBy(css = "ol#freerank")
    private WebElement freeList;

    public HomePage(PageAction pageAction) {
        super(pageAction);
    }

    @I18n.ZH_CN.那么("^我可以看到免费排行中的商品“(.+)”$")
    public void seeTheProductInFreeList(String productName) {
        assertTrue(((RenderedWebElement) findProductInFreeList(productName)).isDisplayed());
    }

    @I18n.ZH_CN.当("^我点击免费排行中的商品“(.+)”的链接$")
    public void clickProductLinkInFreeList(String productName) {
        findProductInFreeList(productName).click();
    }

    private WebElement findProductInFreeList(String productName) {
        return freeList.findElement(By.cssSelector(String.format(productCssSelectorFormatter, productName)));
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("中国联通沃商店，精彩随心选", page.getTitle());
    }
}
