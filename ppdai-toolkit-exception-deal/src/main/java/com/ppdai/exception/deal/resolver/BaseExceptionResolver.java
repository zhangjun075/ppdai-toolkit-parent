package com.ppdai.exception.deal.resolver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.ppdai.exception.BaseException;

/**
 * 通用异常返回值处理类
 */
public class BaseExceptionResolver extends SimpleMappingExceptionResolver {

  @Override
  public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
      Exception ex) {
    ResolverResponse rrvo = new ResolverResponse();
    rrvo.setSuccess(false);
    BaseException baseException = null;
    if (ex instanceof BaseException) {
      baseException = (BaseException) ex;
      rrvo.setCode(baseException.getCode());
      rrvo.setMessage(baseException.getMessage());
    } else {
      rrvo.setCode("500");
      rrvo.setMessage("unknow exception!");
    }
    write(response, rrvo);
    return null;
  }

  /**
   * 输出数据
   */
  protected void write(HttpServletResponse response, ResolverResponse result) {
    PrintWriter out = null;
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("success", result.isSuccess());
    map.put("message", result.getMessage());
    map.put("code", result.getCode());

    // Access-Control-Allow-Origin 指定一个允许向该服务器提交请求的URI，'*'表示允许来自所有域的请求
    // https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS#Access-Control-Allow-Origin
    response.setHeader("Access-Control-Allow-Origin", "*");
    // For JSON text: The MIME media type for JSON text is application/json.
    // The default encoding is UTF-8. (Source: RFC 4627).
    // For JSONP with callback: application/javascript
    response.setHeader("Content-Type", "application/json;charset=UTF-8");
    // Access-Control-Allow-Methods 指明资源可以被请求的方式有哪些，'*'表示允许所有的请求方法
    // https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS#Access-Control-Allow-Methods
    response.setHeader("Access-Control-Allow-Methods", "*");
    try {
      out = response.getWriter();
      out.write(JSON.toJSONString(map));
    } catch (IOException ioe) {
      logger.error(ioe.getMessage(), ioe);
    } finally {
      if (null != out) {
        out.flush();
        out.close();
      }
    }

  }
}
