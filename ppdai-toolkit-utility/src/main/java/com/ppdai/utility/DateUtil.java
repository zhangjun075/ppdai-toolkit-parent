package com.ppdai.utility;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	private static final Logger Logger = LoggerFactory.getLogger(DateUtil.class);

	private static final DateTimeFormatter shortFMT = DateTimeFormat.forPattern("yyyyMMdd");
	
	@SuppressWarnings("unused")
    private static final DateTimeFormatter shortFMTHyphen = DateTimeFormat.forPattern("yyyy-MM-dd");

	@SuppressWarnings("unused")
	private static final DateTimeFormatter fullFMT = DateTimeFormat.forPattern("yyyyMMddHHmmss");
	
	@SuppressWarnings("unused")
	private static final DateTimeFormatter fullFMTHyphenComma = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	public static final Date getNow() {
		return new DateTime().toDate();
	}

	public static final Date getDate(final String yyyyMMdd) {
		Date date = null;
		try{
			date = shortFMT.parseDateTime(yyyyMMdd).toDate();
		}catch(Exception ex){
		  Logger.error(ex.getMessage(), ex);
		  ex.printStackTrace();
		}finally{
			//
		}
		return date;
	}

	public static final String yyyyMMddHHmmssSSS(final Date date) {
		return new DateTime(date).toString("yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	public static final String yyyyMMddHHmmss(final Date date) {
		return new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
	}

	public static final String yyyyMMdd(final Date date) {
		return new DateTime(date).toString("yyyyMMdd");
	}

	public static final String yyyyMMddHyphen(final Date date) {
		return new DateTime(date).toString("yyyy-MM-dd");
	}

	public static void main(String[] args) {
	  //
	}
}
