package cn.amos.security.core.service;

/**
 * PROJECT: security
 *
 * @author Daoyuan
 * @apiNote 城市 Service
 * @date 2018/2/9
 */
public interface CityService {

    /**
     * 添加城市
     *
     * @param name 城市名字
     * @return 保存状态
     */
    String addCity(String name);
}
