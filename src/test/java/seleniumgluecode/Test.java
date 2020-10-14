package seleniumgluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test extends TestBase{


//Scenario 1 (Producto)

    @Given("^El usuario se encuentra en la página de Gestión Corredor$")
    public void elUsuarioSeEncuentraEnLaPáginaDeGestiónCorredor() throws Exception {
        Assert.assertTrue(homePageCorredor.homePageIsDisplayed());
    }

    @When("^Hace click sobre el botón Productos Marketing$")
    public void haceClickSobreElBotónProductosMarketing() throws Exception {
        homePageCorredor.clickOnProductos();
    }

    @And("^Se debe redireccionar a la página productos$")
    public void seDebeRedireccionarALaPáginaProductos() throws Exception {
        Assert.assertTrue("No se redirrecciono correctamente a la pagina de Productos",
                           productosPage.isImagenDisplayed());
    }

    @And("^Hace click sobre la tarjeta del producto a contratar$")
    public void haceClickSobreLaTarjetaDelProductoAContratar() throws Exception {
         productosPage.clickOnTarjetaProducto();
    }


    @And("^Visualiza la información del producto seleccionado$")
    public void visualizaLaInformaciónDelProductoSeleccionado() throws Exception {
         Assert.assertTrue(productosPage.isImagenDisplayed2());
    }

    @And("^Hacer click al botón Comprar$")
    public void darleClickAlBotónComprar() throws Exception {
        productosPage.ClickOnComprar();
    }

    @Then("^Se debe redireccionar a la página de login$")
    public void seDebeRedireccionarALaPáginaDeLogin() throws Exception {
        Assert.assertTrue("No se redirrecciono correctamente a la pagina de Login",
                           loginPage.isImagenDisplayed3());
    }

    //Scenario 2 (Login)

    @Given("^Hay un usuario corredor que quiere logiarse con el fin de contratar un producto$")
    public void hayUnUsuarioCorredoraQueQuiereLogiaseConElFinDeContratarUnProducto() {
        //Assert.assertTrue(loginPage.isImagenDisplayed3());

    }

    @And("^Ingresa el nombre del email del usuario corredor$")
    public void ingresaElNombreDelEmailDelUsuarioCorredor() throws Exception {
        Thread.sleep(1000);
        loginPage.typeEmailLocator();
     }


    @And("^Ingresa la contraseña$")
    public void ingresaLaContraseña() throws Exception {
        loginPage.typePasswordLocator();
    }

    @When("^Cuando el usuario ingrese la información requerida válida$")
    public void cuandoElUsuarioIngreseLaInformaciónRequeridaVálidaParaLogiarse() throws Exception {
        loginPage.ClickOnIngresar();
    }

    @Then("^Se debe redireccionar a la página para ingresar los datos del contrato$")
    public void seDebeRedireccionarALaPáginaParaIngresarLosDatosDelContrato() throws Exception {
        Assert.assertTrue(datosContratoPage.isImagenDisplayed4());
    }

// Scenario 3 (Contrato producto)

    @Given("^Se llena el primer formulario con los campos solicitados$")
    public void seLlenaElPrimerFormularioConLosCamposSolicitados() throws Exception {
        datosContratoPage.typeDatosContratospaso1();
        Assert.assertTrue(datosContratoPage.isImagenDisplayed5());

    }

    @And("^Se llena el segundo formulario con los datos solicitados$")
    public void seLlenaElSegundoFormularioConLosDatosSolicitados() throws Exception {
        datosContratoPage.typeDatosContratospaso2();
        Assert.assertEquals(datosContratoPage.selectDropdownList(), "Metropolitana");
        Assert.assertEquals(datosContratoPage.selectDropdownList1(), "Santiago");
    }

    @And("^Tilda el checkbox Declaro conocer y aceptar los Términos y condiciones de TOCTOC$")
    public void tildaElCheckboxDeclaroConocerYAceptarLosTérminosYCondicionesDeTOCTOC() throws Exception {
        datosContratoPage.ClickOncheckaceptaTerminos();
    }

    @And("^Tilda el checkbox Actualizar la información ingresada$")
    public void tildaElCheckboxActualizarLaInformaciónIngresada() throws Exception {
        datosContratoPage.ClickOncheckactulizainfo();
    }

    @When("^Cuando el usuario corredor rellena todos los datos solicitados$")
    public void cuandoElUsuarioCorredorRellenaTodosLosDatosSolicitados() {
        System.out.println("El boton enviar debe estar habilitado");
    }


    @And("^Hace click al botón Enviar$")
    public void darleClickAlBotónEnviar() throws Exception {
        datosContratoPage.ClickOnbtnContinuar();
    }


    @Then("^Se debe redireccionar a la página Detalle del contrato$")
    public void seDebeRedireccionarALaPáginaDetalleDelContrato() throws Exception {
        Assert.assertTrue(detalleContratoPage.istitledetalleDisplayed());
        detalleContratoPage.WriteExcelFile();
        detalleContratoPage.ClickOnbtnPagar();
    }

  //Scenario 4 (Pago producto)

   /* @Given("^El usuario se encuentra en la página Detalle de Pago de Producto Marketing$")
    public void elUsuarioSeEncuentraEnLaPáginaDetalleDePagoDeProductoMarketing() throws Throwable {
      // Assert.assertTrue(detallePagoPage.istitledetallepagoDisplayed());
    }

    @Given("^Selecciona el medio de pago Producto Marketing$")
    public void seleccionaElMedioDePagoProductoMarketing() throws Throwable {
       // detallePagoPage.ClickOnbformapago();
    }

    @Given("^Se debe redireccionar a la página Proceso de Pago Producto Marketing$")
    public void seDebeRedireccionarALaPáginaProcesoDePagoProductoMarketing() throws Throwable {

    }

    @Given("^Se llena los datos según la forma de pago seleccionada de Producto Marketing$")
    public void seLlenaLosDatosSegúnLaFormaDePagoSeleccionadaDeProductoMarketing() throws Throwable {

    }

    @When("^Cuando el usuario corredor completa todos los datos de pago de Producto Marketing$")
    public void cuandoElUsuarioCorredorCompletaTodosLosDatosDePagoDeProductoMarketing() throws Throwable {

    }

    @When("^Hace click al botón pagar Producto Marketing$")
    public void haceClickAlBotónPagarProductoMarketing() throws Throwable {

    }

    @Then("^Se debe redireccionar a la página Pago exitoso del Producto Marketing contratado$")
    public void seDebeRedireccionarALaPáginaPagoExitosoDelProductoMarketingContratado() throws Throwable {

    }

*/

  //Scenario 5 (Plan)

    @Given("^El usuario se encuentra en la página de Gestion Corredor$")
    public void elUsuarioSeEncuentraEnLaPáginaDeGestionCorredor() throws Exception {
        Assert.assertTrue(homePageCorredor.homePageIsDisplayed1());

    }

    @And("^Hace click sobre el botón Ver Planes$")
    public void haceClickSobreElBotónVerPlanes() throws Exception {
        homePageCorredor.clickOnPlanes();
    }

    @And("^Visualiza la información del plan seleccionado$")
    public void visualizaLaInformaciónDelPlanSeleccionado() throws Exception {
        Assert.assertTrue(planPage.isImagenDisplayed6());
    }

    @And ("^Darle click al botón Contratar$")
    public void darleClickAlBotónContratar() throws Exception {
         planPage.clickOnTarjetaPlan();
    }

    @And("^Llena el primer formulario con los campos solicitados$")
    public void llenaElPrimerFormularioConLosCamposSolicitados() throws Exception {
         Assert.assertTrue(datosContratoPlan.isImagenDisplayed8());
         datosContratoPlan.typeDatosContratosplanpaso1();
    }

    @And("^Llena el segundo formulario con los campos solicitados$")
    public void llenaElSegundoFormularioConLosCamposSolicitados() throws Exception {
        datosContratoPlan.typeDatosContratosplanpaso2();
        datosContratoPlan.selectDropdownList2();
        datosContratoPlan.selectDropdownList3();
    }

    @And("^Tilda el checkbox Declaro conocer y aceptar los Términos y condiciones de TOCTOC del Plan$")
    public void tildaElCheckboxDeclaroConocerYAceptarLosTérminosYCondicionesDeTOCTOCDelPlan() throws Exception {
        datosContratoPlan.ClickOnaceptaTerminos();
    }

    @When("^Cuando el usuario rellena todos los datos e imagen solicitados$")
    public void cuandoElUsuarioRellenaTodosLosDatosEImagenSolicitados() throws Exception {
        System.out.println("El boton enviar debe estar habilitado");
    }

    @And("^Darle click al boton Enviar$")
    public void darleClickAlBotonEnviar() throws Exception {
        datosContratoPlan.ClickOnbtnEnviar();
    }

    @Then("^Se debe redireccionar a la página Detalle del contrato del plan a contratar$")
    public void seDebeRedireccionarALaPáginaDetalleDelContratoDelPlanAContratar() throws Exception {
        Assert.assertTrue(detalleContratoPlan.istitledetalleDisplayed9());
    }


}





