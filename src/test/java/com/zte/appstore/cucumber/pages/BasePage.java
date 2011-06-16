package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public abstract class BasePage {
    protected final WebDriver d;

    protected BasePage(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        d = facade.getWebDriver();
        assertOnCurrentPage();
        PageFactory.initElements(d, this);
    }

    protected abstract void assertOnCurrentPage();
}
