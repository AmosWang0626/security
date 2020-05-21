package cn.amos.security.web.controller;

import cn.amos.security.common.generic.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * NOTE: 类说明
 * PROJECT: security
 *
 * @author AMOS
 * @date 2018/8/10
 */
@Api(tags = "A01 接口")
@RestController
@RequestMapping("api")
public class ApiController {

    private static final ThreadLocal<DateFormat> FORMAT_YEAR_2_SECOND =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * GET none
     *
     * @param name    名字
     * @param content 内容
     * @return 通用返回
     */
    @ApiOperation("接收参数无注解")
    @GetMapping(value = "none")
    public GenericResponse<String> none(String name, String content) {
        return genericRequest(name, content);
    }

    /**
     * GET PathParam
     *
     * @param name    名字
     * @param content 内容
     * @return 通用返回
     */
    @ApiOperation("@PathParam——接收参数")
    @GetMapping(value = "pathParam")
    public GenericResponse<String> pathParam(@PathParam("name") String name, @PathParam("content") String content) {
        return genericRequest(name, content);
    }

    /**
     * GET PathVariable
     *
     * @param name    名字
     * @param content 内容
     * @return 通用返回
     */
    @ApiOperation("@PathVariable——接收参数")
    @GetMapping(value = "pathVariable/{name}/{content}")
    public GenericResponse<String> pathVariable(@PathVariable("name") String name, @PathVariable("content") String content) {
        return genericRequest(name, content);
    }

    /**
     * GET RequestParam
     *
     * @param name    名字
     * @param content 内容
     * @return 通用返回
     */
    @ApiOperation("@RequestParam——接收参数")
    @GetMapping(value = "requestParam")
    public GenericResponse<String> requestParam(@RequestParam("name") String name, @RequestParam("content") String content) {
        return genericRequest(name, content);
    }

    /**
     * 生成返回结果
     */
    private GenericResponse<String> genericRequest(String name, String content) {
        if (StringUtils.isAnyBlank(name, content)) {
            return GenericResponse.ERROR_PARAM;
        }

        String str = MessageFormat.format("name: {0}, content:{1}, time:{2}",
                name, content, FORMAT_YEAR_2_SECOND.get().format(new Date()));

        return new GenericResponse<>(str);
    }

}
