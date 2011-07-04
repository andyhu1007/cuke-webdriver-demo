package com.cuke.demo.pages;

import com.cuke.demo.PageActionFacade;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

public class SearchBoxPage extends BasePage {

    @FindBy(css = "input.search-input")
    private WebElement searchInput;

    public SearchBoxPage(PageActionFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        super(facade);
    }

    @I18n.ZH_CN.当("^我用关键字“(.+)”搜索应用$")
    public void searchApp(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.submit();
    }

    @Override
    protected void assertOnCurrentPage() {
    }
}
