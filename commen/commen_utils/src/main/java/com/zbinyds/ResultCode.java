package com.zbinyds;

/**
 * @author zbinyds
 * @time 2022/09/13 19:18
 *
 * 响应状态码-枚举类
 * 20000-成功；20001-失败。
 */
public enum ResultCode {
    SUCCESS("20000"),FAILED("20001");

    private String code;

    ResultCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
