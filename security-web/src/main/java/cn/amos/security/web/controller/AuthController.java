package cn.amos.security.web.controller;

import cn.amos.security.common.utils.EncryptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2018/12/13
 */
@Api(tags = "C01 模拟第三方登录")
@Controller
@RequestMapping("auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private static final String CODE_KEY = "CODE2018";
    private static final String TOKEN_KEY = "TOKEN2018";
    private static Map<String, User> USER_MESSAGE = new HashMap<>(4);

    /*
     * 模拟 QQ 的用户数据
     */
    static {
        USER_MESSAGE.put("18937128861", new User("18937128861", "123456", "AMOS"));
        USER_MESSAGE.put("18937128862", new User("18937128862", "123456", "WATER"));
        USER_MESSAGE.put("111", new User("111", "111", "HELLO"));
    }

    /*
     * 1.click sign with QQ                         IM callback QQ sign link
     * 2.request QQ by [account, password]          QQ callback code
     * 3.request QQ by [code]                       QQ callback token
     * 4.request QQ by [token]                      QQ callback QQ user info
     */

    @ApiOperation("跳转到登录页面")
    @GetMapping
    public String authLogin() {
        return "AuthLogin";
    }

    @ApiOperation("正常登录")
    @GetMapping("normal/{account}/{password}")
    @ResponseBody
    public String normal(@PathVariable("account") String account, @PathVariable("password") String password) throws IOException {
        return account + " 登录成功!";
    }

    @ApiOperation("QQ登录-01")
    @GetMapping("qq1/sign/{account}/{password}")
    @ResponseBody
    public void qqSign(@PathVariable("account") String account, @PathVariable("password") String password, HttpServletResponse response) throws IOException {
        LOGGER.info(MessageFormat.format("QQ登录! 账号: {0}, 密码: {1}", account, password));
        // code
        String code = EncryptionUtil.encrypt(account, password);
        LOGGER.info("QQ callback code " + code);
        response.sendRedirect("/auth/qq/getToken/" + code);
    }

    @ApiOperation("QQ登录-02[根据QQ返回的code，请求QQ用户token]")
    @GetMapping("qq2/getToken/{code}")
    @ResponseBody
    public void getToken(@PathVariable("code") String code, HttpServletResponse response) throws IOException {
        String account = EncryptionUtil.decrypt(code, CODE_KEY);
        // token
        String token = EncryptionUtil.encrypt(account, TOKEN_KEY);
        LOGGER.info("QQ callback token " + token);
        response.sendRedirect("/auth/qq/getUserMessage/" + token);
    }

    @ApiOperation("QQ登录-03[根据QQ返回的token，请求QQ用户信息]")
    @GetMapping("qq3/getUserMessage/{token}")
    @ResponseBody
    public void getUserMessage(@PathVariable("token") String token, HttpServletResponse response) throws IOException {
        String account = EncryptionUtil.decrypt(token, TOKEN_KEY);
        User user = USER_MESSAGE.get(account);
        if (user != null) {
            LOGGER.info(user.getName() + " 通过 QQ 登录 IM 成功!");
            response.sendRedirect("/auth/real/login/" + user.getName());
        } else {
            response.sendRedirect("/auth/qq/error");
        }
    }

    @ApiOperation("QQ登录-04[获取QQ用户信息成功，提示用户登录成功]")
    @GetMapping("qq4/login/{name}")
    @ResponseBody
    public String getUserMessage(@PathVariable("name") String name) {
        return name + " 登录成功!";
    }

    @ApiOperation("QQ登录-04[获取QQ用户信息失败，提示QQ账号或密码错误]")
    @GetMapping("qq4/error")
    @ResponseBody
    public String getUserMessage() {
        return "QQ账号或密码错误!";
    }

    @Data
    private static class User {
        private String account;
        private String password;
        private String name;

        User(String account, String password, String name) {
            this.account = account;
            this.password = password;
            this.name = name;
        }
    }

}
