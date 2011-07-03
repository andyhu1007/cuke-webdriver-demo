package com.zte.appstore.cucumber;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

public class PageAction {

    private final WebDriver d;
    private final WebDriverWait wait;

    public PageAction(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        d = facade.getWebDriver();
        wait = new WebDriverWait(d, 10);
    }

    public void select(WebElement selectBox, String text) {
        String optionMatchByTextFormatter = "option[text()='%s']";
        WebElement option = selectBox.findElement(By.xpath(String.format(optionMatchByTextFormatter, text)));
        option.setSelected();
    }

    public void waitForPresenceOfElementWithin(final WebElement element, final String text) {
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return element.findElement(By.xpath(String.format("option[text()='%s']", text)));
            }
        });
    }

    public void waitForPresenceOfElement(final By locator) {
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }

    public String getPageSource() {
        return d.getPageSource();
    }

    public WebDriver getWebDriver() {
        return d;
    }

    public String getTitle() {
        return d.getTitle();
    }
}
