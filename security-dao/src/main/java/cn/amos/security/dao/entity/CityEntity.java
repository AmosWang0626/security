package cn.amos.security.dao.entity;

import cn.amos.security.common.api.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @apiNote 城市实体类
 * @date 2018/2/9
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@Entity
@Table(name = "dev_city")
public class CityEntity extends BaseEntity {

    /**
     * 城市名字
     */
    private String name;
    /**
     * 城市级别
     */
    private Integer level;

    /**
     * 乐观锁 Version
     */
    private Integer version;

}
