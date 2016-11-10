package com.ppdai.exception.deal;

import org.springframework.core.task.TaskExecutor;

import com.ppdai.exception.BaseException;

/**
 * 异常处理类
 */
public abstract class AbstractExceptionHandler implements ExceptionHandler {

  /**
   * 异步处理标识
   */
  private boolean asyn = false;

  /**
   * 异步处理线程池
   */
  private TaskExecutor exceptionHandleExecutor;

  /**
   * 是否为链条中的最后一个处理器
   */
  private boolean isLast;

  public void handle(BaseException exception, ExceptionHandlerChain chain) {
    if (support(exception)) {
      if (asyn) {
        getExceptionHandleExecutor().execute(new AsyncHandler(exception));
      } else {
        doHandle(exception);
      }
    }
    if (!isLast()) {
      chain.handleException(exception);
    }
  }

  protected abstract void doHandle(BaseException ue);

  private class AsyncHandler implements Runnable {

    private BaseException exception;

    public AsyncHandler(BaseException ue) {
      this.exception = ue;
    }

    public void run() {
      doHandle(exception);
    }

  }

  public boolean getAsyn() {
    return asyn;
  }

  public void setAsyn(boolean asyn) {
    this.asyn = asyn;
  }

  public TaskExecutor getExceptionHandleExecutor() {
    return exceptionHandleExecutor;
  }

  public void setExceptionHandleExecutor(TaskExecutor exceptionHandleExecutor) {
    this.exceptionHandleExecutor = exceptionHandleExecutor;
  }

  public boolean isLast() {
    return isLast;
  }

  public void setLast(boolean isLast) {
    this.isLast = isLast;
  }

}
