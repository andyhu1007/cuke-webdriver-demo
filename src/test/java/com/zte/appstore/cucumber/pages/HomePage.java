package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.WebDriverFacade;

import java.lang.reflect.InvocationTargetException;

public class HomePage extends BasePage{
    public static final String PATH = "WebPortal/indexPage_portalPage.do";

    protected HomePage(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        super(facade);
    }

    @Override
    protected void assertOnCurrentPage() {
    }
}
