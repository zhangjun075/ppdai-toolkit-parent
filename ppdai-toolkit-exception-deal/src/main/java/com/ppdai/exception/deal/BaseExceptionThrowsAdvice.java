package com.ppdai.exception.deal;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import com.ppdai.exception.BaseException;

/**
 * 切面统一异常处理，仅处理BaseException，若使用该切面配置，请在业务代码里抛出BaseException。
 */
public class BaseExceptionThrowsAdvice implements ThrowsAdvice {

  private Logger logger = LoggerFactory.getLogger(BaseExceptionThrowsAdvice.class);

  /**
   * 异常处理器
   */
  private ExceptionManager exceptionManager;

  /**
   * 对于统一异常的处理
   */
  public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
    if (ex instanceof BaseException) {
      BaseException exception = (BaseException) ex;
      exceptionManager.publish(exception);
    } else {
      logger.error("unkown exception", ex);
    }
  }

  public ExceptionManager getExceptionManager() {
    return exceptionManager;
  }

  public void setExceptionManager(ExceptionManager exceptionManager) {
    this.exceptionManager = exceptionManager;
  }

}
