package com.cuke.demo.pages;

import com.cuke.demo.PageActionFacade;
import cuke4duke.annotation.I18n;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "appTotal")
    private WebElement summary;

    public SearchResultsPage(PageActionFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        super(facade);
    }


    @I18n.ZH_CN.那么("^我应该在结果总览处看到“(.+)”$")
    public void shouldSeeSummary(String text) {
        page.waitForPresenceOfElement(By.cssSelector("div#appTotal em"));
        assertThat(summary.getText(), containsString(text));
    }

    @I18n.ZH_CN.那么("^我应该在搜索结果中看到“(.+)”$")
    public void shouldSeeSearchResult(String text) {
        page.findElement(By.linkText(text));
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("沃商店，精彩随心选", page.getTitle());
    }

}
