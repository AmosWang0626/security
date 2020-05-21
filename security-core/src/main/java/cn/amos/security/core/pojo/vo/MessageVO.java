package cn.amos.security.core.pojo.vo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "ID", required = true, example = "1433233")
    private Integer id;

    @ApiModelProperty(value = "标题", example = "岳阳楼记")
    private String title;

    @ApiModelProperty(value = "内容", example = "先天下之忧而忧，后天下之乐而乐。")
    private String content;

    @ApiModelProperty(value = "时间戳", hidden = true)
    private Long time;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
