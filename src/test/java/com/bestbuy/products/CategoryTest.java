package com.bestbuy.products;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoryTest extends TestBase {

    @Test
    public void getAllCategories() {
        Response response = given()
                .when()
                .get("/categories");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void getCategoriesId() {
        Response response = given()
                .pathParam("id", "abcat0010000")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createCategory() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("pchcat84000050016");
        categoriesPojo.setName("Wedding Ideas");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void updateCategories() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("pchcat84000050016");
        categoriesPojo.setName("Birthday Parties");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .patch("/categories");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void categoryDelete() {


        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id","pchcat84000050016")
                .when()
                .delete("/categories/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    }
