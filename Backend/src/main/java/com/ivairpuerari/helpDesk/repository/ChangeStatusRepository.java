package com.ivairpuerari.helpDesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ivairpuerari.helpDesk.domain.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
