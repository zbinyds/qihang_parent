package com.zbinyds;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbinyds
 * @time 2022/09/13 19:34
 * <p>
 * 后端统一返回给前端的数据对象
 */

@Data
public class R implements Serializable {

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("状态码")
    private String code;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 将构造器私有化，只能使用内部的提供的方法创建R对象。
    private R() {
    }

    // 成功
    public static R success() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.toString());
        r.setMessage("操作成功");
        return r;
    }

    // 失败
    public static R failed() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.FAILED.toString());
        r.setMessage("操作失败");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(String code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
