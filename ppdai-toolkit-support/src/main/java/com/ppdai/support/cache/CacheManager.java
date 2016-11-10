package com.ppdai.support.cache;

import java.io.Serializable;

import com.ppdai.exception.SystemException;

/**
 * 缓存管理器
 */
public interface CacheManager {

    /**
     * 保存至缓存
     * 
     * @param key
     * @param value
     * @param timeout
     *            单位秒
     * @throws SystemException
     */
    public void set(String key, Serializable value, long timeout) throws SystemException;

    /**
     * 保存至缓存
     * 
     * @param key
     * @param value
     * @throws SystemException
     */
    public void set(String key, Serializable value) throws SystemException;

    /**
     * 从缓存中读取
     * 
     * @param key
     * @return value
     * @throws SystemException
     */
    public Object get(String key) throws SystemException;

    /**
     * 从缓存中移除
     * 
     * @param key
     * @return result
     * @throws SystemException
     */
    public long del(String key) throws SystemException;

}
