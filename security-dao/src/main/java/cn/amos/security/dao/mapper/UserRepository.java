package cn.amos.security.dao.mapper;

import cn.amos.security.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @date 2018/2/9
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query("from UserEntity where username=?1")
    UserEntity findByUsername(String username);

}
