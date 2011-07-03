package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.PageAction;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final PageAction page;

    public BasePage(PageAction page) {
        this.page = page;
        assertOnCurrentPage();
        PageFactory.initElements(page.getWebDriver(), this);
    }

    protected abstract void assertOnCurrentPage();
}
