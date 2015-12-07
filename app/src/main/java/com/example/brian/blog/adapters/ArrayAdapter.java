package com.example.brian.blog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brian.blog.R;

import java.util.ArrayList;

/**
 * Created by Brian on 12/6/2015.
 */
public class ArrayAdapter extends android.widget.ArrayAdapter<String> {

    Context mContext;
    ArrayList<String> mArrayList;

    public ArrayAdapter(Context context, ArrayList<String> arrayList) {
        super(context, R.layout.items_list_blog,arrayList);
    };

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.items_list_blog, parent, false);
            holder = new ViewHolder();

            holder.itemName = (TextView)convertView.findViewById(R.id.itemTextView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemName.setText(mArrayList.get(position));

        return convertView;
    }

    private static class ViewHolder {
        TextView itemName;
    }
}
