package cn.amos.security.core.service.impl;

import cn.amos.security.core.service.CacheService;
import cn.amos.security.core.pojo.vo.MessageVO;
import com.alibaba.fastjson.JSON;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2020-03-26
 */
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    /**
     * - @Cacheable 缓存中有值 ? 取 : 调用方法, 放入缓存;
     */
    @Override
    @Cacheable(value = "hello", key = "'message_' + #id")
    public String findMessage(Integer id) {
        MessageVO message = new MessageVO();
        message.setId(id);
        message.setTitle("滕王阁序");
        message.setTime(System.currentTimeMillis());
        message.setContent("落霞与孤鹜齐飞，秋水共长天一色。");
        return JSON.toJSONString(message);
    }

    /**
     * - @CachePut 无条件调用方法, 并放入缓存;
     */
    @Override
    @CachePut(value = "hello", key = "'message_' + #id")
    public String findMessage2(Integer id) {
        MessageVO message = new MessageVO();
        message.setId(id);
        message.setTitle("岳阳楼记");
        message.setTime(System.currentTimeMillis());
        message.setContent("先天下之忧而忧，后天下之乐而乐。");
        return JSON.toJSONString(message);
    }

    /**
     * - @CacheEvict 清除缓存中一个或多个条目;
     */
    @Override
    @CacheEvict(value = "hello", key = "'message_' + #id", condition = "#id != null")
    public String delMessage(Integer id) {
        return "Message 缓存删除成功！";
    }

    /**
     * - @Caching 分组注解, 可组合多种/多个注解;
     */
    @Override
    @Caching(cacheable = @Cacheable(value = "hello"), evict = @CacheEvict(value = "hello"), put = @CachePut(value = "hello"))
    public void groupMessage(Integer id) {
    }

}
