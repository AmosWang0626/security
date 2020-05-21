package cn.amos.security.dao.entity;

import cn.amos.security.common.api.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * DESCRIPTION: User
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/26
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@Entity
@Table(name = "org_user")
public class UserEntity extends BaseEntity implements UserDetails {

    private String username;
    private String password;
    private String name;
    private Integer age;
    /**
     * 0: 禁用; 1: 启用
     */
    private Integer status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getStatus() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getStatus() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getStatus() == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.getStatus() == 1;
    }
}
