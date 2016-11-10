package com.ppdai.exception;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.ppdai.utility.ExtExceptions;

public class ExtExceptionsTest {

  @Test
  public void unchecked() {
    // convert Exception to RuntimeException with cause
    Exception exception = new Exception("my exception");
    RuntimeException runtimeException = ExtExceptions.unchecked(exception);
    Assert.assertEquals(exception, runtimeException.getCause());

    // do nothing of RuntimeException
    RuntimeException runtimeException2 = ExtExceptions.unchecked(runtimeException);
    Assert.assertEquals(runtimeException2, runtimeException);
  }

  @Test
  public void getStackTraceAsString() {
    Exception exception = new Exception("my exception");
    RuntimeException runtimeException = new RuntimeException(exception);

    String stack = ExtExceptions.getStackTraceAsString(runtimeException);
    System.out.println(stack);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void isCausedBy() {
    IOException ioexception = new IOException("my exception");
    IllegalStateException illegalStateException = new IllegalStateException(ioexception);
    RuntimeException runtimeException = new RuntimeException(illegalStateException);

    Assert.assertTrue(ExtExceptions.isCausedBy(runtimeException, IOException.class));
    Assert.assertTrue(ExtExceptions.isCausedBy(runtimeException, IllegalStateException.class, IOException.class));
    Assert.assertTrue(ExtExceptions.isCausedBy(runtimeException, Exception.class));
    Assert.assertTrue(!ExtExceptions.isCausedBy(runtimeException, IllegalAccessException.class));
  }

}
