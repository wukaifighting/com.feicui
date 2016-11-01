package zhuoxin.com.comfeicui.Info;

/**
 * Created by Administrator on 2016/10/28.
 */

public class LeftfragmentInfo  {
    String name;
    String  ename;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }


    public LeftfragmentInfo(String name, String ename) {
        this.name = name;
        this.ename = ename;

    }

    @Override
    public String toString() {
        return "LeftfragmentInfo{" +
                "name='" + name + '\'' +
                ", ename='" + ename + '\'' +

                '}';
    }
}
