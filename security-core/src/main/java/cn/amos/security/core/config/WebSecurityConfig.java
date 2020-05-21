package cn.amos.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 模块名称: WebSecurityConfig
 * 模块描述: WebSecurityConfig
 *
 * @author amos.wang
 * @date 2020/3/26 16:43
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers("/auth/**", "/static/**", "/v2/api-docs",
                        "/webjars/js/**", "/webjars/css/**", "/swagger-resources/**").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().formLogin().permitAll() // 使用自带 formLogin
                .and().logout().permitAll();
        // 关闭CSRF，使得 Swagger RestfulApi 正常运行
        security.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}