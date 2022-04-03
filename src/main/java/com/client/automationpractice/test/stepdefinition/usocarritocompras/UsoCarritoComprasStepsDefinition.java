package com.client.automationpractice.test.stepdefinition.usocarritocompras;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.client.automationpractice.test.controllers.CreateAnAccountWebController;
import com.client.automationpractice.test.controllers.LoginPageController;
import com.client.automationpractice.test.controllers.MyAccountWebController;
import com.client.automationpractice.test.controllers.SummaryWebController;
import com.client.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import com.client.automationpractice.test.data.objects.TestInfo;
import com.client.automationpractice.test.model.Customer;
import com.client.automationpractice.test.page.SummaryPage;
import com.client.automationpractice.test.stepdefinition.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static java.lang.Thread.sleep;

public class UsoCarritoComprasStepsDefinition extends Setup {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente empieza esta en la página de inicio")
    public void queElClienteEmpiezaEstaEnLaPáginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }

    @Cuando("el cliente crea su cuenta y hace los pasos para comprar un producto")
    public void elClienteCreaSuCuentaYHaceLosPasosParaComprarUnProducto() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        customer = createAnAccountWebController.getCustomer();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.clicEnTShirts();

        SummaryWebController summaryPageController = new SummaryWebController();
        summaryPageController.setWebAction(webAction);
        summaryPageController.clickEnCheckOuts();
    }

    @Entonces("debería ver un mensaje de confirmación de compra exitosa.")
    public void deberíaVerUnMensajeDeConfirmaciónDeCompraExitosa() {
        SummaryWebController summaryPageController = new SummaryWebController();
        summaryPageController.setWebAction(webAction);
        String mensaje = summaryPageController.obtenerMensajeConfirmacion();

        Assert
                .Hard
                .thatString(mensaje)
                .contains("Your order on My Store is complete.");
    }

    @Cuando("el cliente crea su cuenta y hace los pasos para comprar un producto pero se arrepiente y vacia el carro de compras")
    public void elClienteCreaSuCuentaYHaceLosPasosParaComprarUnProductoPeroSeArrepienteYVaciaElCarroDeCompras() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        customer = createAnAccountWebController.getCustomer();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.clicEnTShirts();

        SummaryWebController summaryPageController = new SummaryWebController();
        summaryPageController.setWebAction(webAction);
        summaryPageController.clickEnEmptyTrash();
    }

    @Entonces("aparece un mensaje de tú carro está vacío.")
    public void apareceUnMensajeDeTúCarroEstáVacío() {

        SummaryWebController summaryPageController = new SummaryWebController();
        summaryPageController.setWebAction(webAction);
        Boolean alerta = summaryPageController.obtenerCarritoVacio();

        Assert
                .Hard
                .thatBoolean(alerta)
                .isEqualTo(true);
    }

    @After
    public void cerrarDriver() throws InterruptedException {

//        sleep(5000);
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
