package com.ppdai.utility;

import java.util.UUID;

public class RandomUtil {
	
	public static final String UUIDLite(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
