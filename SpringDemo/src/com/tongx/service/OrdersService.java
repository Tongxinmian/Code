package com.tongx.service;


import org.springframework.transaction.annotation.Transactional;

import com.tongx.dao.OrdersDao;
@Transactional
public class OrdersService {
	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	public void accountMoney() {
		ordersDao.lessMoney();
		ordersDao.moreMoney();
	}
}
