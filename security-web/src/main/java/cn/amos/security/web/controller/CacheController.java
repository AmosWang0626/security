package cn.amos.security.web.controller;

import cn.amos.security.core.service.CacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2018/11/16
 */
@RestController
public class CacheController {

    @Resource
    private CacheService cacheService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 测试缓存
     *
     * @param id 缓存对应唯一参数
     * @return message vo
     */
    @RequestMapping(value = "add/{id}", method = RequestMethod.GET)
    public String message(@PathVariable("id") Integer id) {
        return cacheService.findMessage(id);
    }

    /**
     * 测试缓存2
     *
     * @param id 缓存对应唯一参数
     * @return message vo
     */
    @RequestMapping(value = "add2/{id}", method = RequestMethod.GET)
    public String message2(@PathVariable("id") Integer id) {
        return cacheService.findMessage2(id);
    }

    /**
     * 删除缓存
     *
     * @param id 缓存对应唯一参数
     * @return success
     */
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String messageDel(@PathVariable("id") Integer id) {
        return cacheService.delMessage(id);
    }

    /**
     * 获取redis中的值
     *
     * @param key key
     * @return value
     */
    @RequestMapping(value = "get/{key}", method = RequestMethod.GET)
    public String message(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
