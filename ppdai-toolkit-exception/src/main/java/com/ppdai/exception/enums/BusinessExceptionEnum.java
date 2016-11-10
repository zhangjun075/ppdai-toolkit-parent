package com.ppdai.exception.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ppdai.exception.consts.ExceptionConsts;

public enum BusinessExceptionEnum {

  BusinessError("Error", "业务异常", ExceptionSeverityEnum.Critical), 
  BusinessNotyetImplemented("NotyetImplemented", "业务未实现", ExceptionSeverityEnum.Critical);

  private BusinessExceptionEnum(final String code, final String message, final ExceptionSeverityEnum severity) {
    this.module = ExceptionConsts.ModuleBusiness;
    this.code = code;
    this.message = message;
    this.severity = severity;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public static BusinessExceptionEnum getByCode(final String code) {
    if (StringUtils.isEmpty(code)) {
      return null;
    }
    for (BusinessExceptionEnum exception : values()) {
      if (exception.code.equals(code)) {
        return exception;
      }
    }
    return null;
  }

  public static BusinessExceptionEnum getByMessage(final String message) {
    if (StringUtils.isEmpty(message)) {
      return null;
    }
    for (BusinessExceptionEnum exception : values()) {
      if (exception.message.equals(message)) {
        return exception;
      }
    }
    return null;
  }

  private String module = ExceptionConsts.ModuleBusiness;
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
