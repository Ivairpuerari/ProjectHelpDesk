package com.ivairpuerari.helpDesk.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ivairpuerari.helpDesk.domain.User;
import com.ivairpuerari.helpDesk.repository.UserRepository;
import com.ivairpuerari.helpDesk.services.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public User findByEmail(String email) {
		return this.repo.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.repo.save(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return this.repo.findById(id);
	}

	@Override
	public void delete(String id) {
		this.repo.deleteById(id);	
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.repo.findAll(pages);
	}

}
