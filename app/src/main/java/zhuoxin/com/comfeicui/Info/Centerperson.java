package zhuoxin.com.comfeicui.Info;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class Centerperson {
    String message;
    String status;
    List<Centerchild> data;

    public Centerperson() {
    }

    public Centerperson(String message, String status, List<Centerchild> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Centerchild> getData() {
        return data;
    }

    public void setData(List<Centerchild> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "person{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
