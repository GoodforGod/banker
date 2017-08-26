package com.work.attorney.services.store.impl;

import com.work.attorney.model.LoanAttachment;
import com.work.attorney.repository.LoanAttachmentRepository;
import com.work.attorney.services.store.ILoanAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanAttachmentService implements ILoanAttachmentService {

    private final LoanAttachmentRepository repository;

    @Autowired
    public LoanAttachmentService(LoanAttachmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<LoanAttachment> create(final Long amount) {
        return Optional.ofNullable(repository.save(new LoanAttachment(amount)));
    }

    @Override
    public Optional<LoanAttachment> find(final Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public Optional<List<LoanAttachment>> findAll() {
        List<LoanAttachment> loans = repository.findAll();
        return (loans == null || loans.isEmpty())
                ? Optional.empty()
                : Optional.of(loans);
    }

    @Override
    public void remove(final Long id) {
        repository.delete(id);
    }
}
