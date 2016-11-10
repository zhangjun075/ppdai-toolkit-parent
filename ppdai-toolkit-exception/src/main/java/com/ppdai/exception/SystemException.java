package com.ppdai.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;
import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * 系统操作异常基类 从BaseException继承
 */
public class SystemException extends BaseException {

  private static final long serialVersionUID = 61483967392077358L;

  /**
   * 构造SystemException基础异常类
   * 
   * @param module
   *          异常模块
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverity
   */
  public SystemException(final String code, final String message, final ExceptionSeverityEnum severity,
      Throwable cause) {
    super(ExceptionConsts.ModuleSystem, code, message, severity, cause);
  }

  /**
   * 构造SystemException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverity
   */
  public SystemException(final String code, final ExceptionSeverityEnum severity, Throwable cause) {
    super(ExceptionConsts.ModuleSystem, code, null, severity, cause);
  }

  /**
   * 构造SystemException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverity
   */
  public SystemException(final String code, final String message, final ExceptionSeverityEnum severity) {
    super(ExceptionConsts.ModuleSystem, code, message, severity);
  }

  /**
   * 构造SystemException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverity
   */
  public SystemException(final String code, final ExceptionSeverityEnum severity) {
    super(ExceptionConsts.ModuleSystem, code, null, severity);
  }

  /**
   * 构造SystemException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   */
  public SystemException(final String code, final String message) {
    super(ExceptionConsts.ModuleSystem, code, null, null);
  }

  /**
   * 构造SystemException基础异常类
   * 
   * @param message
   *          异常消息
   */
  public SystemException(final String message) {
    super(ExceptionConsts.ModuleSystem, null, message, null);
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
