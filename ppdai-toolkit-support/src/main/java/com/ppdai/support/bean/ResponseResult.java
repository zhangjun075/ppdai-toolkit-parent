package com.ppdai.support.bean;

import java.io.Serializable;

public class ResponseResult implements Serializable {

	private static final long serialVersionUID = -2999652876415968351L;

	private String code;
	private String message;

	public ResponseResult() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}