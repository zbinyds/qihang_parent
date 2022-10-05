package com.zbinyds.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbinyds
 * @time 2022/09/14 10:30
 *
 * 自定义异常类 QiHangException -用于处理项目中的特殊异常
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QiHangException extends RuntimeException{
    private String code; // 状态码
    private String msg; // 异常信息
}
