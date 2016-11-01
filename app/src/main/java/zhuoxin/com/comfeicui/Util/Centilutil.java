package zhuoxin.com.comfeicui.Util;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import zhuoxin.com.comfeicui.interfacea.Centerinterface;

/**
 * Created by Administrator on 2016/10/24.
 */

public class Centilutil extends AsyncTask<String, String, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String path = params[0];
        InputStream inputStream = null;
        StringBuffer buffer;
        HttpURLConnection urlConnection=null;

        try {
            URL url = new URL(path);
             urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                buffer = new StringBuffer();
                while ((len = inputStream.read(bytes)) != -1) {
                    buffer.append(new String(bytes, 0, len));

                }
         return  buffer.toString();
//                Log.e("--",buffer.toString());

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (urlConnection!=null){
                urlConnection.disconnect();
            }if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
              return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (null!=s&&null!=mtestinterface){
            mtestinterface.centerface(s);
            Log.e("iiiiii","s"+s);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    public Centerinterface mtestinterface;
    public void  Centilutil(Centerinterface mtestinterface){
        this.mtestinterface=mtestinterface;
    }
}
