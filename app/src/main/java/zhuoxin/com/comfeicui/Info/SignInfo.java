package zhuoxin.com.comfeicui.Info;

/**
 * Created by Administrator on 2016/11/10.
 */

public class SignInfo  {
    String date;
    String local;
 String localdate;

    public SignInfo(String date, String local, String localdate) {
        this.date = date;
        this.local = local;
        this.localdate = localdate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    @Override
    public String toString() {
        return "SignInfo{" +
                "date='" + date + '\'' +
                ", local='" + local + '\'' +
                ", localdate='" + localdate + '\'' +
                '}';
    }
}
