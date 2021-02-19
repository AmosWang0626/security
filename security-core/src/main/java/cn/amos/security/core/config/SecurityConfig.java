package cn.amos.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;

/**
 * PROJECT: security
 * DESCRIPTION: SecurityConfig
 *
 * @author amos.wang
 * @date 2020/3/26 16:43
 */
@Configuration
public class SecurityConfig {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String CHECK_EXIST_SQL =
            "SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_name = 'PERSISTENT_LOGINS'";

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setJdbcTemplate(jdbcTemplate);

        // 初始化 "记住我" 表，只有表不存在时才初始化
        Integer exist = jdbcTemplate.queryForObject(CHECK_EXIST_SQL, Integer.class);
        jdbcTokenRepository.setCreateTableOnStartup(exist == null || exist == 0);

        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}