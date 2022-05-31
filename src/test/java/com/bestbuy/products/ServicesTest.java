package com.bestbuy.products;

import com.bestbuy.model.ServicePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {

    @Test
    public void getAllServices() {
        Response response = given()
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getServiceId() {
        Response response = given()
                .pathParam("id", 2)
                .when()
                .get("/services/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createServices() {
        ServicePojo servicePojo = new ServicePojo();
        servicePojo.setName("Mobile Recycling");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicePojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();
    }
    public void updateServices() {
        ServicePojo servicePojo = new ServicePojo();
        servicePojo.setName("Laptop Recycling");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicePojo)
                .pathParam("id",22)
                .when()
                .patch("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void servicesDelete() {


        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id",23)
                .when()
                .delete("/services/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
