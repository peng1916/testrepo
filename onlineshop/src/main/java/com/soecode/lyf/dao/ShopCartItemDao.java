package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.ShopCartItem;

public interface ShopCartItemDao {
	/**
	 * 通过ID查询购物车
	 * 
	 * @param id
	 * @return
	 */	
	ShopCartItem queryById(@Param("user_id") long user_id, @Param("product_id") long product_id);

	/**
	 * 查询所有购物车
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<ShopCartItem> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 查询所有购物车
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<ShopCartItem> queryAllByUserId(@Param("user_id") long user_id, @Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 在购物车中插入新的商品
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	int insert( @Param("user_id") long user_id, @Param("product_id") long product_id, @Param("quantity") int quantity );
	
	/**
	 * 更新购物车中商品的数量
	 * 
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	int update( @Param("user_id") long user_id, @Param("product_id") long product_id, @Param("quantity") int quantity );

	/**
	 * 减少馆藏数量
	 * 
	 * @param id
	 * @param num
	 * @return 如果影响行数等于>num，表示更新的记录行数
	 */
	//int reduceNumber(long id, int num);

}
