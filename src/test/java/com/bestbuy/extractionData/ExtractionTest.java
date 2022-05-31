package com.bestbuy.extractionData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionTest {

   public static ValidatableResponse response;

    @BeforeClass

    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
         response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    // 1) Extract the value of limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total;");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract the name of 5th store
    @Test
    public void test003() {
        List<String> store = response.extract().path("data.findAll{it.id == 10}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the name of 5th store : " + store);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Extract the names of all the store
    @Test
    public void test004() {
        List<String> storeName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store: " + storeName);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Print the size of the data list
    @Test
    public void test006() {
        List<HashMap<String, ?>> datalist = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of the data list : " + datalist);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> stCloud = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name = St Cloud: " + stCloud);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name =='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester : " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    // 9) Get all the services of 8th store
    @Test
    public void test009() {

        List<HashMap<String,?>> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of 8th store: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10) . Get store services of the store where service name = Windows Store
    @Test
    public void test010() {

        List<HashMap<String,?>> windowStore = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store services of the store where service name = Windows Store: "+windowStore);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11) Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of all the store: " +storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    // 12) . Get id of all the store
    @Test
    public void test012() {
        List<Integer> idOFStore = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all the store : " + idOFStore);
        System.out.println("------------------End of Test---------------------------");
    }

    // 13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> ndStoreNames = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND : " +ndStoreNames);
        System.out.println("------------------End of Test---------------------------");
    }

    // 14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<List<String>> rochesterServices = response.extract().path("data.findAll{it.name=='Rochester'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of services for the store where store name = Rochester : " +rochesterServices);
        System.out.println("------------------End of Test---------------------------");
    }


    // 15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<String> createdAt = response.extract().path("data.findAll{it.services.findAll{it.name == 'Windows Store'}}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all services whose name = “Windows Store” : " +createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    // 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> fargoServices =response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services Where store name = “Fargo” : " + fargoServices);
        System.out.println("------------------End of Test---------------------------");
    }

    // 17. Find the zip of all the store
    @Test
    public void test017() {
        List<String> zipCode = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of all the store : " + zipCode);
        System.out.println("------------------End of Test---------------------------");
    }

    // 18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<String> rosevilleZip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name = Rosevilles : " + rosevilleZip);
        System.out.println("------------------End of Test---------------------------");
    }

    // 19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<String> storeServices =response.extract().path("data.findAll{it.services.findAll{it.name == 'Magnolia Home Theater'}}services.storeservices");
        //"data.findAll{it.services.findAll{it.name == 'Windows Store'}}.createdAt"
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices details of the service name = Magnolia Home Theater : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    // 20. Find the lat of all the stores
    @Test
    public void test020() {
        List<HashMap<String,?>> storeLat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of all the stores : " + storeLat);
        System.out.println("------------------End of Test---------------------------");
    }

}
