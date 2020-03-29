package cn.amos.security.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION: Security Controller
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/29
 */
@RestController
public class SecurityController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

}
