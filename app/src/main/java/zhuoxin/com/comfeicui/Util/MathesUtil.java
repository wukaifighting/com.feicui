package zhuoxin.com.comfeicui.Util;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/7.
 */

public class MathesUtil  {
    //用户名的验证
    public  static  String name(){
         Scanner s= new Scanner(System.in);
        String name=s.next();
        while (!name.matches("[a-zA-Z]{1,10}")){
            System.out.println("您输入信息有误，请重新输入");
            System.out.println("请您重新输入，1至10位字母");
              name=s.next();

        }
                return  name;
    }
    //密码验证
    public  static  String password(){
        Scanner d= new Scanner(System.in);
        String name=d.next();
        while (!name.matches("[0-9]{1,9}")){
            System.out.println("您输入信息有误，请重新输入");
            System.out.println("请您重新输入，1至10位字母");
            name=d.next();

        }
        return  name;
    }
}
