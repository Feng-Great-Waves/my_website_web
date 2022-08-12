package com.sentiment.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static cn.hutool.http.HttpStatus.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private T data;
    private String message;

    public static <T> Result<T> ok() {
        return new Result<T>(HTTP_OK, null, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(HTTP_OK, data, null);
    }
    public static <T> Result<T> ok(T data,String message) {
        return new Result<T>(HTTP_OK, data, message);
    }

    /**
     * 错误500
     * @param message 信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String message) {
        return new Result<T>(HTTP_INTERNAL_ERROR, null, message);
    }

    public static <T> Result<T> authFail(String message) {
        return new Result<T>(HTTP_UNAUTHORIZED, null, message);
    }

}
