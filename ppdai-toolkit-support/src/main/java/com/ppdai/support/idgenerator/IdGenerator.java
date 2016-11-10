package com.ppdai.support.idgenerator;

import com.ppdai.exception.SystemException;

/**
 * id生成器
 */
public interface IdGenerator {

    /**
     * Generates next id.
     * 
     * @return next id for the specified namespace as a long, {@code 0} if not
     *         supported or invalid namespace, negative value if error.
     */
    public long nextId(String namespace) throws SystemException;

    /**
     * Gets current id.
     * 
     * @param namespace
     * @return current id for the specified namespace as long, negative value if
     *         error.
     * @since 0.2.0
     */
    public long currentId(String namespace) throws SystemException;

    /**
     * 给namespace初始化值value 同一namesapce只能设置一次，多次设置无效
     * 
     * @param namespace
     * @param value
     * @return 成功
     */
    public boolean setValue(String namespace, final long value) throws SystemException;

}
