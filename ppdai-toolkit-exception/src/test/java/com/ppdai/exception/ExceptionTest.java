package com.ppdai.exception;

import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * Created by Yin on 15/6/28.
 */
public class ExceptionTest {

  public static void main(String[] agrs) throws BaseException {
    BaseException sysex = new SystemException("999999", "系统异常，请稍后重试。", ExceptionSeverityEnum.Critical);
    throw sysex;
  }
}
