package cn.amos.security.core.service.impl;

import cn.amos.security.dao.entity.CityEntity;
import cn.amos.security.dao.mapper.CityMapper;
import cn.amos.security.core.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @apiNote 城市 Service Implement
 * @date 2018/2/9
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public String addCity(String name) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(name);
        cityEntity.setCreateTime(new Date());
        cityMapper.save(cityEntity);
        return "保存城市" + name + "成功!";
    }
}
