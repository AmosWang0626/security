package cn.amos.security.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @apiNote 城市实体类
 * @date 2018/2/9
 */
@Data
@Entity(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 城市名字
     */
    private String name;
    /**
     * 城市级别
     */
    private Integer level;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 乐观锁Version
     */
    private Integer version;
}
