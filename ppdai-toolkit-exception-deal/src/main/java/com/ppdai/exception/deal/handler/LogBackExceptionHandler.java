package com.ppdai.exception.deal.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppdai.exception.BaseException;
import com.ppdai.exception.deal.AbstractExceptionHandler;
import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * LogbackExceptionHandler 打印异常日志
 */
public class LogBackExceptionHandler extends AbstractExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(LogBackExceptionHandler.class);

  private ExceptionSeverityEnum severity = ExceptionSeverityEnum.Slight;

  public boolean support(BaseException baseException) {
    return baseException.getSeverity().getValue() >= severity.getValue();
  }

  protected void doHandle(BaseException baseException) {
    logger.error(baseException.getMessage(), baseException);
  }

  public void setSeverity(ExceptionSeverityEnum severity) {
    this.severity = severity;
  }

}
