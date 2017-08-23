package com.work.attorney.services.store.impl;

import com.work.attorney.model.LoanAttachment;
import com.work.attorney.repository.LoanAttachmentRepository;
import com.work.attorney.services.store.ILoanAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanAttachmentService implements ILoanAttachmentService {

    @Autowired
    private LoanAttachmentRepository repository;

    @Override
    public Optional<LoanAttachment> findById(final Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }
}
