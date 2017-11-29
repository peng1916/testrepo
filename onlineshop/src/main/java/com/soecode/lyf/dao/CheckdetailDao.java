package com.soecode.lyf.dao;

import java.security.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Checks;

public interface CheckdetailDao {
	Checks queryById();
	List<Checks> queryList(@Param("offset") int offset, @Param("limit") int limit);
	List<Checks> queryListById(@Param("id") long id, @Param("offset") int offset, @Param("limit") int limit);
	List<Checks> queryListByCheckId(@Param("checkId") long checkId, @Param("offset") int offset, @Param("limit") int limit);
	int insert(@Param("checkTime") Timestamp checkTime, @Param("posNo") long posNo, 
			@Param("result") int result, @Param("resultId") long resultId );
	int update();
	
}
