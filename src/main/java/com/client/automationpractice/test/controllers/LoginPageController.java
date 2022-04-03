package com.client.automationpractice.test.controllers;

import com.client.automationpractice.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static com.client.automationpractice.test.helpers.Numbers.TWO_SECOND;

public class LoginPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaLoginPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(landingPage.getSignIn(), TWO_SECOND.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }

    public void irHaciaContactUsPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(landingPage.getContactUs(), TWO_SECOND.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }


}
