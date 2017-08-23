package com.work.attorney.services.store;

import com.work.attorney.model.LoanAttachment;

import java.util.Optional;

public interface ILoanAttachmentService {
    Optional<LoanAttachment> findById(final Long id);
}
