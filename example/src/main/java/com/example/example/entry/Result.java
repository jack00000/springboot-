package com.example.example.entry;

public class Result<T> {
    //错误码
    private Integer code;
    //错误信息
    private String msg;
    //数据 T是个泛型
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
/*//通一异常处理 单个对象返回json举例
//错误时
{
     "code":1,
     "msg":"金额必传",
     "data":null
}
//正确时
{
        "code":0,
        "msg":"成功",
        "data":{
            "id":20,
             "cupSize":"B",
             "age":25,
             "money":1.2
        }
}*/
