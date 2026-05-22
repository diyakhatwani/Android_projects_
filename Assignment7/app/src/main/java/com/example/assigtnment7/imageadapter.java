package com.example.assigtnment7;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class imageadapter extends BaseAdapter{

    ArrayList<Uri> arrayList;
    LayoutInflater inflater;
    Context context;

    public imageadapter(Context context,ArrayList<Uri> arrayList)
    {
        this.arrayList=arrayList;
        this.context=context;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    public Object getItem(int i){
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public View getView(int i, View view, ViewGroup viewGroup){
        View view1=view;
        if(view1==null){
            view1 = inflater.inflate(R.layout.image_items , viewGroup,false);

        }
        ImageView imageView=view1.findViewById(R.id.image);
        imageView.setImageURI(arrayList.get(i));

        return view1;
    }

}
