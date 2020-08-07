package com.esrayakut.habersayfasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.esrayakut.habersayfasi.adapters.HaberAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView haberListesi;

    public static String[] baslik = new String[10];
    public static String[] icerik = new String[10];
    public static String[] resim = new String[10];
    public static String[] yazar = new String[10];
    public static String[] tarih = new String[10];
    public static int index;

//    ArrayList<String> baslik = new ArrayList<String>();
//    ArrayList<String> icerik = new ArrayList<String>();
//    int[] resim = {R.drawable.person, R.drawable.person, R.drawable.person, R.drawable.person};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haberListesi = (ListView)findViewById(R.id.haber_listesi);

        RequestQueue istekKuyrugu = Volley.newRequestQueue(this);
        String url = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-07-23&sortBy=publishedAt&apiKey=830f45077f4c4b71a7ccdc957389b0b6";
        JsonObjectRequest istek = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray articles = response.getJSONArray("articles");
                            for (int i = 0; i < 10; i++) {
                                JSONObject news = articles.getJSONObject(i);
                                baslik[i] = news.getString("title");
                                icerik[i] = news.getString("content");
                                resim[i] = news.getString("urlToImage");
                                yazar[i] = news.getString( "author");
                                tarih[i] = news.getString("publishedAt");
//                                baslik.add(news.getString("Title"));
//                                icerik.add(news.getString("Description"));
                                Log.d("baslik", resim[i]);
                            }
                            HaberAdapter adapter = new HaberAdapter(MainActivity.this, baslik, icerik, resim);
                            haberListesi.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", "onErrorResponse metodunda");
                    }
                });

        istekKuyrugu.add(istek);

        haberListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                startActivity(new Intent(MainActivity.this, Haber.class));
            }
        });
    }
}

//        JsonObjectRequest istek = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray contacts = response.getJSONArray("contacts");
//                    for (int i = 0; i < contacts.length(); i++) {
//                    }
//                    HaberAdapter adapter = new HaberAdapter(MainActivity.this, baslik, icerik, resim);
//                    haberListesi.setAdapter(adapter);
//                    Log.d("sonuc", baslik[0]);
//                } catch (JSONException e) {
//                    e.printStackTrace();        // Kullanıcı kesinlikle görmemeli!..
//                }
//                Log.d("sonuc", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) ;

//        {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map headers = new HashMap();
//                headers.put("key", "value");
//                return headers;
//            }
//        } ;
// POST metodu için
