package com.ppdai.support.bean;

import java.io.Serializable;

public abstract class AbstractResponse<RR> implements Serializable {

	private static final long serialVersionUID = 5534594833343866897L;

	private RR responseResult;

	public RR getResponseResult() {
		return responseResult;
	}

	public void setResponseResult(RR responseResult) {
		this.responseResult = responseResult;
	}

}
