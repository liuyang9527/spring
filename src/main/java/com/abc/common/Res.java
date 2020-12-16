package com.abc.common;

import lombok.Data;
import lombok.Value;

import java.security.Key;
import java.util.Map;

/**
 * 先添加Lombok依赖才能使用
 * 简化get和set
 * @param <T>
 */
@Data
public class Res<T> {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
//psvm直接出来
//    public static void main(String[] args) {
//        Res res = new Res();
//    }


    private Res(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //success
    public static<T> Res<T> success(ResEnum re, T data){
        return new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static Res success(ResEnum re){
        return new Res(re.getStatus(),re.getMsg());
    }
    public static Res success(){
        return new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMsg());
    }
    //error
    public static<T> Res<T> error(ResEnum re, T data){
        return new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static Res error(ResEnum re){
        return new Res(re.getStatus(),re.getMsg());
    }
    public static Res error(){
        return new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMsg());
    }
}
