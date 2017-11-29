package com.soecode.lyf.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Orders;
import com.soecode.lyf.entity.User;

public interface OrdersDao {
	/**
	 * 通过ID查询单本图书
	 * 
	 * @param id
	 * @return
	 */
	Orders queryById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<Orders> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	List<Orders> queryFinishedAll(@Param("offset") int offset, @Param("limit") int limit);

	List<Orders> queryUnfinishedAll(@Param("offset") int offset, @Param("limit") int limit);
	
	int insert(@Param("orderTime") Timestamp orderTime, @Param("payTime") Timestamp payTime, 
			@Param("orderMoney") int orderMoney, @Param("orderSt") int orderSt, 
			@Param("address") String address, @Param("phone") String phone, 
			@Param("customId") long customId);
	
	int update(@Param("id") long id, @Param("orderSt") int orderSt);
	
	int insertOrder(Orders orders);
	/**
	 * 减少馆藏数量
	 * 
	 * @param id
	 * @param num
	 * @return 如果影响行数等于>num，表示更新的记录行数
	 */
	//int reduceNumber(long id, int num);
}
