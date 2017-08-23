package com.work.attorney.service;

import com.work.attorney.model.LoanAttachment;
import com.work.attorney.services.store.impl.LoanAttachmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoanAttachmentServiceTest {

    @Autowired
    private LoanAttachmentService service;

    private Long generateAttachmentLoanAmount() {
        return ThreadLocalRandom.current().nextLong(1, 10000);
    }

    @Rollback
    @Test
    public void save() {
        Optional<LoanAttachment> saved = service.create(generateAttachmentLoanAmount());
        assertTrue(saved.isPresent());
    }

    @Rollback
    @Test
    public void findExisted() {
        Optional<LoanAttachment> saved = service.create(generateAttachmentLoanAmount());
        assertTrue(saved.isPresent());

        Optional<LoanAttachment> found = service.find(saved.get().getId());
        assertTrue(found.isPresent());
        assertEquals(saved.get().getAmount(), found.get().getAmount());
        assertEquals(saved.get().getId(), found.get().getId());
    }

    @Rollback
    @Test
    public void findWhoNotExist() {
        Optional<LoanAttachment> found = service.find(100L);
        assertFalse(found.isPresent());
    }

    @Rollback
    @Test
    public void findAllExisted() {
        Optional<LoanAttachment> saved1 = service.create(generateAttachmentLoanAmount());
        Optional<LoanAttachment> saved2 = service.create(generateAttachmentLoanAmount());
        Optional<LoanAttachment> saved3 = service.create(generateAttachmentLoanAmount());
        assertTrue(saved1.isPresent());
        assertTrue(saved2.isPresent());
        assertTrue(saved3.isPresent());

        Optional<List<LoanAttachment>> found = service.findAll();
        assertTrue(found.isPresent());
        assertFalse(found.get().isEmpty());
    }

    @Rollback
    @Test
    public void removeExisted() {
        Optional<LoanAttachment> saved = service.create(generateAttachmentLoanAmount());
        assertTrue(saved.isPresent());

        service.remove(saved.get().getId());

        Optional<LoanAttachment> found = service.find(saved.get().getId());
        assertFalse(found.isPresent());
    }
}
