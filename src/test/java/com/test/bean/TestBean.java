package com.test.bean;

import java.io.Serializable;

public class TestBean implements Serializable {

    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "token='" + token + '\'' +
                '}';
    }
}
