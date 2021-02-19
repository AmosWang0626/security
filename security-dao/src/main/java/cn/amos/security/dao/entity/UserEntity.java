package cn.amos.security.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

/**
 * DESCRIPTION: User
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/26
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "security_user")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(generator = "base-uuid")
    @GenericGenerator(name = "base-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

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
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_dev");
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
