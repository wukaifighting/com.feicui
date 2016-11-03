package zhuoxin.com.comfeicui.Util;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import zhuoxin.com.comfeicui.interfacea.HttpInterface;

/**
 * Created by Administrator on 2016/11/2.
 */

public class HttpUtil  {

    public void getconnection (String url, final HttpInterface listinterface, RequestQueue requestQueue){
        //
        StringRequest    request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response ) {
                //如果成功
              listinterface.getresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("-----","error"+error.getMessage());
            }
        });
   requestQueue.add(request);

    }

    public  void startconnection(String url, final String name, final String password, final HttpInterface lister, RequestQueue requestQueue){
  StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
         lister.getresponse(response);
      }
  }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
              Log.e("post","post"+error);
      }
  }){
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
       Map<String,String> map=new  HashMap<>();
          map.put("ver","1");
          map.put("uid",name);
          map.put("pwd",password);
          map.put("device","0");
          return  map;

      }
  };
          requestQueue.add(request);
    }
}
