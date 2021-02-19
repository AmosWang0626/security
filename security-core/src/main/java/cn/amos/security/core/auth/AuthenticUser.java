package cn.amos.security.core.auth;

import cn.amos.security.dao.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * 认证用户模型
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/19
 */
public class AuthenticUser extends UserEntity implements UserDetails {

    /**
     * 该用户拥有的授权，譬如读取权限、修改权限、增加权限等等
     */
    private final Collection<GrantedAuthority> authorities = new HashSet<>();

    public AuthenticUser() {
        super();
        authorities.add(new SimpleGrantedAuthority(Role.USER));
        authorities.add(new SimpleGrantedAuthority(Authority.READ));
    }

    public AuthenticUser(UserEntity origin) {
        this();
        BeanUtils.copyProperties(origin, this);
        // 用户名为admin则给管理员权限
        if ("admin".equals(getUsername())) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN));
            authorities.add(new SimpleGrantedAuthority(Authority.WRITE));
            authorities.add(new SimpleGrantedAuthority(Authority.DELETE));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return this.getStatus() == 1;
    }

}
