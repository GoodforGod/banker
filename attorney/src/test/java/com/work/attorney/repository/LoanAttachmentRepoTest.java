package com.work.attorney.repository;

import com.work.attorney.model.LoanAttachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LoanAttachmentRepoTest {

    @Autowired
    private LoanAttachmentRepository repository;

    private LoanAttachment generateAttachment() {
        return new LoanAttachment(ThreadLocalRandom.current().nextLong(0, 10000));
    }

    @Rollback
    @Test
    public void save() {
        LoanAttachment saved = repository.save(generateAttachment());
        assertNotNull(saved);
    }

    @Rollback
    @Test
    public void findExisted() {
        LoanAttachment saved = repository.save(generateAttachment());
        assertNotNull(saved);

        LoanAttachment found = repository.findOne(saved.getId());
        assertNotNull(found);
        assertEquals(saved.getAmount(), found.getAmount());
        assertEquals(saved.getId(), found.getId());
    }

    @Rollback
    @Test
    public void findWhoNotExist() {
        LoanAttachment found = repository.findOne(100L);
        assertNull(found);
    }

    @Rollback
    @Test
    public void removeExisted() {
        LoanAttachment saved = repository.save(generateAttachment());
        assertNotNull(saved);

        repository.delete(saved.getId());

        LoanAttachment found = repository.findOne(saved.getId());
        assertNull(found);
    }
}
