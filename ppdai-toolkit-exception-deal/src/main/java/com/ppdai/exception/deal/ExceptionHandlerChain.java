package com.ppdai.exception.deal;

import java.util.LinkedList;
import java.util.List;

import com.ppdai.exception.BaseException;

/**
 * 异常处理链<br>
 * 
 * 异常处理类 @see imfenqi.exception.AbstractExceptionHandler
 */
public class ExceptionHandlerChain {

  private List<AbstractExceptionHandler> chain = new LinkedList<AbstractExceptionHandler>();

  /**
   * 当前下标
   */
  private ThreadLocal<Integer> index = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return Integer.valueOf(0);
    }
  };

  /**
   * 循环处理异常
   */
  public boolean handleException(BaseException baseException) {
    Integer currentIndex = index.get();
    boolean isLast = false;
    if (currentIndex < chain.size()) {
      if (currentIndex == chain.size() - 1) {
        isLast = true;
        index.remove();
      } else {
        index.set(currentIndex + 1);
      }
      chain.get(currentIndex).setLast(isLast);
      chain.get(currentIndex).handle(baseException, this);
    }
    return true;
  }

  public List<AbstractExceptionHandler> getChain() {
    return chain;
  }

  public void setChain(List<AbstractExceptionHandler> chain) {
    this.chain = chain;
  }

}
