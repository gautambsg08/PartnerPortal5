package com.testgaap.partnerportalnew.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.testgaap.partnerportalnew.app.model.OrderHistory;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Integer>{

		List<OrderHistory> findAll();
		
		@Query("FROM OrderHistory where account_no = ?1")
		List<OrderHistory> findByAccount_no(long account_no);
	}


