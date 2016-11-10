package com.ppdai.utility;

import org.apache.commons.lang3.StringUtils;

public class ExtStrings {

  /**
   * 当参数为null或长度为零时返回""，否则返回trim后的字串。
   */
  public static String clean(final String clean) {
    return StringUtils.isEmpty(clean) ? "" : clean.trim();
  }

  /**
   * 当参数为null或长度为零时返回asdefault，否则返回trim后的字串。
   */
  public static String cleanas(final String clean, final String asdefault) {
    return StringUtils.isEmpty(clean) ? asdefault.trim() : clean.trim();
  }
}
