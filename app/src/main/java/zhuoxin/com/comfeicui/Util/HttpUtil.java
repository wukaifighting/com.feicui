package zhuoxin.com.comfeicui.Util;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import zhuoxin.com.comfeicui.interfacea.HttpInterface;

/**
 * Created by Administrator on 2016/11/2.
 */

public class HttpUtil  {
    public static void getconnection (String url, final HttpInterface listinterface,RequestQueue requestQueue){
        //
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
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

    }
}
