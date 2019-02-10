package com.ivairpuerari.helpDesk.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ivairpuerari.helpDesk.domain.ChangeStatus;
import com.ivairpuerari.helpDesk.domain.Ticket;
import com.ivairpuerari.helpDesk.repository.ChangeStatusRepository;
import com.ivairpuerari.helpDesk.repository.TicketRepository;
import com.ivairpuerari.helpDesk.services.TicketService;
@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepo;
	@Autowired
	private ChangeStatusRepository changeStatusRepo;
	
	@Override
	public Ticket createOrUpdate(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Optional<Ticket> findById(String id) {
		return ticketRepo.findById(id);
	}

	@Override
	public void delete(String id) {
		ticketRepo.deleteById(id);
		
	}

	@Override
	public Page<Ticket> listTicket(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return ticketRepo.findAll(pages);
	}

	@Override
	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return changeStatusRepo.save(changeStatus);
	}
	

	@Override
	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return changeStatusRepo.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}

	@Override
	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		Pageable pages = PageRequest.of(page, count);
		return ticketRepo.findByUserIdOrderByDateDesc(pages, userId);
	}

	@Override
	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		return ticketRepo.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(title, status, priority, PageRequest.of(page, count));
	}

	@Override
	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		return ticketRepo.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndUserIdOrderByDateDesc(title, status, priority, userId,PageRequest.of(page, count));
	}

	@Override
	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		return ticketRepo.findByNumber(number, PageRequest.of(page, count));
	}

	@Override
	public Iterable<Ticket> findAll() {
		return ticketRepo.findAll();
	}

	@Override
	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		return ticketRepo.findByTitleIgnoreCaseContainingAndStatusContainingAndPriorityContainingAndAssignedUserIdOrderByDateDesc(title, status, priority, assignedUser,PageRequest.of(page, count));
	}

}
