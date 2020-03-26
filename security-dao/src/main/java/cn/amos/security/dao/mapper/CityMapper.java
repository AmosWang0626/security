package cn.amos.security.dao.mapper;

import cn.amos.security.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @apiNote 城市 Mapper
 * @date 2018/2/9
 */
@Repository
public interface CityMapper extends CrudRepository<CityEntity, Long> {

    /**
     * find by name
     *
     * @param name name
     * @return result
     */
    List<CityEntity> findByName(String name);

    /**
     * update level by id
     *
     * @param id    id
     * @param level level
     * @return update column
     */
    @Query(value = "UPDATE #{#{entityName} SET `level` = ?1 WHERE id = ?2", nativeQuery = true)
    Integer updateById(Integer level, Integer id);

}
