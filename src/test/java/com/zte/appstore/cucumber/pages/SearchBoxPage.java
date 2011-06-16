package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.WebDriverFacade;
import cuke4duke.annotation.I18n.ZH_CN.当;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

public class SearchBoxPage extends BasePage {
    @FindBy(css = "input.search-input")
    private WebElement searchInput;

    public SearchBoxPage(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        super(facade);
    }

    @当("^我用关键字'(.+)'搜索应用$")
    public void searchApp(String keyword) {
        searchInput.sendKeys(keyword);
        searchInput.submit();
    }

    @Override
    protected void assertOnCurrentPage() {
    }
}
