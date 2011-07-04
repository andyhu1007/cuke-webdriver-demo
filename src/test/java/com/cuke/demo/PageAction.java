package com.cuke.demo;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAction {
    private static final String SELECT_OPTION_TEXT_MATCH_FORMATTER = "option[text()='%s']";

    private WebDriverWait wait;
    private WebDriver d;

    public PageAction(WebDriver d) {
        this.d = d;
        wait = new WebDriverWait(d, 10);
    }

    public WebDriver getWebDriver() {
        return d;
    }

    public String getTitle() {
        return d.getTitle();
    }

    public WebElement findElement(By by) {
        return d.findElement(by);
    }

    public void waitForPresenceOfElement(final By locator) {
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }

    public void get(String location) {
        d.get(location);
    }

    public void close() {
        d.close();
    }

    public void quit() {
        d.quit();
    }

    public void select(WebElement selectBox, String text) {
        WebElement option = selectBox.findElement(By.xpath(String.format(SELECT_OPTION_TEXT_MATCH_FORMATTER, text)));
        option.setSelected();
    }

    public void waitForPresenceOfElementWithin(final WebElement element, final String text) {
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return element.findElement(By.xpath(String.format(SELECT_OPTION_TEXT_MATCH_FORMATTER, text)));
            }
        });
    }

    public String getPageSource() {
        return d.getPageSource();
    }
}
