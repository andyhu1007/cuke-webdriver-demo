package com.zte.appstore.cucumber;

import com.zte.appstore.cucumber.pages.HomePage;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class PageNavigator {
    private WebDriver d;
    private final static String URL_TEMPLATE = "%s://%s:%s/%s";
    private String protocol = System.getProperty("server.protocol", "http");
    private String host = System.getProperty("server.host", "10.46.178.34");
    private String port = System.getProperty("server.port", "8080");

    public PageNavigator(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        d = facade.getWebDriver();
    }

    @I18n.ZH_CN.假如("^我在主页$")
    public void visitHomePage() {
        visit(HomePage.PATH);
    }

    private void visit(String path) {
        d.get(String.format(URL_TEMPLATE, protocol, host, port, path));
    }

}
