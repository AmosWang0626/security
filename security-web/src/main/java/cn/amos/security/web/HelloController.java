package cn.amos.security.web;

import cn.amos.security.core.auth.Role;
import cn.amos.security.dao.entity.UserEntity;
import cn.amos.security.dao.mapper.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: Hello
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/18
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("index")
    public String index() {
        return "Hello Security!";
    }

    @GetMapping("update")
    @Secured({Role.ADMIN})
    @PreAuthorize("hasAnyAuthority('WRITE')")
    @PostAuthorize("hasAnyAuthority('GRANT')")
    public String update() {
        System.out.println("post test update...");
        return "Update Security!";
    }

    @GetMapping("getAll")
    @PreAuthorize("hasAnyAuthority('READ')")
    @PostFilter("filterObject.age != null and filterObject.age % 2 == 0")
    public List<UserEntity> getAll() {
        Iterable<UserEntity> iterable = userRepository.findAll();

        List<UserEntity> list = new ArrayList<>();
        iterable.forEach(list::add);

        return list;
    }

}
