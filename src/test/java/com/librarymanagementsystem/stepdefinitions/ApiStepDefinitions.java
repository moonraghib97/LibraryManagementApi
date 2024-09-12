package com.librarymanagementsystem.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.runner.Request;
import org.springframework.web.bind.annotation.RequestParam;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiStepDefinitions {

    private String token ; // "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTY2MTg3MywiaWF0IjoxNzI1NjQzODczfQ.XlJ0vKHAXu_hyxLte7bygz-w_SG2qnMS561I-oFopk3Yz4rQiP2VgiT55lSf-tgoH9fryw2DotfAHRUXjSYQ7w";  // "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTQ4NjM5MSwiaWF0IjoxNzI1NDY4MzkxfQ.kv7wx8ci9JYsW8SOdFf9zWUnfb-nPLAbX3DATUaTowb94wPUyF5KBKhKs51oxsHxaYg2QXaRLxolmxuBkk2hbA";
    private Response response;
    private String bookPayload;
    private String updatedBookPayload;

    @Given("I have a valid JWT token")
    public void i_have_a_valid_jwt_token() {
        token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTg0NjcwMiwiaWF0IjoxNzI1ODI4NzAyfQ.sAridEEdYbHFg9HMMfQmIgRqwzHk7p5Lxrz0dy7GT3dGh-At8TmPOdDR419_vKlZG5a0g7WE9QKBzK8lrjJT5w"; //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTg0NTUyMywiaWF0IjoxNzI1ODI3NTIzfQ.mcZ6VA7PjFoRBRPp5kktJRWGCEAz9cPwmY0Dx0o2sxlNEXXkVeq0N_J5y9BiEXv9MtERQrxssU5dvD5QS8vCUQ"; //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTg0NDczNCwiaWF0IjoxNzI1ODI2NzM0fQ.4pGBEdAEwVEG1VVKTbciujUVC0BMHD7fjeYHKrd6CFJsKRPQccBw0tTawSX5O4Wrgi6LZ9vQuaOyWjhE_1eRXQ"; //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTg0NDQzNywiaWF0IjoxNzI1ODI2NDM3fQ.oexyVs4vCCwYD1pur7SvlpaUp-c2zZAZacPSnYZkeKc7MlRxXRIKDCRYQNr3j61vObe3tWyVQv6USYmfiRq8XA"; // "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTg0MzQ1NywiaWF0IjoxNzI1ODI1NDU3fQ.VcLSV_CUrpDRbAGDDrHqUnfhyLI8SYd4KE9R_Q72BCh60zxFhIyhpFlri1zKsdZeuoUaQ8t-veQkWOUQbHIEWg"; // "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTcxMDQxMSwiaWF0IjoxNzI1NjkyNDExfQ.q8qFl97ntyYwinMxKjhf2XJ1CudFg20as1mNCArh7xK4BwLXm-j3-neTvvGruVTe67xs8u7ochhLOsF92mVS_w";  //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTY2OTEyNywiaWF0IjoxNzI1NjUxMTI3fQ.DnwfVFqwy8rgnRSi01BvJLIr4IlwuAatR5_52ceupLPtfRCF5D7eMQC-JwGSCxT_XRee-bviE79-dBOTASYJkw"; //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTY2NjAyMywiaWF0IjoxNzI1NjQ4MDIzfQ.0X2FCYLScS1Tdnj-oy4x9j78_JDXI9UWBS04xTOtOd0SHBoKjNqoAC4XI4KnbYxFud9Fl6BmaKW_speV0gP5rA";  //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTY2MTg3MywiaWF0IjoxNzI1NjQzODczfQ.XlJ0vKHAXu_hyxLte7bygz-w_SG2qnMS561I-oFopk3Yz4rQiP2VgiT55lSf-tgoH9fryw2DotfAHRUXjSYQ7w" ; //"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyNTQ4NjM5MSwiaWF0IjoxNzI1NDY4MzkxfQ.kv7wx8ci9JYsW8SOdFf9zWUnfb-nPLAbX3DATUaTowb94wPUyF5KBKhKs51oxsHxaYg2QXaRLxolmxuBkk2hbA";

    }

    @Given("I have a valid book payload")
    public void i_have_a_valid_book_payload() {
        bookPayload = "{ \"title\": \"New Book\", \"author\": \"Author Name\" }"; // Example payload
    }

    @Given("I have an updated book payload")
    public void i_have_an_updated_book_payload() {
        updatedBookPayload = "{ \"title\": \"Updated Book\", \"author\": \"Updated Author\" }"; // Example payload
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        try{
            response = given()
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .get(endpoint);
            System.out.println("Response: " + response.prettyPrint());
        }
        catch (Exception e){
            System.out.println(" Error: " + e.getStackTrace());
        }
//        response = given()
//                .when()
//                .get("http://localhost:8080/api/books");

        System.out.println("endpoint:  " + endpoint);
    }

    @When("I send a POST request to {string} with payload")
    public void i_send_a_post_request_to_with_payload(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with the updated payload")
    public void i_send_a_put_request_to_with_the_updated_payload(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedValue) {
        JsonPath jsonPath = response.jsonPath();
        String s = String.valueOf(response.getBody());
        System.out.println("Responded as: " + s);
//        response.then().body("key", equalTo(expectedValue));
    }
    String payload;

    @And("I have the following payload:")
    public void iHaveTheFollowingPayload(String jsonPayload) {
        payload = jsonPayload;
    }
}
