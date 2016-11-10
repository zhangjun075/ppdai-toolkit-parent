package com.ppdai.exception.deal;

import com.ppdai.exception.BaseException;

/**
 * 异常处理接口
 */
public interface ExceptionHandler extends HandlerSupport {

  /**
   * 处理异常
   * 
   * @param baseException
   *          baseException异常
   * @param exceptionHandlerChain
   *          异常处理链
   */
  public void handle(BaseException baseException, ExceptionHandlerChain exceptionHandlerChain);

}
