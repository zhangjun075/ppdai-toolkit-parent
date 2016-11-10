package com.ppdai.exception.deal;

import org.springframework.core.task.TaskExecutor;

import com.ppdai.exception.BaseException;

/**
 * 使用责任链模式进行异常管理，支持异步方式处理<br>
 * 
 * 异常的处理以责任链的方式进行 @see imfenqi.exception.ExceptionHandlerChain<br>
 * 异常异步处理线程池 @see org.springframework.core.task.TaskExecutor<br>
 * 使用统一的异常定义 @see imfenqi.exception.BaseException<br>
 * 可自定义异常处理类 @see imfenqi.exception.AbstractExceptionHandler
 */
public class ExceptionManager {

  /**
   * 异常处理链
   */
  private ExceptionHandlerChain exceptionHandlerChain;

  /**
   * 异步处理线程池
   */
  private TaskExecutor asyncExecutor;

  public void publish(BaseException exception) {
    accept(exception);
  }

  public void publishAndThrow(BaseException exception) throws BaseException {
    accept(exception);
    throw exception;
  }

  /**
   * 接受并处理异常
   */
  protected void accept(BaseException exception) {
    // 如果已经处理过，则不继续处理
    if (!exception.isHandled()) {
      exceptionHandlerChain.handleException(exception);
      exception.setHandled(true);
    }
  }

  public ExceptionHandlerChain getExceptionHandlerChain() {
    return exceptionHandlerChain;
  }

  public void setExceptionHandlerChain(ExceptionHandlerChain exceptionHandlerChain) {
    this.exceptionHandlerChain = exceptionHandlerChain;
  }

  public TaskExecutor getAsyncExecutor() {
    return asyncExecutor;
  }

  public void setAsyncExecutor(TaskExecutor asyncExecutor) {
    this.asyncExecutor = asyncExecutor;
  }

}
