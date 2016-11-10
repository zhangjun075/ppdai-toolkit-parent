package com.ppdai.exception.deal.handler;

import com.ppdai.exception.BaseException;
import com.ppdai.exception.deal.AbstractExceptionHandler;
import com.ppdai.exception.deal.handler.repository.ExceptionHandlerRepository;
import com.ppdai.exception.enums.ExceptionSeverityEnum;

/**
 * mongodb记录异常日志
 */
public class MongoDBExceptionHandler<T> extends AbstractExceptionHandler {

  private ExceptionSeverityEnum severity = ExceptionSeverityEnum.Slight;

  private ExceptionHandlerRepository<T> exceptionHandlerRepository;

  public boolean support(BaseException baseException) {
    return baseException.getSeverity().getValue() >= severity.getValue();
  }

  @SuppressWarnings("unchecked")
  protected void doHandle(BaseException baseException) {
    T t = (T) baseException;
    exceptionHandlerRepository.save(t);
  }

  public void setSeverity(ExceptionSeverityEnum severity) {
    this.severity = severity;
  }

  public void setExceptionHandlerRepository(ExceptionHandlerRepository<T> exceptionHandlerRepository) {
    this.exceptionHandlerRepository = exceptionHandlerRepository;
  }

}
