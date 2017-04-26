package cn.fintecher.print.config;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by sun on 2017/4/25 0025.
 */
public class DefaultRedisTemplate extends RedisTemplate<Object,Object> {
    public DefaultRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        setConnectionFactory(jedisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        setKeySerializer(stringRedisSerializer);
        setHashKeySerializer(stringRedisSerializer);
    }

}
