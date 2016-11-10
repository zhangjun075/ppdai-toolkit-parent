package com.ppdai.exception.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;

public enum SystemExceptionEnum {

  SystemError("Error", "系统异常", ExceptionSeverityEnum.Critical), 
  SystemNotyetSupported("NotyetSupported", "系统不支持", ExceptionSeverityEnum.Critical);

  private SystemExceptionEnum(final String code, final String message,
      final ExceptionSeverityEnum severity) {
    this.module = ExceptionConsts.ModuleSystem;
    this.code = code;
    this.message = message;
    this.severity = severity;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public static SystemExceptionEnum getByCode(final String code) {
    if (StringUtils.isEmpty(code)) {
      return null;
    }
    for (SystemExceptionEnum exception : values()) {
      if (exception.code.equals(code)) {
        return exception;
      }
    }
    return null;
  }

  public static SystemExceptionEnum getByMessage(final String message) {
    if (StringUtils.isEmpty(message)) {
      return null;
    }
    for (SystemExceptionEnum exception : values()) {
      if (exception.message.equals(message)) {
        return exception;
      }
    }
    return null;
  }

  private String module = ExceptionConsts.ModuleSystem;
  private String code;
  private String message;
  private ExceptionSeverityEnum severity;

  public String getModule() {
    return module;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public ExceptionSeverityEnum getSeverity() {
    return severity;
  }

}
