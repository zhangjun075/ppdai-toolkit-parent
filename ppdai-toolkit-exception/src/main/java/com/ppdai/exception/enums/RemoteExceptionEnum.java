package com.ppdai.exception.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;

public enum RemoteExceptionEnum {

  RemoteError("Error", "远程方法异常", ExceptionSeverityEnum.Critical), 
  RemoteWarning("Warning", "远程方法警告", ExceptionSeverityEnum.Slight);

  private RemoteExceptionEnum(final String code, final String message,
      final ExceptionSeverityEnum severity) {
    this.code = code;
    this.message = message;
    this.severity = severity;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public static RemoteExceptionEnum getByCode(final String code) {
    if (StringUtils.isEmpty(code)) {
      return null;
    }
    for (RemoteExceptionEnum exception : values()) {
      if (exception.code.equals(code)) {
        return exception;
      }
    }
    return null;
  }

  public static RemoteExceptionEnum getByMessage(final String message) {
    if (StringUtils.isEmpty(message)) {
      return null;
    }
    for (RemoteExceptionEnum exception : values()) {
      if (exception.message.equals(message)) {
        return exception;
      }
    }
    return null;
  }

  private String module = ExceptionConsts.ModuleRemote;
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
