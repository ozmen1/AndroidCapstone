package com.esrayakut.habersayfasi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.esrayakut.habersayfasi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HaberAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    String[] aBaslik;
    String[] aIcerik;
    String[] aResim;

//    ArrayList<String> aBaslik = new ArrayList<String>();
//    ArrayList<String> aIcerik = new ArrayList<String>();
//    ArrayList<String> aResim = new ArrayList<String>();

    public HaberAdapter(Context context, String[] aBaslik, String[] aIcerik, String[] aResim) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.aBaslik = aBaslik;
        this.aIcerik = aIcerik;
        this.aResim = aResim;
    }

    @Override
    public int getCount() {
        return aBaslik.length;
    }

    @Override
    public Object getItem(int i) { return aBaslik[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satir = layoutInflater.inflate(R.layout.habercik ,null);
        ImageView resim = satir.findViewById(R.id.imageView);
        TextView baslik = satir.findViewById(R.id.textView);
        TextView icerik = satir.findViewById(R.id.textView2);

        Picasso.get().load(aResim[i]).into(resim);
        baslik.setText(aBaslik[i]);
        icerik.setText(aIcerik[i]);

        return satir;
    }
}
