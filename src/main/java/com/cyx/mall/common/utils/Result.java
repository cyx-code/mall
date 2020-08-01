package com.cyx.mall.common.utils;

/**
 * @description: 响应体枚举
 * @author: cyx
 * @create: 2020/07/31
 */
public enum Result implements IResult {

    SUCCESS(200, "操作成功"),

    ERROR(500, "操作失败"),

    VALIDATE_FAILED(404, "参数检验失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    FORBIDDEN(403, "没有相关权限");

    private Integer code;

    private String message;

    /**
     * @Author: cyx
     * @Description: 枚举类构造方法
     * @Date: 2020-07-31
     * @param: code
     * @param: message
     */
    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
