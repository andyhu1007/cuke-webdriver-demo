package com.cuke.demo.pages;

import com.cuke.demo.PageAction;
import com.cuke.demo.PageActionFacade;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public abstract class BasePage {
    protected PageAction page;

    public BasePage(PageActionFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        page = facade.getPageAction();
        assertOnCurrentPage();
        PageFactory.initElements(page.getWebDriver(), this);
    }

    protected abstract void assertOnCurrentPage();
}
