package cn.amos.security.core.service.impl;

import cn.amos.security.dao.mapper.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 模块名称: UserDetailsService
 * 模块描述: 根据用户名 加载用户信息 UserDetails
 *
 * @author amos.wang
 * @date 2020/3/30 12:32
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

}
