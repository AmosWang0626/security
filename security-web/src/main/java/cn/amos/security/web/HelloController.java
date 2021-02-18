package cn.amos.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION: Hello
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/18
 */
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

}
