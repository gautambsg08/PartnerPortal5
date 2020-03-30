package com.testgaap.partnerportalnew.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testgaap.partnerportalnew.app.model.OrderHistory;
import com.testgaap.partnerportalnew.app.repository.OrderHistoryRepository;

@Service
public class OrderHistoryService {
	
	@Autowired
	public OrderHistoryRepository ohRepository;
	
	public List<OrderHistory> findOrderHistory()
	{
		return (List<OrderHistory>) ohRepository.findAll();
	}
	
	public List<OrderHistory> findOrderHistoryByAccountNo(long account_no)
	{
		return ohRepository.findByAccount_no(account_no);
	}

}
