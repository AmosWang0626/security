package cn.amos.security.core.pojo.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * PROJECT: security
 * DESCRIPTION: security
 *
 * @author Daoyuan
 * @date 2020-03-26
 */
@Data
public class MessageVO {
    /**
     * id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 时间戳
     */
    private Long time;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
