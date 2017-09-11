/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 *
 * @author Farkas
 */
public class CalculatorTest {
    
   
    @Test
    public void testAdd() {
        given().when().get("/add/2/2")
                .then().body("result", equalTo(4));
    }

    @Test
    public void testSub() {
        given().when().get("/sub/3/1")
                .then().body("result", equalTo(2));
    }

    @Test
    public void testMul() {
        given().when().get("/mul/3/2")
                .then().body("result", equalTo(6));
    }

    @Test
    public void testDiv() {
        given().when().get("/div/2/1")
                .then().body("result", equalTo(2));
    }

    @Test
    public void testDivByZero() {
        given().when().get("/div/5/0")
                .then()
                .body("code", equalTo(500))
                .body("message", equalTo("/ by zero"));
    }
}
