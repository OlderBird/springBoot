package cn.aq.springboot.exception;

/**自定义异常类*/
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
