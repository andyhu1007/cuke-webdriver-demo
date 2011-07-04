package com.cuke.demo;

import cuke4duke.annotation.After;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PageActionFacade {
    private static Constructor<WebDriver> driverConstructor = getDriverConstructor();

    @SuppressWarnings("unchecked")
    private static Constructor<WebDriver> getDriverConstructor() {
        String driverName = System.getProperty("webdriver.impl", "org.openqa.selenium.firefox.FirefoxDriver");
        try {
            return (Constructor<WebDriver>) Thread.currentThread().getContextClassLoader().loadClass(driverName).getConstructor();
        } catch (Throwable problem) {
            problem.printStackTrace();
            throw new RuntimeException("Couldn't load " + driverName, problem);
        }
    }

    private PageAction page;

    public PageAction getPageAction() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        if (page == null) {
            page = new PageAction(driverConstructor.newInstance());
        }
        return page;
    }

    @After
    public void closeBrowser() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (page != null) {
            page.close();
            page.quit();
        }
    }
}
