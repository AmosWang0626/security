package cn.amos.security.common.generic;

/**
 * NOTE: 应用错误码
 * PROJECT: security
 *
 * @author AMOS
 * @date 2018/8/7
 */
public enum ExceptionCode {
    /***/
    NAME_NOT_NULL("P001", "用户名不能为空");

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
