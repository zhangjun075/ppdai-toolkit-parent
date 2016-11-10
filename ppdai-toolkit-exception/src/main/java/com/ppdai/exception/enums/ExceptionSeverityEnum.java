package com.ppdai.exception.enums;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public enum ExceptionSeverityEnum {

  Critical("C1", "critical", 1), Middle("M2", "middle", 2), Slight("S3", "slight", 3);

  private ExceptionSeverityEnum(final String code, final String name, final int value) {
    this.code = code;
    this.name = name;
    this.value = value;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public static ExceptionSeverityEnum getByCode(final String code) {
    if (StringUtils.isEmpty(code)) {
      return null;
    }
    for (ExceptionSeverityEnum severity : values()) {
      if (severity.code.equals(code)) {
        return severity;
      }
    }
    return null;
  }

  public static ExceptionSeverityEnum getByName(final String name) {
    if (StringUtils.isEmpty(name)) {
      return null;
    }
    for (ExceptionSeverityEnum severity : values()) {
      if (severity.name.equals(name)) {
        return severity;
      }
    }
    return null;
  }

  public static ExceptionSeverityEnum getByValue(final int value) {
    for (ExceptionSeverityEnum severity : values()) {
      if (severity.value == value) {
        return severity;
      }
    }
    return null;
  }

  private String code;

  private String name;

  private int value;

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

}
