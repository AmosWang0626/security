package cn.amos.security.core.service;

import cn.amos.security.core.pojo.vo.MessageVO;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2020-03-26
 */
public interface CacheService {

    /**
     * 获取message。
     * 如果缓存里有，就从缓存中取；如果没有，就获取message并放入缓存
     *
     * @param id 缓存后缀id
     * @return message
     */
    String findMessage(Integer id);

    /**
     * 获取message，并放入缓存。
     *
     * @param id 缓存后缀id
     * @return message
     */
    String findMessage2(Integer id);

    /**
     * 获取message，并放入缓存。
     *
     * @param vo 缓存信息
     * @return message
     */
    String findMessage3(MessageVO vo);

    /**
     * 删除 message 缓存
     *
     * @param id 缓存后缀id
     * @return 删除状态
     */
    String delMessage(Integer id);

    /**
     * none
     *
     * @param id 缓存后缀id
     */
    void groupMessage(Integer id);
}
