package cn.amos.security.core.config;

import cn.amos.security.dao.entity.UserEntity;
import cn.amos.security.dao.mapper.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;

/**
 * DESCRIPTION: 数据初始化
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/18
 */
@Configuration
public class DataInitConfig {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "000000";

    @PostConstruct
    public void init() {
        UserEntity defaultUser = userRepository.findByUsername(DEFAULT_USERNAME);

        if (Objects.isNull(defaultUser)) {
            UserEntity userEntity = new UserEntity()
                    .setUsername(DEFAULT_USERNAME)
                    .setPassword(passwordEncoder.encode(DEFAULT_PASSWORD))
                    .setName(DEFAULT_USERNAME.toUpperCase())
                    .setStatus(1);

            userRepository.save(userEntity);
        }
    }

}
