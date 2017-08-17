package com.work.attorney;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.work.attorney.controllers.VerifyLoanRestController;
import org.junit.Before;

public class AttorneyLoanResponseTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new VerifyLoanRestController());
    }
}
