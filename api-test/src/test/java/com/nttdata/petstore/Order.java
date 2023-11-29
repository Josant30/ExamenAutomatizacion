package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;

public class Order {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order/";
    public void crearOrder(int idOrder,int petId, int quantity, String shipDate) {
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\":\""+idOrder+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": \"true\"\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then().log().all()
                ;
    }


    public void consultaOrder(int idOrder) {
        SerenityRest.given()
                .contentType("application/json")
                .log().all()
                .get(CREATE_ORDER+idOrder)
                .then().log().all()
        ;
    }
}
