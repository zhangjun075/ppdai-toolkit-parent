package com.ppdai.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/**
 * 异常工具类，参考了guava的Throwables。
 */
public class ExtExceptions {

  /**
   * 将CheckedException转换为UncheckedException。
   */
  public static RuntimeException unchecked(Throwable ex) {
    if (ex instanceof RuntimeException) {
      return (RuntimeException) ex;
    } else {
      return new RuntimeException(ex);
    }
  }

  public static String getStackTrace(Throwable throwable) {
    return org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(throwable);
  }

  /**
   * 将ErrorStack转化为String。
   */
  public static String getStackTraceAsString(Throwable ex) {
    StringWriter stringWriter = new StringWriter();
    ex.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }

  /**
   * 获取组合本异常信息与底层异常信息的异常描述, 适用于本异常为统一包装异常类，底层异常才是根本原因的情况。
   */
  public static String getErrorMessageWithNestedException(Throwable ex) {
    Throwable nestedException = ex.getCause();
    return new StringBuilder().append(ex.getMessage()).append(" nested exception is ")
        .append(nestedException.getClass().getName()).append(":").append(nestedException.getMessage()).toString();
  }

  /**
   * 获取异常的RootCause。
   */
  public static Throwable getRootCause(Throwable ex) {
    Throwable rootCause = null;
    Throwable nextCause = ex.getCause();
    while (nextCause != null && !nextCause.equals(rootCause)) {
      rootCause = nextCause;
      nextCause = nextCause.getCause();
    }
    return rootCause;
  }

  /**
   * 判断异常是否由某些底层异常引起。
   */
  @SuppressWarnings("unchecked")
  public static boolean isCausedBy(Exception ex, Class<? extends Exception>... exceptionClasses) {
    Throwable cause = ex;
    while (cause != null) {
      for (Class<? extends Exception> causeClass : exceptionClasses) {
        if (causeClass.isInstance(cause)) {
          return true;
        }
      }
      cause = cause.getCause();
    }
    return false;
  }

  @SuppressWarnings("all")
  public static RuntimeException rethrow(Throwable tex) {
    while (tex instanceof InvocationTargetException)
      tex = ((InvocationTargetException) tex).getTargetException();
    if (tex instanceof RuntimeException)
      throw (RuntimeException) tex;
    if (tex instanceof Error)
      throw (Error) tex;
    throw new RuntimeException(tex);
  }
}
