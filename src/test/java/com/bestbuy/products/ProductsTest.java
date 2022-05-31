package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsTest extends TestBase {

    @Test
    public void getAllProductsInfo() {
        Response response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleProduct(){
        Response response = given()
                .pathParam("id",48530)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void postProduct(){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Duracell - AA Batteries (4-Pack)");
        productsPojo.setType("HardGood");
        productsPojo.setPrice(7.99);
        productsPojo.setUpc("041333415017");
        productsPojo.setShipping(0);
        productsPojo.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        productsPojo.setManufacturee("Duracell");
        productsPojo.setModel("MN2400B4Z");
        productsPojo.setUrl("Url for Duracell battery Pro");
        productsPojo.setImage("Image for Duracell pack");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .when()
                .post("/products");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void updateProduct(){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Duracell - AAA Batteries (4-Pack)");
        productsPojo.setType("HardGood");
        productsPojo.setPrice(5.49);
        productsPojo.setUpc("041333424019");
        productsPojo.setShipping(0);
        productsPojo.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        productsPojo.setManufacturee("Duracell");
        productsPojo.setModel("MN2400B4A");
        productsPojo.setUrl("This is url for Duracell battery Pro");
        productsPojo.setImage("This is image for Duracell pack");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .when()
                .patch("/products/43900");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void deleteProduct(){
        Response response = given()
                .pathParam("id",127687)
                .when()
                .delete("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
