package com.soecode.lyf.entity;

import java.security.Timestamp;

public class Checks {
	private long id;
	private Timestamp checkTime;
	private long posNo;
	private int result;
	private long resultId;
	
	public Checks(){
		
	}
	
	public Checks(long id, Timestamp checkTime, long posNo, int result, long resultId){
		this.id = id;
		this.checkTime = checkTime;
		this.posNo = posNo;
		this.result = result;
		this.resultId = resultId;
	}
	
	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public long getPosNo() {
		return posNo;
	}

	public void setPosNo(long posNo) {
		this.posNo = posNo;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public long getResultId() {
		return resultId;
	}

	public void setResultId(long resultId) {
		this.resultId = resultId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Checks:id=[" + this.id + "], resultId=[" + this.resultId + "]";
	}

}
