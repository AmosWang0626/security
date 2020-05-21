package cn.amos.security.web.controller;

import cn.amos.security.common.generic.GenericResponse;
import cn.amos.security.core.pojo.vo.MessageVO;
import cn.amos.security.core.service.CacheService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2018/11/16
 */
@Api(tags = "B01 缓存")
@RestController
@RequestMapping("caches")
public class CacheController {

    @Resource
    private CacheService cacheService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @ApiOperation("添加——如果缓存中有则不会添加，并返回缓存中的数据")
    @PostMapping(value = "add")
    public String message(Integer id) {
        return cacheService.findMessage(id);
    }

    @ApiOperation("添加——无条件添加")
    @PostMapping(value = "add2")
    public String message2(Integer id) {
        return cacheService.findMessage2(id);
    }

    @ApiOperation("添加——无条件添加")
    @PostMapping(value = "add3")
    public String message3(@RequestBody MessageVO vo) {
        return cacheService.findMessage3(vo);
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping(value = "del/{id}")
    public String messageDel(@PathVariable("id") Integer id) {
        return cacheService.delMessage(id);
    }

    @ApiOperation("根据KEY获取")
    @GetMapping(value = "get/{key}")
    public String message(@PathVariable("key") String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return JSON.toJSONString(GenericResponse.ERROR_PARAM);
        }

        return value;
    }

}
