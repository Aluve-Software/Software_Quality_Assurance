package tech.aluvesoftware.steps.rest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import tech.aluvesoftware.api.http.Request;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RestSteps {
    private Response response;
    private Request request;
    private String email;
    private String userPassword;

    public RestSteps() {
        request = new Request("https://reqres.in/api/");
    }

    @Given("the email is {string}")
    public void theIsARandomName(String username) {
        email = username;
    }

    @Given("the password is {string}")
    public void thePasswordIs(String password) {
        userPassword = password;
    }

    @When("the user sends the request")
    public void theUserSendsTheRequest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String requestBody = "{\n" +
                "    \"email\": \"%s\",\n" +
                "    \"password\": \"%s\"\n" +
                "}";
        request.setBody(String.format(requestBody,email, userPassword));
        request.setHeaders(headers);
        request.setHTTPMethod("POST");
        request.setEndPoint("register");
        request.build();
        response = request.send();
    }
    @Then("the response code is {string}")
    public void theResponseCodeIs(String code) {
        response.
                then().
                statusCode(Integer.parseInt(code));
    }

    @Then("the id is {string}")
    public void theIdIs(String id) {
       int responseId = response.getBody().jsonPath().getInt("id");
       assertEquals(responseId,Integer.parseInt(id));

    }

    @Then("the token is {string}")
    public void theTokenIs(String token) {
        String responseToken = response.getBody().jsonPath().getString("token");
        assertEquals(responseToken, token);
    }
}
