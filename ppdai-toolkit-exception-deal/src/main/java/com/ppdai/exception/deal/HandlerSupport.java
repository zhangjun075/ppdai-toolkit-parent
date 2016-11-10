package com.ppdai.exception.deal;

import com.ppdai.exception.BaseException;

/**
 * 异常处理支持接口
 */
public interface HandlerSupport {

  /**
   * 是否支持该异常处理
   */
  public boolean support(BaseException exception);
  
}
