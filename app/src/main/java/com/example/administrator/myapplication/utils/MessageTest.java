package com.example.administrator.myapplication.utils;

/**
 * Created by Administrator on 2018/5/17.
 */

public class MessageTest {

    /**
     * msg : 获取成功
     * data : 388490
     * status : 7
     */

    private String msg;
    private String data;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageTest{" +
                "msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
