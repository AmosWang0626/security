package cn.amos.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @date 2018/2/9
 */
@Controller
public class OauthController {

    @RequestMapping("thy")
    public String oauth(ModelMap modelMap) {
        modelMap.addAttribute("msg", "啦啦啦");
        return "Oauth";
    }

}
