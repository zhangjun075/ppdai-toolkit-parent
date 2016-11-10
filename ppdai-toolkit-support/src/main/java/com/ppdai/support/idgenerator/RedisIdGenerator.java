package com.ppdai.support.idgenerator;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.ppdai.exception.SystemException;

/**
 * 依赖于redis实现的id生成器
 */
public class RedisIdGenerator implements IdGenerator {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(RedisIdGenerator.class);

    /**
     * 缓存key前缀
     */
    private static final String IDGENERATOR_KEY_PREFIX = "rds_idgenerator_";

    /**
     * RedisTemplate
     */
    private RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 设置 redisTemplate
     * 
     * @param redisTemplate
     *            the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public long nextId(final String namespace) throws SystemException {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incrBy(getStringSerializer().serialize(IDGENERATOR_KEY_PREFIX + namespace), 1L);
            }
        });
    }

    @Override
    public long currentId(final String namespace) throws SystemException {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] retDate = connection.get(getStringSerializer().serialize(IDGENERATOR_KEY_PREFIX + namespace));
                if (retDate != null && retDate.length > 0) {
                    String valueStr = getStringSerializer().deserialize(retDate);
                    return Long.parseLong(valueStr);
                }
                return -1L;
            }
        });
    }

    @Override
    public boolean setValue(final String namespace, final long value) throws SystemException {
        return execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(getStringSerializer().serialize(IDGENERATOR_KEY_PREFIX + namespace),
                        getStringSerializer().serialize(String.valueOf(value)));
            }
        });
    }

    /**
     * 获取StringSerializer
     * 
     * @return StringSerializer
     */
    private RedisSerializer<String> getStringSerializer() {
        return redisTemplate.getStringSerializer();
    }

    /**
     * 执行redis
     * 
     * @param action
     * @return T
     * @throws SystemException 
     */
    private <T> T execute(RedisCallback<T> action) throws SystemException {
        try {
            return redisTemplate.execute(action);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new SystemException(ex.getMessage());
        }
    }

}
