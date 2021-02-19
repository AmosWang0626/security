package cn.amos.security.core.auth;

import cn.amos.security.dao.mapper.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 根据 用户名 从数据库加载用户信息 UserDetails，
 * 相应的 UserEntity 实现了 UserDetails
 *
 * @author amos.wang
 * @date 2020/3/30 12:32
 */
@Component
public class AuthenticUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByUsername(username))
                .map(AuthenticUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("用户不存在:" + username));
    }

}
