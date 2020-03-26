package cn.amos.security.core.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * PROJECT: security
 * DESCRIPTION: 开启 @EnableCaching 很重要
 *
 * @author Daoyuan
 * @date 2020-03-26
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /*
     * 操作string redisTemplate.opsForValue();
     * 操作hash redisTemplate.opsForHash();
     * 操作list redisTemplate.opsForList();
     * 操作set redisTemplate.opsForSet();
     * 操作有序set redisTemplate.opsForZSet();
     */

    /**
     * init cache manager
     *
     * @param connectionFactory Redis连接 Factory
     * @return CacheManager
     */
    @Bean("cacheManager")
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        // 设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);
        // 设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        // 初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }

}
