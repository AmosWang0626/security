package cn.amos.security.dao.mapper;

import cn.amos.security.common.api.BaseRepository;
import cn.amos.security.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @date 2018/2/9
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, String> {

    @Query("from UserEntity where username=?1 and deleteFlag=false")
    UserEntity findByUsername(String username);

}
