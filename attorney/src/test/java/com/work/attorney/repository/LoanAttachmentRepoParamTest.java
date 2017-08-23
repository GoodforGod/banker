package com.work.attorney.repository;

import com.work.attorney.model.LoanAttachment;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
@SpringBootTest
public class LoanAttachmentRepoParamTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private LoanAttachmentRepository repository;

    private Long loanAmount;

    public LoanAttachmentRepoParamTest(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {-100000L},
                {-100L},
                {0L},
                {100L},
                {1000000L}
        });
    }

    private LoanAttachment generateAttachment() {
        return new LoanAttachment(loanAmount);
    }

    @Test
    public void saveDifferentLoanAttachmentBalanceTest() {
        LoanAttachment saved = repository.save(generateAttachment());
        assertNotNull(saved);
    }
}
