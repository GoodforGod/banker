package com.work.attorney;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.work.attorney.controllers.VerifyLoanRestController;
import org.junit.Before;

public class VerifyLoanRestTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new VerifyLoanRestController());
    }
}
