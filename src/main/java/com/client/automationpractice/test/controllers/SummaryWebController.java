package com.client.automationpractice.test.controllers;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.client.automationpractice.test.page.SummaryPage;

import static com.client.automationpractice.test.helpers.Numbers.FIVE_SECOND;

public class SummaryWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void clickEnCheckOuts() {
        try {
            SummaryPage summaryPage = new SummaryPage(webAction.getDriver());

            webAction.click(summaryPage.getProceedToCheckoutSummary(), FIVE_SECOND.getValue(), true);
            webAction.click(summaryPage.getProceedToCheckoutAddress(), FIVE_SECOND.getValue(), true);
            webAction.click(summaryPage.getTermsOfService(), FIVE_SECOND.getValue(), true);
            webAction.click(summaryPage.getProceedToCheckoutShipping(), FIVE_SECOND.getValue(), true);
            webAction.click(summaryPage.getPayByBankWire(), FIVE_SECOND.getValue(), true);
            webAction.click(summaryPage.getConfirmOrder(), FIVE_SECOND.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar darle click en Checkouts.", e);
        }
    }

    public String obtenerMensajeConfirmacion() {
        String confirmacion = "";
        try {
            SummaryPage summaryPage = new SummaryPage(webAction.getDriver());

            confirmacion = webAction.getText(summaryPage.getOrderConfirmation(), 3, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la confirmacion del producto.", e);
        }

        return confirmacion;
    }

    public void clickEnEmptyTrash() {
        try {
            SummaryPage summaryPage = new SummaryPage(webAction.getDriver());

            webAction.click(summaryPage.getTrash(), FIVE_SECOND.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar darle click en Vaciar papelera.", e);
        }
    }

    public Boolean obtenerCarritoVacio() {
        Boolean vacio = null;
        try {
            SummaryPage summaryPage = new SummaryPage(webAction.getDriver());

            vacio = webAction.isEnabled(summaryPage.getEmptyCart(), FIVE_SECOND.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar el mensaje de carrito vacio.", e);
        }
        return vacio;
    }
}
