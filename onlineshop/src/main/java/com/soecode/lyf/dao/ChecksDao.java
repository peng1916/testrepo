package com.soecode.lyf.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Checks;

public interface ChecksDao {
	Checks queryById(@Param("id") long id);
	List<Checks> queryList(@Param("offset") int offset, @Param("limit") int limit);
	List<Checks> queryListSuccess(@Param("offset") int offset, @Param("limit") int limit);
	List<Checks> queryListFail(@Param("offset") int offset, @Param("limit") int limit);

	//List<Checks> queryListById(@Param("id") long id, @Param("offset") int offset, @Param("limit") int limit);
	Checks queryListByResultId(@Param("resultId") long resultId);
	int insert(@Param("checkTime") Timestamp checkTime, @Param("posNo") long posNo, 
			@Param("result") int result, @Param("resultId") long resultId );
	int update();
}
