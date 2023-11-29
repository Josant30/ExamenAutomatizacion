package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultaOrderStepsDefs {
    @Steps
    Order LosOrders ;
    @Given("el idOrder {int}, tiene un petId {int}, una cantidad {int}, y una fecha de envío {string}")
    public void elOrderTieneUnPetIdPetIdUnaCantidadQuantityYUnaFechaDeEnvíoShipDate(int idOrder, int petId, int quantity, String shipDate) {
        LosOrders.crearOrder(idOrder, petId, quantity, shipDate);
    }
    @When("el método es POST")
    public void elCódigoDeEstadoDeLaRespuestaDeberíaSer() {
        System.out.println("Realizando solicitud POST");
    }
    @Then("el código de estado de respuesta es {int}")
    public void elCódigoDeEstadoDeLaRespuestaDeberíaSer(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
    @And("el cuerpo de la respuesta debería contener el estado de la orden placed")
    public void elCuerpoDeLaRespuestaDeberíaContenerElEstadoDeLaOrdenPlaced() {
        restAssuredThat(response -> response.body("status", equalTo("placed")));
    }

    @Given("el idOrder es {int}")
    public void consultaOrderID(int idOrder) {
        LosOrders.consultaOrder(idOrder);
    }
    @When("el método es GET")
    public void elCódigoDeEstado() {
        System.out.println("Realizando solicitud GET");
    }
    @And("el cuerpo de la respuesta debería contener el id de la orden {int}")
    public void elCuerpoDeLaRespuestaDeberíaContenerElIdDeLaOrden(int orderId) {
        // Agrega la validación para el id de la orden en el cuerpo de la respuesta
        restAssuredThat(response -> response.body("id", equalTo(orderId)));
    }
}
