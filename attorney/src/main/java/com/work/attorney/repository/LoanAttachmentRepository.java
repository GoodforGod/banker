package com.work.attorney.repository;

import com.work.attorney.model.LoanAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAttachmentRepository extends JpaRepository<LoanAttachment, Long> {

}
