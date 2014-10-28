package ua.umbrella.englishverb.service;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ua.umbrella.englishverb.object.Twin;

public class RemoteService
{
  private static String url = "http://englishverb-alonmack.rhcloud.com/get";

  private static final String TAG_TWIN = "twins";
  private static final String TAG_ID = "id";
  private static final String TAG_ENGLISH = "english";
  private static final String TAG_RUSSIAN = "russian";

  static InputStream inputStream = null;
  static JSONObject jo = null;
  static String json = "";

  JSONArray ja = null;
  List<Twin> twin;

  public List<Twin> getTwinsFromJson() {
    JSONObject json = getJson(url);
    twin = new ArrayList<Twin>();
    try {
      ja = json.getJSONArray(TAG_TWIN);
      for(int i=0; i< ja.length(); i++)
      {
        JSONObject c = ja.getJSONObject(i);
        int id = c.getInt(TAG_ID);
        String english = c.getString(TAG_ENGLISH);
        String russian = c.getString(TAG_RUSSIAN);
        twin.add(new Twin(id, english, russian));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return twin;
  }

  private JSONObject getJson(String url) {
    try {
      DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpPost httpPost = new HttpPost(url);
      HttpResponse httpResponse = httpClient.execute(httpPost);
      HttpEntity httpEntity = httpResponse.getEntity();
      inputStream = httpEntity.getContent();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(inputStream, "UTF-8"), 8);
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      inputStream.close();
      json = "{ \"twins\" : " + sb.toString() + " }";
    } catch (Exception e) {
      Log.e("Buffer Error", "Error converting result " + e.toString());
    }
    try {
      jo = new JSONObject(json);
    } catch (JSONException e) {
      Log.e("JSON Parser", "Error parsing data " + e.toString());
    }
    return jo;
  }
}
