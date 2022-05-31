package com.bestbuy.products;


import com.bestbuy.model.PlayGroundPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StoresTest extends TestBase {

    PlayGroundPojo playGroundPojo = new PlayGroundPojo();

    @Test
    public void getAllStoresInfo() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createStore() {

//        List<String> services = new ArrayList<>();
//        services.add("Java");
//        services.add("Selenium");
        playGroundPojo.setName("Jisua");
        playGroundPojo.setType("abc");
        playGroundPojo.setAddress("30, Carl Street");
        playGroundPojo.setAddress2("");
        playGroundPojo.setCity("Miami");
        playGroundPojo.setState("Florida");
        playGroundPojo.setZip("35698");
        playGroundPojo.setLat(36.6598);
        playGroundPojo.setLng(-45.6587);
        playGroundPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(playGroundPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void getSingleStore(){
        Response response = given()
                .pathParam("id",4)
                .when()
                .get("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void patchStoreInfo(){
        playGroundPojo.setCity("naples");
        Response response = given()
                .pathParam("id",8924)
                .header("Content-Tye", "application/json")
                .body(playGroundPojo)
                .when()
                .patch("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteStoreId(){
        Response response = given()
                .pathParam("id", 8924)
                .header("Content-Type", "application/json")
                .body(playGroundPojo)
                .when()
                .delete("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }




}
