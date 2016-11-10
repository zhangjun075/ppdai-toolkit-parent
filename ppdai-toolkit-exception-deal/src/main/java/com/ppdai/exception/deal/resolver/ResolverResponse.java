package com.ppdai.exception.deal.resolver;

import java.util.HashMap;
import java.util.Map;

/**
 * ResolverResponse
 */

public class ResolverResponse {

  // 返回数据集
  private Object data;

  // 成功标记
  private boolean success = true;

  // 提示信息
  private String message = "";

  // 错误码
  private String code = "";

  public ResolverResponse() {

  }

  public ResolverResponse(final boolean success, final String message, final String code) {
    this.success = success;
    this.message = message;
    this.code = code;
  }

  /**
   * 设置错误信息
   * 
   * @param msg
   * @param errorCode
   */
  public void setError(final String message, final String code) {
    this.success = false;
    this.message = message;
    this.code = code;
  }

  /**
   * 
   * @return :
   */
  public String getCode() {
    return this.code;
  }

  /**
   * 
   * @param errorCode
   *          :
   */
  public void setCode(final String code) {
    this.code = code;
  }

  /**
   * 
   * @return :
   */
  public Object getData() {
    if (null == data) {
      return new HashMap<String, Object>();
    }
    return data;
  }

  /**
   * 
   * @param rows
   *          :
   * @param count
   *          :
   */
  public void setData(Object rows, int count, boolean flag) {
    if (flag) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("rows", rows);
      map.put("count", count);
      this.data = map;
    } else {
      this.data = rows;
    }

  }

  /**
   * 
   * @param success
   *          :
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * msg
   * 
   * @return the msg
   */

  public String getMessage() {
    return this.message;
  }

  /**
   * @param msg
   *          the msg to set
   */

  public void setMessage(final String message) {
    this.message = message;
  }

  /**
   * set data
   * 
   * @param data
   *          The data to set. <br>
   */
  public void setData(Object data) {
    this.data = data;
  }

  /**
   * get success
   * 
   * @return Returns the success.<br>
   */
  public boolean isSuccess() {
    return success;
  }
}
