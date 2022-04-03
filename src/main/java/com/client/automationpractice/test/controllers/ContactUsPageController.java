package com.client.automationpractice.test.controllers;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.client.automationpractice.test.helpers.Dictionary;
import com.client.automationpractice.test.model.Customer;
import com.client.automationpractice.test.page.ContactUsPage;

import static com.client.automationpractice.test.helpers.Dictionary.ADMINISTRADOR;
import static com.client.automationpractice.test.helpers.Helper.generateCustomer;
import static com.client.automationpractice.test.helpers.Numbers.TWO_SECOND;

public class ContactUsPageController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void contactarAlAdministrador(){
        try{
            customer = generateCustomer(Dictionary.SPANISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.selectByPartialText(contactUsPage.getSubjectHeading(),ADMINISTRADOR, true);
            webAction.sendText(contactUsPage.getEmail(), customer.getEmail(), TWO_SECOND.getValue(), true);
            webAction.sendText(contactUsPage.getOrderRef(), customer.getMobilePhone(),true);
            webAction.sendText(contactUsPage.getMessage(), customer.getMessage(), true);
            webAction.click(contactUsPage.getSubmitMessage(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }

    public void contactarAlAdministradorError(){
        try{

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.click(contactUsPage.getSubmitMessage(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar el mensaje vacio esperado de error.", e);
        }
    }

    public Boolean obtenerMensajeConfirmacion() {
        Boolean existe = null;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            existe = webAction.isEnabled(contactUsPage.getSuccessMessage(), 3, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar el mensaje exito de mensaje enviado", e);
        }
        return existe;
    }

    public Boolean obtenerMensajeError(){

        Boolean existe = null;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            existe = webAction.isEnabled(contactUsPage.getErrorMessage(), 3, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar el mensaje de error", e);
        }
        return existe;
    }
}
