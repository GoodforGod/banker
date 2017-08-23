package com.work.attorney.services.store;

import com.work.attorney.model.LoanAttachment;

import java.util.List;
import java.util.Optional;

public interface ILoanAttachmentService {
    Optional<LoanAttachment> create(final Long amount);

    Optional<LoanAttachment> find(final Long id);
    Optional<List<LoanAttachment>> findAll();

    void remove(final Long id);
}
