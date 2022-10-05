package com.zbinyds.servicebase.exceptionHandler;

import com.zbinyds.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zbinyds
 * @time 2022/09/13 22:59
 *
 * 全局异常处理器（Mvc）
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     * @param e：异常对象
     * @return：返回异常信息提示
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace(); // 控制台打印异常信息
        return R.failed().message("发生了未知异常...");
    }

    /**
     * 自定义异常处理
     * @param e：自定义异常对象（QiHangException）
     * @return：返回异常信息提示
     */
    @ExceptionHandler(QiHangException.class)
    @ResponseBody
    public R error(QiHangException e){
        log.error(e.getMessage()); // 将异常信息输出到日志文件中
        e.printStackTrace(); // 控制台打印异常信息
        return R.failed().code(e.getCode()).message(e.getMsg());
    }
}
