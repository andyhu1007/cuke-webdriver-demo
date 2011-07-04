package com.cuke.demo;

import com.cuke.demo.pages.HomePage;
import cuke4duke.annotation.I18n;

import java.lang.reflect.InvocationTargetException;

public class PageNavigator {
    private final PageAction page;

    private final static String URL_TEMPLATE = "%s://%s:%s/%s";
    private String protocol = System.getProperty("server.protocol", "http");
    private String host = System.getProperty("server.host", "store.wo.com.cn");
    private String port = System.getProperty("server.port", "80");

    public PageNavigator(PageActionFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        page = facade.getPageAction();
    }

    @I18n.ZH_CN.假如("^我在主页$")
    public void visitHomePage() {
        visit(HomePage.PATH);
    }

    private void visit(String path) {
        page.get(String.format(URL_TEMPLATE, protocol, host, port, path));
    }
}
