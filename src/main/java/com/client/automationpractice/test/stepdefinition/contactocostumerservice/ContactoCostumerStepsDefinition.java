package com.client.automationpractice.test.stepdefinition.contactocostumerservice;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.client.automationpractice.test.controllers.*;
import com.client.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import com.client.automationpractice.test.data.objects.TestInfo;
import com.client.automationpractice.test.model.Customer;
import com.client.automationpractice.test.stepdefinition.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.client.automationpractice.test.helpers.Dictionary.SPACE_STRING;

public class ContactoCostumerStepsDefinition extends Setup {

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la página de inicio")
    public void queElClienteEstaEnLaPáginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente envia su mensaje al administrador")
    public void elClienteEnviaSuMensajeAlAdministrador() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUsPage();

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.contactarAlAdministrador();
    }

    @Entonces("como resultado se muestra un mensaje de exito")
    public void comoResultadoSeMuestraUnMensajeDeExito() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        Boolean alerta = contactUsPageController.obtenerMensajeConfirmacion();

        Assert
                .Hard
                .thatBoolean(alerta)
                .isEqualTo(true);

    }

    @Cuando("el cliente envia un mensaje incorrecto al administrador")
    public void elClienteEnviaUnMensajeAlAdministrador() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUsPage();

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.contactarAlAdministradorError();

    }

    @Entonces("como resultado se muestra un mensaje de error")
    public void comoResultadoSeMuestraUnMensajeDeError() {

        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);

        Boolean alerta = contactUsPageController.obtenerMensajeError();

        Assert
                .Hard
                .thatBoolean(alerta)
                .isEqualTo(true);
    }

    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
