package cn.amos.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
                .antMatchers("/auth/**", "/static/**").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().formLogin().permitAll() // 使用自带 formLogin
                .and().logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // authorities 权限
        manager.createUser(User.withUsername("amos").password("123").authorities("crud").build());
        manager.createUser(User.withUsername("amos").password("123").authorities("crud").build());

        return manager;
    }
}