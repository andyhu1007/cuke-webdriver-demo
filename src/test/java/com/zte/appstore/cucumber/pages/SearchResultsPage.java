package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.WebDriverFacade;
import cuke4duke.annotation.I18n.ZH_CN.那么;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "appTotal")
    private WebElement summary;

    public SearchResultsPage(WebDriverFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        super(facade);
    }

    @那么("^我应该在结果总览处看到'(.+)'$")
    public void shouldSeeSummary(String text) {
        assertThat(summary.getText(), containsString(text));
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("沃商店，精彩随心选", d.getTitle());
    }
}
