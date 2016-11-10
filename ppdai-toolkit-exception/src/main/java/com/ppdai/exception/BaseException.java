package com.ppdai.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;
import com.ppdai.exception.enums.ExceptionSeverityEnum;
import com.ppdai.utility.ExtStrings;

/**
 * exingcai脚手架基础异常类 从Exception继承
 */
public class BaseException extends Exception {

  private static final long serialVersionUID = -8943623760552019394L;

  /** 异常模块 */
  private String module = ExceptionConsts.UnknownMessage;
  /** 异常代码 */
  private String code = ExceptionConsts.UnknownCode;
  /** 异常消息 */
  private String message = ExceptionConsts.UnknownMessage;
  /** 异常级别 */
  private ExceptionSeverityEnum severity = ExceptionConsts.SeveritySlight;

  /** 异常是否已经被处理 */
  private boolean handled = false;

  /**
   * 构造BaseException基础异常类
   */
  public BaseException() {
    super();
  }

  /**
   * 构造BaseException基础异常类
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
   *          the throwable which caused this BaseException
   */
  public BaseException(final String module, final String code, final String message,
      final ExceptionSeverityEnum severity, Throwable cause) {
    super(cause);
    this.setModule(ExtStrings.cleanas(module, ExceptionConsts.UnknownMessage));
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
    if (severity != null) {
      this.setSeverity(severity);
    }
  }

  /**
   * 构造BaseException基础异常类
   * 
   * @param module
   *          异常模块
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   */
  public BaseException(final String module, final String code, final String message,
      final ExceptionSeverityEnum severity) {
    super();
    this.setModule(ExtStrings.cleanas(module, ExceptionConsts.UnknownMessage));
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
    if (severity != null) {
      this.setSeverity(severity);
    }
  }

  /**
   * 构造BaseException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   */
  public BaseException(final String code, final String message, final ExceptionSeverityEnum severity) {
    super();
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
    if (severity != null) {
      this.setSeverity(severity);
    }
  }

  /**
   * 构造BaseException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.enums.ExceptionSeverityEnum
   */
  public BaseException(final String code, final ExceptionSeverityEnum severity) {
    super();
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    if (severity != null) {
      this.setSeverity(severity);
    }
  }

  /**
   * 构造BaseException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   */
  public BaseException(final String code, final String message) {
    super();
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
  }

  /**
   * 构造BaseException基础异常类
   * 
   * @param message
   *          异常消息
   */
  public BaseException(final String message) {
    super();
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
  }

  /**
   * 获取 异常代码
   *
   * @return 异常代码
   */
  public String getCode() {
    return code;
  }

  /**
   * 设置 异常代码
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * 获取 异常信息
   *
   * @return 异常信息
   */
  public String getMessage() {
    return message;
  }

  /**
   * 设置 异常信息
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * 获取 异常级别
   *
   * @return 异常级别
   */
  public ExceptionSeverityEnum getSeverity() {
    return severity;
  }

  /**
   * 设置 异常级别
   */
  public void setSeverity(ExceptionSeverityEnum severity) {
    this.severity = severity;
  }

  /**
   * 获取 异常模块
   *
   * @return 异常模块
   */
  public String getModule() {
    return module;
  }

  /**
   * 设置 异常模块
   */
  public void setModule(String module) {
    this.module = module;
  }

  /**
   * 获取 异常是否已经被处理
   *
   * @return 异常是否已经被处理
   */
  public boolean isHandled() {
    return handled;
  }

  /**
   * 设置 异常是否已经被处理
   */
  public void setHandled(boolean handled) {
    this.handled = handled;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
