/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.BeforeClass;

/**
 *
 * @author Farkas
 */
public class ServiceIntegrationTest { 
  
    @BeforeClass
    public static void setUpBeforeAll() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8080;
    RestAssured.basePath = "/Test1";
    RestAssured.defaultParser = Parser.JSON;
  }

}
