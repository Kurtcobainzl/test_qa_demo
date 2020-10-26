package com.test.http;

import java.io.Serializable;

public class FailBean implements Serializable {
    private int code;
    private String desc;
    public static final int DEFAULT_CODE = -1;
    public static final int NET_ERROR = 10000;

    public FailBean() {

    }

    public FailBean(String desc) {
        this.code = DEFAULT_CODE;
        this.desc = desc;
    }

    public FailBean(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "FailBean{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
