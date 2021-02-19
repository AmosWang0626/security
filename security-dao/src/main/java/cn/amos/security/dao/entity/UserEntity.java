package cn.amos.security.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class UserEntity {

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

}
