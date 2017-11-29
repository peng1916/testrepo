package com.soecode.lyf.service;

import java.sql.Timestamp;
import java.util.List;

import com.soecode.lyf.entity.Checks;

public interface ChecksService {

	Checks getById(long id);
	
	Checks getByResultId(long id);

	List<Checks> getList();
	
	List<Checks> getSuccessList();
	
	List<Checks> getFailList();
	
	int insert(Timestamp checkTime, long posNo, int result, long resultId);
}
