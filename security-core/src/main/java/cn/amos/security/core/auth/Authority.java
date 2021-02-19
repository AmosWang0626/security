package cn.amos.security.core.auth;

/**
 * 权限常量类
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/2/19
 */
public interface Authority {

    String READ = "READ";
    String WRITE = "WRITE";
    String DELETE = "DELETE";
    /**
     * 授权（也就是给其他人分配权限）
     */
    String GRANT = "GRANT";

}
