package learn.bean;

import java.io.Serializable;

public class Test implements Serializable {
    private User data;
    private int code;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Test{" +
                "data=" + data +
                ", code=" + code +
                '}';
    }
}
