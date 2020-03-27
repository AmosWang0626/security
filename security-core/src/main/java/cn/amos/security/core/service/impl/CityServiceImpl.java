package cn.amos.security.core.service.impl;

import cn.amos.security.core.service.CityService;
import cn.amos.security.dao.entity.CityEntity;
import cn.amos.security.dao.mapper.CityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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
    private CityRepository cityRepository;

    @Override
    public String addCity(String name) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(name);
        cityEntity.setCreateTime(LocalDateTime.now());
        cityRepository.save(cityEntity);
        return "保存城市" + name + "成功!";
    }
}
