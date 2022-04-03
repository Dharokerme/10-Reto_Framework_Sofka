package com.client.automationpractice.test.controllers;

import com.client.automationpractice.test.page.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.client.automationpractice.test.helpers.Numbers.FIVE_SECOND;
import static com.client.automationpractice.test.helpers.Numbers.TWO_SECOND;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void clicEnTShirts() {
        try {
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            webAction.click(myAccountPage.getTshirts(), FIVE_SECOND.getValue(), true);
            webAction.click(myAccountPage.getImageTshirt(), FIVE_SECOND.getValue(), true);
            webAction.click(myAccountPage.getAddToCart(), FIVE_SECOND.getValue(), true);
            webAction.click(myAccountPage.getProceedToCheckout(), FIVE_SECOND.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar darle click en T-shirts.", e);
        }
    }
}
