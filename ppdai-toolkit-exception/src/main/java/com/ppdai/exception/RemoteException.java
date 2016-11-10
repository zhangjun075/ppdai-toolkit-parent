package com.ppdai.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;
import com.ppdai.exception.enums.ExceptionSeverityEnum;
import com.ppdai.utility.ExtStrings;

/**
 * 远程接口调用异常类 从BaseException继承
 * 
 * 远程接口提供方正常处理逻辑通过Code/Message方式进行传递，异常情况抛出RemoteException（包括超时和网络异常等），消费方捕获后处理。
 */
public class RemoteException extends Exception {

  private static final long serialVersionUID = 6663780729210911488L;

  /** 异常模块 */
  private String module = ExceptionConsts.ModuleRemote;
  /** 异常代码 */
  private String code = ExceptionConsts.UnknownCode;
  /** 异常消息 */
  private String message = ExceptionConsts.UnknownMessage;
  /** 异常级别 */
  private ExceptionSeverityEnum severity = ExceptionConsts.SeveritySlight;

  /**
   * 构造RemoteException基础异常类
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
  public RemoteException(final String module, final String code, final String message,
      final ExceptionSeverityEnum severity, Throwable cause) {
    super(cause);
    this.setModule(ExceptionConsts.ModuleRemote);
    this.setCode(ExtStrings.cleanas(code, ExceptionConsts.UnknownCode));
    this.setMessage(ExtStrings.cleanas(message, ExceptionConsts.UnknownMessage));
    if (severity != null) {
      this.setSeverity(severity);
    }
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverityEnum
   */
  public RemoteException(final String code, final String message, final ExceptionSeverityEnum severity,
      Throwable cause) {
    this(ExceptionConsts.ModuleRemote, code, message, severity, cause);
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverityEnum
   */
  public RemoteException(final String code, final ExceptionSeverityEnum severity, Throwable cause) {
    this(ExceptionConsts.ModuleRemote, code, null, severity, cause);
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverityEnum
   */
  public RemoteException(final String code, final String message, final ExceptionSeverityEnum severity) {
    this(ExceptionConsts.ModuleRemote, code, message, severity, null);
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param code
   *          异常代码
   * @param severity
   *          异常级别 @see imfenqi.exception.ExceptionSeverityEnum
   */
  public RemoteException(final String code, final ExceptionSeverityEnum severity) {
    this(ExceptionConsts.ModuleRemote, code, null, severity, null);
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param code
   *          异常代码
   * @param message
   *          异常消息
   */
  public RemoteException(final String code, final String message) {
    this(ExceptionConsts.ModuleRemote, code, null, null);
  }

  /**
   * 构造RemoteException基础异常类
   * 
   * @param message
   *          异常消息
   */
  public RemoteException(final String message) {
    this(ExceptionConsts.ModuleRemote, null, message, null, null);
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

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
