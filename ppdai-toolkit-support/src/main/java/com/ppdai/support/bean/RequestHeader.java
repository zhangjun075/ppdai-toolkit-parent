package com.ppdai.support.bean;

import java.io.Serializable;
import java.util.Date;

public class RequestHeader implements Serializable {
	
	private static final long serialVersionUID = -7932140534476005290L;
	
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 来源
	 */
	private Integer source;
	/**
	 * 日期
	 */
	private Date date;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}