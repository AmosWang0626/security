package cn.amos.security.core.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 模块名称: Security
 * 模块描述: SecurityUser
 *
 * @author amos.wang
 * @date 2020/3/26 17:42
 */
@Getter
@Setter
public class SecurityUser implements UserDetails {

    private String username;

    private String password;
    /**
     * 账号状态
     * 0 过期 Expired
     * 1 正常
     * 2 锁定 Locked
     */
    private Integer status;
    /**
     * 认证状态
     */
    private Integer certificateFlag;

    public SecurityUser(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账号是否过期
     *
     * @return true 正常
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否锁定
     *
     * @return true 正常
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 认证是否过期
     *
     * @return true 正常
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否激活
     *
     * @return true 正常
     */
    @Override
    public boolean isEnabled() {
        return status == 1;
    }

}
