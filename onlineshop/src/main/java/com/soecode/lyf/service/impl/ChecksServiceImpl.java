package com.soecode.lyf.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.ChecksDao;
import com.soecode.lyf.entity.Checks;
import com.soecode.lyf.service.ChecksService;

@Service
public class ChecksServiceImpl implements ChecksService{
	@Autowired
	private ChecksDao checksDao;
	
	@Override
	public Checks getById(long id) {
		// TODO Auto-generated method stub
		return checksDao.queryById(id);
	}

	@Override
	public Checks getByResultId(long id) {
		// TODO Auto-generated method stub
		return checksDao.queryListByResultId(id);
	}

	@Override
	public List<Checks> getList() {
		// TODO Auto-generated method stub
		return checksDao.queryList(0, 1000);
	}

	@Override
	public List<Checks> getSuccessList() {
		// TODO Auto-generated method stub
		return checksDao.queryListSuccess(0, 1000);
	}

	@Override
	public List<Checks> getFailList() {
		// TODO Auto-generated method stub
		return checksDao.queryListFail(0, 1000);
	}

	@Override
	public int insert(Timestamp checkTime, long posNo, int result, long resultId) {
		// TODO Auto-generated method stub
		return checksDao.insert(checkTime, posNo, result, resultId);
	}

}
