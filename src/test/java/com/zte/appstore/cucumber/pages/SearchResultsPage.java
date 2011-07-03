package com.zte.appstore.cucumber.pages;

import com.zte.appstore.cucumber.PageAction;
import cuke4duke.annotation.I18n.ZH_CN.那么;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SearchResultsPage extends BasePage {

    private final String summaryId = "appTotal";

    @FindBy(id = summaryId)
    private WebElement summary;

    public SearchResultsPage(PageAction pageAction) {
        super(pageAction);
    }

    @那么("^我应该在结果总览处看到“(.+)”$")
    public void shouldSeeSummary(String text) {
        page.waitForPresenceOfElement(By.id(summaryId));
        assertThat(summary.getText(), containsString(text));
    }

    @Override
    protected void assertOnCurrentPage() {
        assertEquals("沃商店，精彩随心选", page.getTitle());
    }
}
