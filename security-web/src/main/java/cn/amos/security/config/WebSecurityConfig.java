package cn.amos.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * DESCRIPTION: 控制资源访问配置
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/18
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 开放 swagger 和 h2database 相关资源访问（当然有些不安全，生产环境一般不会开放 swagger）
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                // 设置同源策略，用于 h2 管理后台页面加载
                .headers().frameOptions().sameOrigin()
                .and()
                // 跨域访问
                .csrf().ignoringAntMatchers("/h2/**", "/swagger/**")
                .and()
                .authorizeRequests()
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/v2/api-docs", "/webjars/js/**", "/webjars/css/**", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout().permitAll();
    }

}
