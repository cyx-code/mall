package com.cyx.mall.common.utils;

import lombok.Data;


/**
 * @description: 响应实体
 * @author: cyx
 * @create: 2020/07/30
 */
@Data
public class R<T> {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public R() {}

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @Author: cyx
     * @Description: 返回操作成功
     * @Date: 2020-07-31
     * @param: message
     * @param: data
     * @return: com.cyx.mall.common.utils.R<T>
     */
    public static <T> R<T> success(String message, T data) {
        return response(Result.SUCCESS, message, data);
    }

    public static <T> R<T> success(T data) {
        return response(Result.SUCCESS, data);
    }

    public static <T> R<T> success(String message) {
        return response(Result.SUCCESS, message, null);
    }

    public static <T> R<T> success() {
        return response(Result.SUCCESS);
    }

    /**
     * @Author: cyx
     * @Description:
     * @Date: 2020-07-31
     * @param: message
     * @param: data
     * @return: com.cyx.mall.common.utils.R<T>
     */
    public static <T> R<T> response(IResult result) {
        return new R<>(result.getCode(), result.getMessage(), null);
    }

    private static <T> R<T> response(IResult result, T data) {
        return new R<>(result.getCode(), result.getMessage(), data);
    }

    private static <T> R<T> response(IResult result, String message, T data) {
        return new R<>(result.getCode(), message, data);
    }

    public static R error() {
        return response(Result.ERROR);
    }

    public static R error(String message) {
        return response(Result.ERROR, message, null);
    }

    /**
     * @Author: cyx
     * @Description: 参数校验失败
     * @Date: 2020-07-31
     * @param:
     * @return: com.cyx.mall.common.utils.R<T>
     */
    public static <T> R<T> validate() {
        return response(Result.VALIDATE_FAILED);
    }

    /**
     * @Author: cyx
     * @Description: 登录异常
     * @Date: 2020-07-31
     * @param: data
     * @return: com.cyx.mall.common.utils.R<T>
     */
    public static <T> R<T> unauthorized(T data) {
        return response(Result.UNAUTHORIZED, data);
    }

    /**
     * @Author: cyx
     * @Description: 未授权
     * @Date: 2020-07-31
     * @param: data
     * @return: com.cyx.mall.common.utils.R<T>
     */
    public static <T> R<T> forbidden(T data) {
        return response(Result.FORBIDDEN, data);
    }


}
