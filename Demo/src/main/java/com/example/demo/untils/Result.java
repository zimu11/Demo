package com.example.demo.untils;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : mft
 * @create 2023/7/25 12:43
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 20000);
        put("message", "成功");
        put("data", new ArrayList<String>());
    }

    public static Result error() {
        return error(500, "未知异常，请联系管理员");
    }
    public static Result loginError() {
        return error(500, "登录失败，请检查用户名或密码是否正确");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("message", msg);
        return r;
    }
    public Result setData(Object data){
        put("data", data);
        return this;
    }
    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getCode() {
        return (Integer)this.get("code");
    }
}

