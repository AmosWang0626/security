package cn.amos.security.config;

import cn.amos.security.core.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;

/**
 * DESCRIPTION: 控制资源访问配置
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/18
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PersistentTokenRepository persistentTokenRepository;

    /**
     * 开放 swagger 和 h2database 相关资源访问（当然有些不安全，生产环境一般不会开放 swagger）
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                // 权限访问
                .authorizeRequests()
                .antMatchers("/test/hello").permitAll()
                /// 权限测试(权限、角色)
                // .antMatchers("/test/index").hasAuthority("admin,manager")
                .antMatchers("/test/index").hasAnyAuthority("admin,manager")
                // .antMatchers("/test/index").hasRole("dev,ops")
                .antMatchers("/test/index").hasAnyRole("dev,ops")
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/v2/api-docs", "/webjars/js/**", "/webjars/css/**", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated()

                // 登录
                .and().formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index.html").permitAll()

                // 403
                .and().exceptionHandling().accessDeniedPage("/403.html")

                // 登出
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html").permitAll()

                // 记住我
                .and().rememberMe().tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(3600)
                .userDetailsService(userDetailsService)

                // 设置同源策略，用于 h2 管理后台页面加载
                .and().headers().frameOptions().sameOrigin()

                /// 跨域访问
                //.and().csrf().ignoringAntMatchers("/h2/**", "/swagger/**");
                .and().csrf().disable();
    }

}
