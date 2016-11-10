package com.ppdai.exception.deal.handler;

import com.ppdai.exception.BaseException;
import com.ppdai.exception.deal.AbstractExceptionHandler;
import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * LogbackExceptionHandler 打印异常日志
 */
public class MailExceptionHandler extends AbstractExceptionHandler {

  @SuppressWarnings("unused")
  private ExceptionSeverityEnum severity = ExceptionSeverityEnum.Slight;

  public boolean support(BaseException baseException) {
    return false;
  }

  protected void doHandle(BaseException baseException) {
    //
  }

  public void setSeverity(ExceptionSeverityEnum severity) {
    this.severity = severity;
  }

}
