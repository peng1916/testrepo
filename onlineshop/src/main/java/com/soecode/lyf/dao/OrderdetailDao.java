package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.OrderGroup;
import com.soecode.lyf.entity.Orderdetail;

public interface OrderdetailDao {
	/**
	 * 通过ID查询单本图书
	 * 
	 * @param id
	 * @return
	 */
	Orderdetail queryById(long id);

	/**
	 * 查询所有图书
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<Orderdetail> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<OrderGroup> querySum(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Orderdetail> queryAllByOrdersId(@Param("orderId") long orderId, @Param("offset") int offset, @Param("limit") int limit);
	
	List<Orderdetail> queryUnbuyedAllByOrdersId(@Param("orderId") long orderId, @Param("offset") int offset, @Param("limit") int limit);

	List<Orderdetail> queryUnbuyedAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Orderdetail> queryUnbuyedAllByProductId(@Param("productId") long productId, @Param("offset") int offset, @Param("limit") int limit);

	int insert(@Param("name") String name, @Param("quantity") int quantity, @Param("productId") long productId, @Param("orderId") long orderId, @Param("status") int status);
	
	int update(@Param("id") long id, @Param("quantity") int quantity, @Param("status") int status);
	/**
	 * 减少馆藏数量
	 * 
	 * @param id
	 * @param num
	 * @return 如果影响行数等于>num，表示更新的记录行数
	 */
	//int reduceNumber(long id, int num);
}
