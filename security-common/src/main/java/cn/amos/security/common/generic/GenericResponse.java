package cn.amos.security.common.generic;

import lombok.Data;

import java.io.Serializable;

/**
 * NOTE: 通用返回类型
 * PROJECT: security
 *
 * @author AMOS
 * @date 2018/8/7
 */
@Data
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 5953956485853393849L;

    public static GenericResponse<String> SUCCESS = new GenericResponse<>("1000", "成功");
    public static GenericResponse<String> FAIL = new GenericResponse<>("1001", "失败");
    public static GenericResponse<String> ERROR_PARAM = new GenericResponse<>("1002", "传入参数校验失败");
    public static GenericResponse<String> ILLEGAL_REQUEST = new GenericResponse<>("1003", "非法请求");

    private String code;
    private String msg;
    private T body;

    /**
     * 应用于异常信息
     *
     * @param exception 异常码与异常信息
     */
    public GenericResponse(ExceptionCode exception) {
        this.code = exception.getCode();
        this.msg = exception.getMessage();
    }

    /**
     * 应用于请求成功,需要返回body的情况
     *
     * @param body 返回body
     */
    public GenericResponse(T body) {
        this.code = SUCCESS.getCode();
        this.msg = SUCCESS.getMsg();
        this.body = body;
    }

    /**
     * private
     * 应用于类中定义的static系统级信息
     *
     * @param code 请求状态码
     * @param msg  请求状态描述
     */
    private GenericResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
