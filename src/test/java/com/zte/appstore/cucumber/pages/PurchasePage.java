package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.PageAction;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class PurchasePage extends BasePage {

    @FindBy(id = "selectBrand")
    private WebElement brandSelectBox;

    @FindBy(id = "selectModel")
    private WebElement modelSelectBox;

    @FindBy(id = "submitPay")
    private WebElement submitPay;

    private final String confirmButtonCssLocator = "input[value='确定']";

    @FindBy(css = confirmButtonCssLocator)
    private WebElement confirmButton;

    public PurchasePage(PageAction pageAction) {
        super(pageAction);
    }

    @I18n.ZH_CN.当("^我在确认付款页面选择适配手机品牌“(.+)”$")
    public void selectBrand(String brandName) {
        page.select(brandSelectBox, brandName);
    }

    @I18n.ZH_CN.而且("^我在确认付款页面选择适配手机型号“(.+)”$")
    public void selectModel(final String modelName) {
        page.waitForPresenceOfElementWithin(modelSelectBox, modelName);
        page.select(modelSelectBox, modelName);
    }

    @I18n.ZH_CN.而且("^我在确认付款页面点击确认下载按钮$")
    public void submitPay() {
        submitPay.click();
    }

    @I18n.ZH_CN.那么("^我在确认付款页面可以看到确定按钮$")
    public void seeConfirmButton() {
        page.waitForPresenceOfElement(By.cssSelector(confirmButtonCssLocator));
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("沃商店，精彩随心选", page.getTitle());
    }
}
