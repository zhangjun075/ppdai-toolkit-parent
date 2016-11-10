package com.ppdai.support.bean;

import java.io.Serializable;

public class AbstractRequest<RH> implements Serializable {

	private static final long serialVersionUID = 4856863747056672764L;

	private RH requestHeader;

	public RH getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RH requestHeader) {
		this.requestHeader = requestHeader;
	}

}
