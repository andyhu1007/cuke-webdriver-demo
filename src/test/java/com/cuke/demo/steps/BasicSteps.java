package com.cuke.demo.steps;

import com.cuke.demo.PageAction;
import com.cuke.demo.PageActionFacade;
import cuke4duke.annotation.I18n;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BasicSteps {

    private PageAction page;

    public BasicSteps(PageActionFacade facade) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        page = facade.getPageAction();
    }

    @I18n.ZH_CN.那么("^我可以看到“(.+)”$")
    public void seeInPage(String text) {
        assertThat(page.getPageSource(), containsString(text));
    }
}
