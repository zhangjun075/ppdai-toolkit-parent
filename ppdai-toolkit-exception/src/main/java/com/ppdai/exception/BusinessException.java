package com.ppdai.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;
import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * 业务处理异常基类 从BaseException继承
 */
public class BusinessException extends BaseException {

  private static final long serialVersionUID = -4011725163070471891L;

  /**
   * 构造BusinessException基础异常类
   * 
   * @param module
   *          异常模块
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   * @param cause
   *          the throwable which caused this BusinessException
   */
  public BusinessException(final String code, final String message, final ExceptionSeverityEnum severity,
      Throwable cause) {
    super(ExceptionConsts.ModuleBusiness, code, message, severity, cause);
  }

  /**
   * 构造BusinessException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   * @param cause
   *          the throwable which caused this BusinessException
   */
  public BusinessException(final String code, final ExceptionSeverityEnum severity, Throwable cause) {
    super(ExceptionConsts.ModuleBusiness, code, null, severity, cause);
  }

  /**
   * 构造BusinessException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   */
  public BusinessException(final String code, final String message, final ExceptionSeverityEnum severity) {
    super(ExceptionConsts.ModuleBusiness, code, message, severity);
  }

  /**
   * 构造BusinessException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   */
  public BusinessException(final String code, final ExceptionSeverityEnum severity) {
    super(ExceptionConsts.ModuleBusiness, code, null, severity);
  }

  /**
   * 构造BusinessException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   */
  public BusinessException(final String code, final String message) {
    super(ExceptionConsts.ModuleBusiness, code, null, null);
  }

  /**
   * 构造BusinessException基础异常类
   * 
   * @param message
   *          异常消息
   */
  public BusinessException(final String message) {
    super(ExceptionConsts.ModuleBusiness, null, message, null);
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
