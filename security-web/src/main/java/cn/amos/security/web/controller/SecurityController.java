package cn.amos.security.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION: Security Controller
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/29
 */
@Api(tags = "Z01 基础信息")
@RestController
public class SecurityController {

    @GetMapping
    @ApiOperation("第一行代码")
    public String hello() {
        return "Hello World!";
    }

}
