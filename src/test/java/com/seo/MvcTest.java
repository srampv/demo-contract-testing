package com.seo;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author VenkPi
 */
public class MvcTest {

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }

}
