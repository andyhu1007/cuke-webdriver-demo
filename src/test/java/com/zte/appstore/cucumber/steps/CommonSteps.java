package com.zte.appstore.cucumber.steps;

import com.zte.appstore.cucumber.PageAction;
import cuke4duke.annotation.I18n;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class CommonSteps {

    private PageAction p;

    public CommonSteps(PageAction pageAction) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        this.p = pageAction;
    }

    @I18n.ZH_CN.那么("^我可以看到“(.+)”$")
    public void seeInPage(String text) {
        assertThat(p.getPageSource(), containsString(text));
    }
}
