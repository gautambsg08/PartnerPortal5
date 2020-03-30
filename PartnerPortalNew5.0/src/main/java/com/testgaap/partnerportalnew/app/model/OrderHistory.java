package com.testgaap.partnerportalnew.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderhistory")
public class OrderHistory {
	
	@Id
	@Column(name = "orderhistory_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderhistory_id;
	
	@Column(name = "account_no")
	private long account_no;
	
	
	@Column(name = "date")
	private Date date = new Date();
	
	@Column(name = "order_ref", unique=true)
	private String order_ref;
	
	@Column(name = "bt_order_ref", unique=true)
	private String bt_order_ref;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "service_type")
	private String service_type;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date_completed")
	private Date date_completed;

	public int getOrderhistory_id() {
		return orderhistory_id;
	}

	public void setOrderhistory_id(int orderhistory_id) {
		this.orderhistory_id = orderhistory_id;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrder_ref() {
		return order_ref;
	}

	public void setOrder_ref(String order_ref) {
		this.order_ref = order_ref;
	}

	public String getBt_order_ref() {
		return bt_order_ref;
	}

	public void setBt_order_ref(String bt_order_ref) {
		this.bt_order_ref = bt_order_ref;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate_completed() {
		return date_completed;
	}

	public void setDate_completed(Date date_completed) {
		this.date_completed = date_completed;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderhistory_id=" + orderhistory_id + ", account_no=" + account_no + ", date=" + date
				+ ", order_ref=" + order_ref + ", bt_order_ref=" + bt_order_ref + ", action=" + action
				+ ", service_type=" + service_type + ", status=" + status + ", date_completed=" + date_completed + "]";
	}
	
	

}
