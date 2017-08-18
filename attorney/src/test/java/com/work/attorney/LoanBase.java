package com.work.attorney;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.work.attorney.controllers.VerifyLoanRestController;
import com.work.attorney.services.impl.AttorneyService;
import org.junit.Before;

public class LoanBase {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new VerifyLoanRestController(new AttorneyService()));
    }
}
