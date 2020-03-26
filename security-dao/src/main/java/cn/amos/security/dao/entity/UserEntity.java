package cn.amos.security.dao.entity;

import cn.amos.security.common.api.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

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
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String name;
    private Integer age;
    /**
     * 0: 禁用; 1: 启用
     */
    private Integer status;

}
